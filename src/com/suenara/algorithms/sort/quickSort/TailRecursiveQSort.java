package com.suenara.algorithms.sort.quickSort;

import java.util.Comparator;

import static com.suenara.algorithms.common.utils.ArrayUtils.shuffle;
import static com.suenara.algorithms.common.utils.ArrayUtils.swap;

public class TailRecursiveQSort {

    public static <T> void sort(T[] array, Comparator<T> comparator) {
        shuffle(array);
        sort(array, 0, array.length - 1, comparator);
    }

    public static <T> void sort(T[] array, int start, int end, Comparator<T> comparator) {
        while (start < end) {
            int p = partition(array, start, end, comparator);
            sort(array, start, p - 1, comparator);
            start = p + 1;
        }
    }

    private static <T> int partition(T[] array, int start, int end, Comparator<T> comparator) {
        T pivot = getPivot(array, start, end);

        int i = start;
        int j = end + 1;
        while (true) {
            while (comparator.compare(array[++i], pivot) < 0) if (i == end) break;
            while (comparator.compare(array[--j], pivot) >= 0) if (j == start) break;
            if (i >= j) break;

            swap(array, i, j);
        }
        swap(array, j, start);

        return j;
    }

    private static <T> T getPivot(T[] array, int start, int end) {
        return array[start];
    }
}
