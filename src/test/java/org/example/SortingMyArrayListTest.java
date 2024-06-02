package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class SortingMyArrayListTest {
    private final Comparator<Integer> comparatorMinMax = Comparator.comparingInt((Integer a) -> a);
    private final Comparator<Integer> comparatorMaxMin = (Integer a, Integer b)->{ return b-a;};
    @Test
    public void quickSort_MAX_MIN_TO_MIN_MAX(){
        //Given
        var list = new MyArrayList<Integer>();
        list.add(new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
        //When
        SortingMyArrayList.quickSort(list, comparatorMinMax, 0, 9);
        //Then
        Assertions.assertArrayEquals(new Object[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, list.getArray());
    }
    @Test
    public void quickSort_MAX_MIN_TO_MAX_MIN(){
        //Given
        var list = new MyArrayList<Integer>();
        list.add(new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
        //When
        SortingMyArrayList.quickSort(list, comparatorMaxMin, 0, 9);
        //Then
        Assertions.assertArrayEquals(new Object[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, list.getArray());
    }
    @Test
    public void quickSort_MIN_MAX_TO_MAX_MIN(){
        //Given
        var list = new MyArrayList<Integer>();
        list.add(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        //When
        SortingMyArrayList.quickSort(list, comparatorMaxMin, 0, 9);
        //Then
        Assertions.assertArrayEquals(new Object[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, list.getArray());
    }
    @Test
    public void quickSort_MIN_MAX_TO_MIN_MAX(){
        //Given
        var list = new MyArrayList<Integer>();
        list.add(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        //When
        SortingMyArrayList.quickSort(list, comparatorMinMax, 0, 9);
        //Then
        Assertions.assertArrayEquals(new Object[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, list.getArray());
    }

    @Test
    public void quickSort_EMPTY_ARRAY(){
        //Given
        var list = new MyArrayList<Integer>();
        //When
        SortingMyArrayList.quickSort(list, comparatorMinMax, 0, 0);
        //Then
        Assertions.assertArrayEquals(new Object[]{}, list.getArray());
    }

    @Test
    public void quickSort(){
        //Given
        var list = new MyArrayList<Integer>();
        list.add(new Integer[]{1, 2, 3});
        //When
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, ()->{
            SortingMyArrayList.quickSort(list, comparatorMaxMin, 0, 3);
        }, "No exception!");
        //Then
        Assertions.assertEquals("Index >= 0 and < size of array!", thrown.getMessage());
    }

}