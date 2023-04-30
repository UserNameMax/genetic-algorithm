package ru.omgtu.ivt213.algorithm;

import ru.omgtu.ivt213.Cell;

public class MultipliesAllDirections  implements Algorithm{
    @Override
    public Cell[] getChield(Cell parent) {
        return new Cell[]{
                new Cell(parent.x+1,parent.y),
                new Cell(parent.x-1,parent.y),
                new Cell(parent.x,parent.y+1),
                new Cell(parent.x,parent.y-1)
        };
    }
}
