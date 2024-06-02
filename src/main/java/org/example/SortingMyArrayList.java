package org.example;

import org.example.MyArrayList;

import java.util.Comparator;

/**
 * Contains a static method for quickly sorting elements in the MyArrayList wrapper.
 */
public class SortingMyArrayList {
    /**
     * Allows you to sort elements in the wrapper using the quick sort algorithm.
     * @param arr MyArraylist wrapper that contains elements that need to be sorted.
     * @param comparator allowing you to compare elements in the wrapper.
     * @param begin index of the element that contains the elements that need to be sorted.
     * @param end index of the element up to which the elements to be sorted come.
     * @param <T> type of elements contained in the MyArrayList wrapper.
     */
    public static <T> void quickSort(MyArrayList<T> arr, Comparator<T> comparator, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, comparator, begin, end);

            quickSort(arr, comparator, begin, partitionIndex-1);
            quickSort(arr, comparator, partitionIndex+1, end);
        }
    }

    private static <T> int partition(MyArrayList<T> arr, Comparator<T> comparator, int begin, int end) {
        T pivot = arr.getByIndex(end);
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (comparator.compare(arr.getByIndex(j), pivot) <= 0) {
                i++;

                T swapTemp = arr.getByIndex(i);
                arr.add(i, arr.getByIndex(j));
                arr.add(j, swapTemp);
            }
        }

        T swapTemp = arr.getByIndex(i+1);
        arr.add(i+1, arr.getByIndex(end));
        arr.add(end, swapTemp);

        return i+1;
    }
}
