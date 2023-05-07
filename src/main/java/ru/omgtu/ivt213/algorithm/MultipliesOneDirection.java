package ru.omgtu.ivt213.algorithm;

import ru.omgtu.ivt213.Cell;

public class MultipliesOneDirection implements Algorithm {
    double _angle;

    public MultipliesOneDirection(double angle) {
        _angle = angle;
    }

    @Override
    public Cell[] getChield(Cell parent) {
        return new Cell[]{
                parent.copy(parent.x + (int) (parent.direction.first * Math.cos(_angle) - parent.direction.second * Math.sin(_angle)), parent.y + (int) (parent.direction.second * Math.cos(_angle) + parent.direction.first * Math.sin(_angle)))
        };
    }
}
