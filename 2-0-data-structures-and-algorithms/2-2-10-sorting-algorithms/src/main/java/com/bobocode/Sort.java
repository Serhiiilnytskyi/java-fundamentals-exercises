package com.bobocode;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class Sort {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(mergeSort(new int[]{})));
//        System.out.println(Arrays.toString(mergeSort(new int[]{1})));
//        System.out.println(Arrays.toString(mergeSort(new int[]{10, 5})));
//        System.out.println(Arrays.toString(mergeSort(new int[]{5, 4, 22, 43, 3, 2, 36, 18, 1, 44, 9, 10})));
//        System.out.println();
//        System.out.println(Arrays.toString(insertionSort(new int[]{})));
//        System.out.println(Arrays.toString(insertionSort(new int[]{1})));
//        System.out.println(Arrays.toString(insertionSort(new int[]{10, 5})));
//        System.out.println(Arrays.toString(insertionSort(new int[]{5, 4, 22, 43, 3, 2, 36, 18, 1, 44, 9, 10})));
//
        performSortingExperiment(Sort::mergeSort);
        System.out.println();
        performSortingExperiment(Sort::insertionSort);
    }

    private static void performSortingExperiment(Consumer<Integer[]> sortingFunction) {
        for (int i = 1000; i < 1_000_000; i*=2) {
            Integer[] arr = new Integer[i];
            for (int j = 0; j < i; j++) {
                arr[j] = ThreadLocalRandom.current().nextInt();
            }
            long start = System.nanoTime();
            sortingFunction.accept(arr);
            long stop = System.nanoTime();
            System.out.println(arr.length + " " + (stop - start));
        }
    }

    public static Integer[] insertionSort(Integer[] arr) {
        for (int i = 1; i < arr.length ; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    private static void insertionSortRecursive(int[] input, int i) {
        if (i <= 1) {
            return;
        }
        insertionSortRecursive(input, i - 1);
        int key = input[i - 1];
        int j = i - 2;
        while (j >= 0 && input[j] > key) {
            input[j + 1] = input[j];
            j = j - 1;
        }
        input[j + 1] = key;
    }

    public static Integer[] mergeSort(Integer[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        Integer[] leftPart = mergeSort(Arrays.copyOf(arr, mid));
        Integer[] rightPart = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(leftPart, rightPart);
    }

    private static Integer[] merge(Integer[] left, Integer[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int mergeIndex = 0;

        Integer[] mergedArr = new Integer[left.length + right.length];

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                mergedArr[mergeIndex++] = left[leftIndex++];
            } else {
                mergedArr[mergeIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < left.length) {
            mergedArr[mergeIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            mergedArr[mergeIndex++] = right[rightIndex++];
        }
        return mergedArr;
    }
}
