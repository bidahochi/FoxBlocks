package com.bidahochi.BlockMod.blocks.displayframe.client;

import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.List;

final class DisplayFrameIconOutline
{
    // Bound the geometry a densely patterned custom item can add to each chunk.
    private static final int MAX_EDGES = 512;
    private static final ForgeDirection[] EDGE_DIRECTIONS =
            {ForgeDirection.WEST, ForgeDirection.EAST, ForgeDirection.UP, ForgeDirection.DOWN};
    final Edge[] edges;

    private DisplayFrameIconOutline(List<Edge> edges)
    {
        this.edges = edges.toArray(new Edge[edges.size()]);
    }

    /** Builds the extruded sides of a square ARGB sprite, or returns null for an empty or too complex outline. */
    static DisplayFrameIconOutline fromPixels(int[] pixels, int size)
    {
        List<Edge> edges = new ArrayList<>();
        for (ForgeDirection direction : EDGE_DIRECTIONS)
        {
            boolean withinEdgeLimit = scan(edges, pixels, size, direction);
            if (withinEdgeLimit == false)
            {
                return null;
            }
        }
        return edges.isEmpty() ? null : new DisplayFrameIconOutline(edges);
    }

    /** Merges straight runs of exposed edges in one direction and stops when the geometry budget is exhausted. */
    private static boolean scan(List<Edge> edges, int[] pixels, int size, ForgeDirection outward)
    {
        // Image rows increase downward. Reverse the run on east and up faces to keep outward winding.
        int neighborX = outward.offsetX;
        int neighborY = -outward.offsetY;
        boolean vertical = neighborX != 0;
        boolean reverse = neighborX > 0 || neighborY < 0;
        int boundaryOffset = neighborX > 0 || neighborY > 0 ? 1 : 0;
        for (int line = 0; line < size; line++)
        {
            int start = -1;
            for (int along = 0; along <= size; along++)
            {
                int x = vertical ? line : along;
                int y = vertical ? along : line;
                boolean exposed = opaque(pixels, size, x, y)
                        && opaque(pixels, size, x + neighborX, y + neighborY) == false;
                if (exposed && start < 0)
                {
                    start = along;
                }
                if (exposed == false && start >= 0)
                {
                    if (edges.size() == MAX_EDGES)
                    {
                        return false;
                    }
                    int boundary = line + boundaryOffset;
                    // Sample inside the opaque texels so the side keeps the color of the rim pixels.
                    double texelCenter = line + 0.5;
                    Point first = point(size, vertical, boundary, start, texelCenter, start + 0.01);
                    Point last = point(size, vertical, boundary, along, texelCenter, along - 0.01);
                    Point edgeStart = reverse ? last : first;
                    Point edgeEnd = reverse ? first : last;
                    edges.add(new Edge(outward, edgeStart, edgeEnd));
                    start = -1;
                }
            }
        }
        return true;
    }

    private static boolean opaque(int[] pixels, int size, int x, int y)
    {
        if (x < 0 || y < 0 || x >= size || y >= size)
        {
            return false;
        }
        int alpha = pixels[y * size + x] >>> 24;
        return alpha > 255 * DisplayFrameThumbnail.ALPHA_CUTOFF;
    }

    private static Point point(int size, boolean vertical, int boundary, int along, double acrossUV, double alongUV)
    {
        int pixelX = vertical ? boundary : along;
        int pixelY = vertical ? along : boundary;
        double x = pixelX * 2.0 / size - 1;
        double y = 1 - pixelY * 2.0 / size;
        double u = (vertical ? acrossUV : alongUV) * 16 / size;
        double v = (vertical ? alongUV : acrossUV) * 16 / size;
        return new Point(x, y, u, v);
    }

    static final class Edge
    {
        final ForgeDirection outward;
        final Point start;
        final Point end;

        Edge(ForgeDirection outward, Point start, Point end)
        {
            this.outward = outward;
            this.start = start;
            this.end = end;
        }
    }

    static final class Point
    {
        final double x;
        final double y;
        final double u;
        final double v;

        Point(double x, double y, double u, double v)
        {
            this.x = x;
            this.y = y;
            this.u = u;
            this.v = v;
        }
    }
}
