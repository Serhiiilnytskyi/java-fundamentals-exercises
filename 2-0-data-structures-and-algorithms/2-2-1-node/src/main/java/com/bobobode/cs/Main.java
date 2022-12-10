package com.bobobode.cs;

public class Main {
    //    Create a method that accepts an array of int elements and returns void
//Implement an Insertion Sort algorithms
//Make sure that it works properly
    public static void main(String[] args) {

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
}
