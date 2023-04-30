package ru.omgtu.ivt213.algorithm;

import ru.omgtu.ivt213.Cell;
import ru.omgtu.ivt213.CellsMap;
import ru.omgtu.ivt213.utils.Pair;

public class CheckCellAroundCount extends CheckAlgorithm {
    private CellsMap _cellsMap;
    private int _i;

    public CheckCellAroundCount(int i, CellsMap cellsMap, Algorithm lessAlgorithm, Algorithm equalsAlgorithm, Algorithm moreAlgorithm){
        super(lessAlgorithm,equalsAlgorithm,moreAlgorithm);
        _cellsMap = cellsMap;
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
            if (_cellsMap.checkCell(cord)) counter++;
        }
        if (counter>_i) return 1;
        if (counter<_i) return -1;
        return 0;
    }
}
