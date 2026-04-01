package org.knp.dsa.sorting;

import java.util.*;

public class BubbleSort {
    /*Bubble Sort repeatedly compares adjacent elements and swaps them if they’re in the wrong order.
    After each pass, the largest element “bubbles up” to the end.*/

    public static void main(String[] args) {
        int[] arr = {1,5,2,20,11,15,7};
        System.out.println("Input Array" + Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted Array" + Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length-1; i++) {
            boolean swapped = false;
            for (int j=0; j<length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // swap elements
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    swapped = true;
                }
            }
            // This optimizes if array is sorted at some point
            if(!swapped) break;
        }
    }
}
