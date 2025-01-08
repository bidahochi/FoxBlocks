package com.bidahochi.BlockMod.blocks.roadpaints;

public enum EnumRoadShapes {
    straight("straight", "straight"),
    turn("turn", "turn"),
    tIntersection("tIntersection",  "t"),
    plus("plus", "plus"),
    diagonal("diagonal", "diagonal"),
    diagonalTurnLeft("diagonalTurnLeft", "diagonal_left"),
    diagonalTurnRight("diagonalTurnRight", "diagonal_right"),
    yIntersection("yIntersection", "y"),
    diagonalPlus("diagonalPlus", "dplus"),

    ;
    public String type;
    public String shortName;

    EnumRoadShapes(String type, String shortName)
    {
        this.type = type;
        this.shortName = shortName;
    }


}


