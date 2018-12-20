package com.suenara.algorithms.sort;

import java.util.Comparator;

import static com.suenara.algorithms.common.utils.ArrayUtils.swap;

public class InsertionSort {

    public static <T> void sort(T[] array, Comparator<T> comparator) {
        for (int i = 1; i < array.length; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (comparator.compare(array[j], array[j + 1]) <= 0) break;
                swap(array, j, j + 1);
            }
        }
    }

}
