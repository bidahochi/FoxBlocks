package com.bidahochi.BlockMod.blocks.roadpaints;

public enum EnumRoadShapes
{
    //regular lines
    straight("straight", "straight"),
    turn("turn", "turn"),
    tIntersection("tIntersection",  "t"),
    plus("plus", "plus"),
    diagonal("diagonal", "diagonal"),
    diagonalTurnLeft("diagonalTurnLeft", "diagonal_left"),
    diagonalTurnRight("diagonalTurnRight", "diagonal_right"),
    yIntersection("yIntersection", "y"),
    diagonalPlus("diagonalPlus", "dplus"),

    diagonal2("diagonal2", "diagonal2"),

    //details
    detail1("detail1", "dt1"),
    detail2("detail2", "dt2"),
    detail3("detail3", "dt3"),
    detail4("detail4", "dt4"),
    detail5("detail5", "dt5"),
    detail6("detail6", "dt6"),
    detail7("detail7", "dt7"),
    detail8("detail8", "dt8"),

    ;
    public String type;
    public String shortName;

    EnumRoadShapes(String type, String shortName)
    {
        this.type = type;
        this.shortName = shortName;
    }
}


