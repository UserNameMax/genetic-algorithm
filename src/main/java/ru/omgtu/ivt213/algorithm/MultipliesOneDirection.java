package ru.omgtu.ivt213.algorithm;

import ru.omgtu.ivt213.Cell;

public class MultipliesOneDirection implements Algorithm {
    double _angle;
    public MultipliesOneDirection(double angle){
        _angle = angle;
    }

    @Override
    public Cell[] getChield(Cell parent) {
        return new Cell[]{
                new Cell((int)(parent.x* Math.cos(_angle) - parent.y * Math.sin(_angle)),(int)(parent.y* Math.cos(_angle) + parent.x * Math.sin(_angle)))
        };
    }
}
