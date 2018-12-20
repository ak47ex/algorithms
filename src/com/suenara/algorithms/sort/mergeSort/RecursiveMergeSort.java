package com.suenara.algorithms.sort.mergeSort;

import java.util.Comparator;

public class RecursiveMergeSort {

    public static <T> void sort(T[] array, Comparator<T> comparator) {
        sort(array, 0, array.length - 1, comparator);
    }

    public static <T> void sort(T[] array, int start, int end, Comparator<T> comparator) {
        T[] temp = (T[]) new Object[array.length];
        sort(array, temp, start, end, comparator);
    }

    private static <T> void sort(T[] array, T[] temp, int start, int end, Comparator<T> comparator) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;

        sort(array, temp, start, mid, comparator);
        sort(array, temp, mid + 1, end, comparator);

        merge(array, temp, start, end, comparator);
    }

    private static <T> void merge(T[] array, T[] temp, int start, int end, Comparator<T> comparator) {
        int mid = start + (end - start) / 2;

        int left = start;
        int right = mid + 1;

        int i = start;

        while (left <= mid && right <= end)
        {
            if (comparator.compare(array[left], array[right]) <= 0) {
                temp[i] = array[left];
                left++;
            } else {
                temp[i] = array[right];
                right++;
            }
            i++;

        }
        System.arraycopy(array, left, temp, i, mid - left + 1);
        System.arraycopy(array, right, temp, i, end - right + 1);

        int size = end - start + 1;
        System.arraycopy(temp, start, array, start, size);
    }

}
