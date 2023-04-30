package ru.omgtu.ivt213.algorithm;

import ru.omgtu.ivt213.Cell;

public class CheckStepNumber extends CheckAlgorithm {

    int _i;

    CheckStepNumber(int i, Algorithm lessAlgorithm, Algorithm equalsAlgorithm, Algorithm moreAlgorithm) {
        super(lessAlgorithm, equalsAlgorithm, moreAlgorithm);
        _i = i;
    }

    @Override
    protected int predicat(Cell parent) {
        if (parent.chieldNumber>_i) return 1;
        if (parent.chieldNumber<_i) return -1;
        return 0;
    }
}
