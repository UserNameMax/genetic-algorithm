package ru.omgtu.ivt213.algorithm;

import ru.omgtu.ivt213.Cell;

import java.util.Random;

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

    @Override
    public void mutate() {
        double[] angels = {-Math.PI / 2, 0, Math.PI / 2};
        _angle = angels[new Random().nextInt(3)];
    }
}
