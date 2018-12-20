package com.suenara.algorithms.sort;

import java.util.Comparator;

import static com.suenara.algorithms.common.utils.ArrayUtils.swap;

public class ShellSort {

    public static <T> void sort(T[] array, Comparator<T> comparator) {
        sort(array, 0, array.length - 1, comparator);
    }

    public static <T> void sort(T[] array, int start, int end, Comparator<T> comparator) {
        int length = end - start + 1;
        int step = 1;

        while (step < length / 3) step = 3 * step + 1;

        while (step >= 1) {

            for (int i = step; i < length; ++i) {
                for (int j = i; j >= step; j -= step) {
                    if (comparator.compare(array[j], array[j - step]) >= 0) break;
                    swap(array, j, j-step);
                }
            }

            step /= 3;
        }
    }
}
