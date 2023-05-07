package ru.omgtu.ivt213;

import ru.omgtu.ivt213.algorithm.Algorithm;
import ru.omgtu.ivt213.algorithm.CheckCellAroundCount;
import ru.omgtu.ivt213.algorithm.MultipliesAllDirections;
import ru.omgtu.ivt213.algorithm.MultipliesOneDirection;
import ru.omgtu.ivt213.utils.Pair;
import ru.omgtu.ivt213.view.AppFrame;

import java.util.LinkedList;

public class Live {
    private CellsMap map = new CellsMap(100, 100);

    public CellsMap getResult(Algorithm alg) {

        map.addCell(new Pair<>(50, 50));
        //Algorithm alg = new CheckCellAroundCount(0,map,null,new MultipliesAllDirections(),new MultipliesOneDirection(0));
        LinkedList<Cell> cells = new LinkedList<>();
        cells.add(new Cell(50, 50));
        int counter = 0;
        while (!cells.isEmpty() && counter++ < 100) {
            for (var chield : alg.getChield(cells.get(0))) {
                map.addCell(new Pair<>(chield.x, chield.y));
                if (chield != null) cells.add(chield);
            }
            cells.remove(0);
        }
        return map;
    }

    public CellsMap getMap() {
        return map;
    }
}
