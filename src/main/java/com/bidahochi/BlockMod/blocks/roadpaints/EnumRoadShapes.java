package com.bidahochi.BlockMod.blocks.roadpaints;

public enum EnumRoadShapes {
    straight("straight"),
    turn("turn"),
    tIntersection("t"),
    plus("plus"),
    diagonal("diagonal"),
    diagonalTurnLeft("diagonalTurnLeft"),
    diagonalTurnRight("diagonalTurnRight"),
    yIntersection("yIntersection"),
    diagonalPlus("diagonalPlus"),

    ;
    public String type;

    EnumRoadShapes(String type) {
        this.type = type;
    }
}


