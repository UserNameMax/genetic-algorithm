package ru.omgtu.ivt213.algorithm;

import ru.omgtu.ivt213.Cell;

public abstract class CheckAlgorithm implements Algorithm{
    private Algorithm _lessAlgorithm;
    private Algorithm _equalsAlgorithm;
    private Algorithm _moreAlgorithm;

    CheckAlgorithm(Algorithm lessAlgorithm, Algorithm equalsAlgorithm, Algorithm moreAlgorithm){
        _lessAlgorithm = lessAlgorithm;
        _equalsAlgorithm = equalsAlgorithm;
        _moreAlgorithm = moreAlgorithm;
    }

    protected abstract int predicat(Cell parent);

    @Override
    public Cell[] getChield(Cell parent) {
        switch (predicat(parent)){
            case -1:
                return _lessAlgorithm.getChield(parent);
            case 0:
                return _equalsAlgorithm.getChield(parent);
            case 1:
                return _moreAlgorithm.getChield(parent);
        }
        return null;
    }
}
