package ru.omgtu.ivt213;

import ru.omgtu.ivt213.algorithm.Algorithm;
import ru.omgtu.ivt213.algorithm.CheckCellAroundCount;
import ru.omgtu.ivt213.algorithm.MultipliesAllDirections;
import ru.omgtu.ivt213.algorithm.MultipliesOneDirection;
import ru.omgtu.ivt213.utils.Pair;
import ru.omgtu.ivt213.view.AppFrame;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Live live = new Live();
        Algorithm alg = new CheckCellAroundCount(0, live.getMap(), null, new MultipliesAllDirections(), new MultipliesOneDirection(0));
        for (int i = 0; i < 20; ++i) {
            alg.mutate();
        }
        var map = live.getResult(alg);
        AppFrame frame = new AppFrame(map);
        frame.setVisible(true);

        System.out.println("Hello world!");
    }
}