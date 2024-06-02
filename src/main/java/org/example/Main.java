package org.example;


import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Comparator<Integer> comparator = (a, b) -> {return a-b;};
        var list1 = new MyArrayList<Integer>();
        list1.add(6);
        list1.add(1);
        list1.add(9);
        list1.add(4);
        list1.add(8);
        var list2 = new MyArrayList<Integer>();
        SortingMyArrayList.quickSort(list1, comparator,- 1, list1.getSize() - 1);
        System.out.println(Arrays.toString(list1.getArray()));
    }
}