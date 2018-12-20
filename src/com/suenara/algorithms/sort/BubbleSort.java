package com.suenara.algorithms.sort;

import java.util.Comparator;

import static com.suenara.algorithms.common.utils.ArrayUtils.swap;


public class BubbleSort {

    public static <T> void sort(T[] array, Comparator<T> comparator) {
        sort(array, 0, array.length - 1, comparator);
    }

    public static <T> void sort(T[] array, int start, int end, Comparator<T> comparator) {
        for (int i = end; i >= start; --i) {
            for (int j = start; j < i; ++j) {
                if (comparator.compare(array[j], array[j + 1]) > 0) swap(array, j, j + 1);
            }
        }
    }
}
