package com.suenara.algorithms.common.utils;

import java.util.Random;

public class ArrayUtils {

    //region Shuffle for primives
    public static void shuffle(int[] array) {
        Random rand = new Random();
        for(int i = 0; i < array.length; ++i) swap(array, i, rand.nextInt(i + 1));
    }

    public static void shuffle(long[] array) {
        Random rand = new Random();
        for(int i = 0; i < array.length; ++i) swap(array, i, rand.nextInt(i + 1));
    }

    public static void shuffle(float[] array) {
        Random rand = new Random();
        for(int i = 0; i < array.length; ++i) swap(array, i, rand.nextInt(i + 1));
    }

    public static void shuffle(double[] array) {
        Random rand = new Random();
        for(int i = 0; i < array.length; ++i) swap(array, i, rand.nextInt(i + 1));
    }

    public static <T> void shuffle(T[] array) {
        Random rand = new Random();
        for(int i = 0; i < array.length; ++i) swap(array, i, rand.nextInt(i + 1));
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void swap(long[] array, int i, int j) {
        long temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void swap(float[] array, int i, int j) {
        float temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void swap(double[] array, int i, int j) {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
