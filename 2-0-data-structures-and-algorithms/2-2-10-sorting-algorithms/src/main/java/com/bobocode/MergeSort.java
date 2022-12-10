package com.bobocode;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int mid = arr.length / 2;
        int[] leftPart = Arrays.copyOf(arr, mid);
        int[] rightPart = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(leftPart);
        mergeSort(rightPart);

        merge(arr, leftPart, rightPart);
    }

    private static int[] merge(int[] mergedArray, int[] leftPart, int[] rightPart) {
        int mergedIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < leftPart.length && rightIndex < rightPart.length) {
            if (leftPart[leftIndex] <= rightPart[rightIndex]) {
                mergedArray[mergedIndex++] = leftPart[leftIndex++];
            } else {
                mergedArray[mergedIndex++] = rightPart[rightIndex++];
            }
        }
        while (leftIndex < leftPart.length) {
                mergedArray[mergedIndex++] = leftPart[leftIndex++];
        }
        while (rightIndex < rightPart.length) {
            mergedArray[mergedIndex++] = rightPart[rightIndex++];
        }
        return mergedArray;
    }

    public static void main(String[] args) {
        int[] array = new int[]{46, 23, 32, 9, 4, 1};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
