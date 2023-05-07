package ru.omgtu.ivt213.algorithm;

import ru.omgtu.ivt213.Cell;
import ru.omgtu.ivt213.CellsMap;
import ru.omgtu.ivt213.utils.Pair;

import java.util.Random;

public class CheckCellAroundCount extends CheckAlgorithm {
    private int _i;

    public CheckCellAroundCount(int i, CellsMap cellsMap, Algorithm lessAlgorithm, Algorithm equalsAlgorithm, Algorithm moreAlgorithm){
        super(cellsMap,lessAlgorithm,equalsAlgorithm,moreAlgorithm);
        _i = i;
    }
    @Override
    protected int predicat(Cell parent){
        Pair[] coords = new Pair[]{
                new Pair<>(parent.x, parent.y-1),
                new Pair<>(parent.x+1, parent.y-1),
                new Pair<>(parent.x+1, parent.y),
                new Pair<>(parent.x+1, parent.y+1),
                new Pair<>(parent.x, parent.y+1),
                new Pair<>(parent.x-1, parent.y+1),
                new Pair<>(parent.x-1, parent.y),
                new Pair<>(parent.x-1, parent.y-1)
        };
        int counter = 0;
        for (Pair cord: coords){
            if (_map.checkCell(cord)) counter++;
        }
        if (counter>_i) return 1;
        if (counter<_i) return -1;
        return 0;
    }

    @Override
    protected void mutateParametr() {
        _i = new Random().nextInt(9);
    }
}
