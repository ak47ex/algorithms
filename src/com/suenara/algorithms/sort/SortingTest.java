package com.suenara.algorithms.sort;

import com.suenara.algorithms.sort.quickSort.BaseQSort;

import java.util.LinkedList;
import java.util.List;

public class SortingTest {

    private static final int DATA_SIZE = 50000;
    private static final int RETRY_COUNT = 10;

    private List<SortInfo> results = new LinkedList<>();

    private ArrayType currentType = ArrayType.RANDOM;

    public SortingTest() {

        EstimateComparator<Integer> comparator = new EstimateComparator<>(Integer::compare);
        results.add(countAverage(() -> BaseQSort.sort(obtainArray(DATA_SIZE), comparator), RETRY_COUNT, comparator, "Base Quick Sort"));

        printResults();
    }

    private SortInfo countAverage(Runnable run, int retryCount, EstimateComparator comparator, String sortName) {
        long averageTime = 0;
        long averageCompares = 0;
        for (int i = 0; i < retryCount; ++i) {
            long timeStart = System.currentTimeMillis();
            run.run();
            averageTime = ((averageTime * i) + (System.currentTimeMillis() - timeStart)) / (i + 1);
            averageCompares = ((averageCompares * i) + comparator.getComparsions()) / (i + 1);
            comparator.reset();
        }
        return new SortInfo(sortName, averageTime / 1000d, averageCompares);
    }

    private Integer[] obtainArray(int size) {
        switch (currentType) {
            case RANDOM: return createRandomArray(size);
            default: return new Integer[0];
        }
    }

    private Integer[] createRandomArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < array.length; ++i) {
            array[i] = (int) (Math.random() * array.length);
        }
        return array;
    }

    private void printResults() {
        System.out.println(String.format("Input array with size %s. Each sort will be runned for %s times.", DATA_SIZE, RETRY_COUNT));
        for (SortInfo info : results) {
            System.out.println(String.format("%s. AverageTime: %10f. AverageCompares: %10d", info.name, info.avgTime, info.avgComparsions));
        }
    }

    public static void main(String[] args) {
        new SortingTest();
    }

    private static class SortInfo {
        public String name;
        public double avgTime;
        public long avgComparsions;

        public SortInfo(String name, double avgTime, long avgComparsions) {
            this.name = name;
            this.avgTime = avgTime;
            this.avgComparsions = avgComparsions;
        }
    }

    private enum ArrayType {
        RANDOM, PYRAMID, SORTED, REVERSED_SORTED, DUPLICATES
    }
}
