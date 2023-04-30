package ru.omgtu.ivt213;

import ru.omgtu.ivt213.algorithm.Algorithm;
import ru.omgtu.ivt213.algorithm.CheckCellAroundCount;
import ru.omgtu.ivt213.algorithm.MultipliesAllDirections;
import ru.omgtu.ivt213.algorithm.MultipliesOneDirection;
import ru.omgtu.ivt213.utils.Pair;
import ru.omgtu.ivt213.view.AppFrame;

public class Main {
    public static void main(String[] args) {
        CellsMap map = new CellsMap(10,10);
        AppFrame frame = new AppFrame(map);
        frame.setVisible(true);
        map.addCell(new Pair<>(5,5));
        Cell cell = new Cell(5,5);
        Algorithm alg = new CheckCellAroundCount(0,map,null,new MultipliesAllDirections(),new MultipliesOneDirection(0));
        Cell[] children = alg.getChield(cell);
        for (Cell chield: children){
            map.addCell(new Pair<>(chield.x,chield.y));
        }

        System.out.println("Hello world!");
    }
}