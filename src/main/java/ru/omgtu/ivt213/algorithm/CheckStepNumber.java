package ru.omgtu.ivt213.algorithm;

import ru.omgtu.ivt213.Cell;
import ru.omgtu.ivt213.CellsMap;

import java.util.Random;

public class CheckStepNumber extends CheckAlgorithm {

    int _i;

    CheckStepNumber(int i, CellsMap map, Algorithm lessAlgorithm, Algorithm equalsAlgorithm, Algorithm moreAlgorithm) {
        super(map, lessAlgorithm, equalsAlgorithm, moreAlgorithm);
        _i = i;
    }

    @Override
    protected int predicat(Cell parent) {
        if (parent.chieldNumber>_i) return 1;
        if (parent.chieldNumber<_i) return -1;
        return 0;
    }

    @Override
    protected void mutateParametr() {
        _i = new Random().nextInt(100);
    }
}
