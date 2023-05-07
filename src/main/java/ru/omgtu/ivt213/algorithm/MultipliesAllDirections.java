package ru.omgtu.ivt213.algorithm;

import ru.omgtu.ivt213.Cell;

public class MultipliesAllDirections  implements Algorithm{
    @Override
    public Cell[] getChield(Cell parent) {
        return new Cell[]{
                parent.copy(parent.x+1,parent.y),
                parent.copy(parent.x-1,parent.y),
                parent.copy(parent.x,parent.y+1),
                parent.copy(parent.x,parent.y-1)
        };
    }
}
