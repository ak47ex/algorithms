package com.suenara.algorithms.sort;

import java.util.Comparator;

import static com.suenara.algorithms.common.utils.ArrayUtils.swap;

public class SelectionSort {
    public static <T> void sort(T[] array, Comparator<T> comparator) {
        sort(array, 0, array.length - 1, comparator);
    }

    public static <T> void sort(T[] array, int start, int end, Comparator<T> comparator) {
        for (int i = start; i < end + 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < end + 1; ++j) {
                if (comparator.compare(array[j], array[minIndex]) < 0) minIndex = j;
            }
            swap(array, i, minIndex);
        }
    }
}
