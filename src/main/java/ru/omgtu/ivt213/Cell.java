package ru.omgtu.ivt213;

import ru.omgtu.ivt213.utils.Pair;

public class Cell {
    public int x;
    public int y;
    public int chieldNumber;
    public Pair<Integer,Integer> direction;
    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        chieldNumber = 0;
        direction = new Pair<>(0,0);
    }
    Cell(int x, int y, int chieldNumber, Pair<Integer,Integer> direction){
        this.x = x;
        this.y = y;
        this.chieldNumber = chieldNumber;
        this.direction = direction;
    }
    public Cell copy(int x, int y){
        return new Cell(x,y,chieldNumber + 1,new Pair<>(x-this.x,y - this.y));
    }
}
