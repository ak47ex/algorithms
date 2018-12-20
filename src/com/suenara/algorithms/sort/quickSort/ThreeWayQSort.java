package com.suenara.algorithms.sort.quickSort;

import java.util.Comparator;

import static com.suenara.algorithms.common.utils.ArrayUtils.shuffle;
import static com.suenara.algorithms.common.utils.ArrayUtils.swap;

public class ThreeWayQSort {

    public static <T> void sort(T[] array, Comparator<T> comparator) {
        shuffle(array);
        sort(array, 0, array.length - 1, comparator);
    }

    public static <T> void sort(T[] array, int start, int end, Comparator<T> comparator) {
        if (end <= start) return;
        int lt = start;
        int gt = end;
        T pivot = getPivot(array, start, end);
        int i = start;
        while (i <= gt) {
            int cmp = comparator.compare(array[i], pivot);
            if (cmp < 0) swap(array, lt++, i++);
            else if (cmp > 0) swap(array, i, gt--);
            else i++;
        }
        sort(array, start, lt - 1, comparator);
        sort(array, gt + 1, end, comparator);
    }

    private static <T> T getPivot(T[] array, int start, int end) {
        return array[start];
    }
}
