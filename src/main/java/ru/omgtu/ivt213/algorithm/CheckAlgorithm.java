package ru.omgtu.ivt213.algorithm;

import ru.omgtu.ivt213.Cell;
import ru.omgtu.ivt213.CellsMap;
import ru.omgtu.ivt213.Main;

import java.util.Random;

public abstract class CheckAlgorithm implements Algorithm {
    private Algorithm _lessAlgorithm;
    private Algorithm _equalsAlgorithm;
    private Algorithm _moreAlgorithm;
    protected CellsMap _map;

    CheckAlgorithm(CellsMap map, Algorithm lessAlgorithm, Algorithm equalsAlgorithm, Algorithm moreAlgorithm) {
        _lessAlgorithm = lessAlgorithm;
        _equalsAlgorithm = equalsAlgorithm;
        _moreAlgorithm = moreAlgorithm;
        _map = map;
    }

    protected abstract int predicat(Cell parent);

    protected abstract void mutateParametr(); // метод для мутации параметра

    @Override
    public Cell[] getChield(Cell parent) {
        switch (predicat(parent)) {
            case -1:
                if (_lessAlgorithm == null) return null;
                return _lessAlgorithm.getChield(parent);
            case 0:
                if (_equalsAlgorithm == null) return null;
                return _equalsAlgorithm.getChield(parent);
            case 1:
                if (_moreAlgorithm == null) return null;
                return _moreAlgorithm.getChield(parent);
        }
        return null;
    }

    @Override
    public void mutate() {
        Random random = new Random();
        // если есть нулевые ветви то заполняем их
        if (_lessAlgorithm == null) {
            _lessAlgorithm = getRandomAlg(null, null, null);
            return;
        }
        if (_equalsAlgorithm == null) {
            _lessAlgorithm = getRandomAlg(null, null, null);
            return;
        }
        if (_moreAlgorithm == null) {
            _moreAlgorithm = getRandomAlg(null, null, null);
            return;
        }
        // если решит рандом то мутируем одину из ветвей
        if (random.nextInt(6) < 4) {
            getRandomBranch().mutate();
            return;
        }
        switch (random.nextInt(3)) {
            case 0:
                mutateParametr(); // мутируем параметр
                return;
            case 1:
                getRandomBranch().mutate(); // мутируем ветвь
                return;
            case 2:
                // добавляем ещё ветвь
                switch (random.nextInt(3)) {
                    case 0:
                        _lessAlgorithm = getRandomAlg(_lessAlgorithm, null, null);
                        return;
                    case 1:
                        _equalsAlgorithm = getRandomAlg(null, _equalsAlgorithm, null);
                        return;
                    case 2:
                        _moreAlgorithm = getRandomAlg(null, null, _moreAlgorithm);
                        ;
                        return;
                }
        }
    }

    private Algorithm getRandomBranch() {
        Random random = new Random();
        switch (random.nextInt(3)) {
            case 0:
                return _lessAlgorithm;
            case 1:
                return _equalsAlgorithm;
            case 2:
                return _moreAlgorithm;
        }
        return null;
    }

    private Algorithm getRandomAlg(Algorithm less, Algorithm equal, Algorithm more) {
        Random random = new Random();
        double[] angels = {-Math.PI / 2, 0, Math.PI / 2};
        Algorithm result;
        if (random.nextInt(2) == 0) {
            if (random.nextInt(2) == 0) {
                result = new CheckCellAroundCount(random.nextInt(9), _map, less, equal, more);
            } else {
                result = new CheckStepNumber(random.nextInt(9), _map, less, equal, more);
            }
        } else {
            if (random.nextInt() == 0) {
                result = new MultipliesAllDirections();
            } else {
                result = new MultipliesOneDirection(angels[random.nextInt(3)]);
            }
        }
        return result;
    }
}
