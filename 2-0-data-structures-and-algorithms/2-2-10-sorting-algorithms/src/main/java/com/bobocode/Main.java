package com.bobocode;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //        int[] array = {1, 5, 6, 3, 4};
//        int[] sort = sort(array);
//        for (int i = 0; i < sort.length; i++) {
//            System.out.println(sort[i]);
//
//        }
        String[] input = new String[]{"1", "2", "3", "x", "5", "6", "a", "porosiatko", "c", "10", "11", "12", "13", "14", "15", "16"};
        table(input);
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] =current;
        }
    }

    public static int[] sort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j > 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }

    public static void table(String[] array) {
        for (int i = 0; i < array.length; i += 5) {
            int j = 0;
            int indent = 4;
            int longest = 0;
            while (j < 5 && array.length > i + j) {
                if (array[i + j].length() > longest) {
                    longest = array[i + j].length();
                }
                j++;
            }
            j = 0;
            while (j < 5 && array.length > i + j) {

                System.out.print(array[i + j] + " ".repeat(indent + longest - array[i + j].length()));
                j++;
            }
            System.out.println();
        }
    }
}
