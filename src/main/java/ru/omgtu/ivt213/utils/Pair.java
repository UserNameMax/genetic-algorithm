package ru.omgtu.ivt213.utils;

import java.util.Objects;

public class Pair<T,F> {
    public T first;
    public F second;
    public Pair(T first, F second){
        this.first = first;
        this.second = second;
    }
    @Override
    public boolean equals(Object other){
        try{
            Pair<T,F> otherPair = (Pair<T,F>)other;
            return first == otherPair.first && second == otherPair.second;
        }
        catch (Exception e){
            return false;
        }
    }
}
