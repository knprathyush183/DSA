package org.knp.dsa.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Heap {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Heap heap = new Heap();
        heap.buildHeap(array);
        System.out.printf("heap = %s\n", Arrays.toString(array));
    }

    public void maxHeapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            maxHeapify(array, n, largest);
        }
    }

    public void buildHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            maxHeapify(array, array.length, i);
        }
    }

    public void insert(Integer[] array, int value) {
        List<Integer> list = Arrays.asList(array);
        list.add(value);

        int n = list.size()-1;

        while (n > 0) {
            int parent = (n - 1) / 2;
            if (list.get(n) > list.get(parent)) {
                Collections.swap(list, n, parent);
                n = parent;
            } else {
                break;
            }
        }
    }

    void heapSort(int[] arr) {
        int n = arr.length;

        buildHeap(arr);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            maxHeapify(arr, i, 0);
        }
    }


}
