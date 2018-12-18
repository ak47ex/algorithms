package com.suenara.algorithms.sort;

import java.util.Comparator;

public class EstimateComparator<T> implements Comparator<T> {

    private final Comparator<T> comparator;

    private int counter;

    public EstimateComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int compare(T t, T t1) {
        counter++;
        return comparator.compare(t, t1);
    }

    public int getComparsions()  {
        return counter;
    }

    public void reset() {
        counter = 0;
    }
}
