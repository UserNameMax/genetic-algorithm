package ru.omgtu.ivt213;

import ru.omgtu.ivt213.utils.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CellsMap {
    private int _height;
    private int _width;
    private List<Pair<Pair<Integer, Integer>, Boolean>> _map;

    CellsMap(int width, int height) {
        _width = width;
        _height = height;
        _map = new LinkedList<>();
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                _map.add(new Pair<>(new Pair<>(j, i), false));
            }
        }
    }

    Pair<Pair<Integer, Integer>, Boolean> getCell(Pair<Integer, Integer> cellCord){
        if (cellCord.first >= _width || cellCord.second >= _height || cellCord.first <= 0 || cellCord.second <= 0) return null;
        return _map.stream().filter((Pair<Pair<Integer, Integer>, Boolean> pair) -> pair.first.equals(cellCord)).collect(Collectors.toList()).get(0);
    }

    public boolean checkCell(Pair<Integer, Integer> cellCord){
        var cell = getCell(cellCord);
        if (cell == null) return false;
        return cell.second;
    }

    public void addCell(Pair<Integer, Integer> cellCord){
        var cell = getCell(cellCord);
        if (cell != null) {
            cell.second = true;
        }

    }
}
