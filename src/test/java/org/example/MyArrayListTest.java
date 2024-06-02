package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    @Test
    public void add_JUST_ONE_ELEMENT(){
        //Given
        var list = new MyArrayList<Integer>();
        //When
        list.add(1);
        //Then
        Assertions.assertArrayEquals(new Object[]{1}, list.getArray());
    }

    @Test
    public void getByIndex_CORRECT_INDEX(){
        //Given
        var list = new MyArrayList<Integer>();
        list.add(1);
        list.add(2);
        //When
        Integer element = list.getByIndex(1);
        //Then
        Assertions.assertSame(2, element);
    }

    @Test
    public void getByIndex_EXPECT_EXCEPTION(){
        //Given
        var list = new MyArrayList<Integer>();
        list.add(1);
        list.add(2);
        //When
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, ()->{
            list.getByIndex(2);
        }, "No exception!");
        //Then
        Assertions.assertEquals("Index >= 0 and < size of array!", thrown.getMessage());
    }

    @Test
    public void add_ELEMENT_BY_INDEX(){
        //Given
        var list = new MyArrayList<Integer>();
        list.add(1);
        list.add(2);
        //When
        list.add(0, 2);
        //Then
        Assertions.assertSame(2, list.getByIndex(0));
        Assertions.assertSame(2, list.getByIndex(1));
    }

    @Test
    public void add_ELEMENT_BY_WRONG_INDEX(){
        //Given
        var list = new MyArrayList<Integer>();
        list.add(1);
        list.add(2);
        //When
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, ()->{
            list.add(2, 2);
        }, "No exception!");
        //Then
        Assertions.assertEquals("Index >= 0 and < size of array!", thrown.getMessage());
    }

    @Test
    public void add_ARRAY_OF_ELEMENTS(){
        //Given
        var list = new MyArrayList<Integer>();
        //When
        list.add(new Integer[]{1, 2, 3});
        //Then
        Assertions.assertArrayEquals(new Object[]{1, 2, 3}, list.getArray());
    }

    @Test
    public void delete_ONE_ELEMENT(){
        //Given
        var list = new MyArrayList<Integer>();
        list.add(new Integer[]{1, 2, 3});
        //When
        list.delete(1);
        //Then
        Assertions.assertArrayEquals(new Object[]{1, 3}, list.getArray());
    }

    @Test
    public void delete_EXPECT_EXCEPTION(){
        //Given
        var list = new MyArrayList<Integer>();
        list.add(new Integer[]{1, 2, 3});
        //When
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, ()->{
            list.delete(3);
        }, "No exception!");
        //Then
        Assertions.assertEquals("Index >= 0 and < size of array!", thrown.getMessage());
    }

    @Test
    public void deleteAll_WITH_FILLED_ARRAY(){
        //Given
        var list = new MyArrayList<Integer>();
        list.add(new Integer[]{1, 2, 3});
        //When
        list.deleteAll();
        //Then
        Assertions.assertArrayEquals(new Object[]{}, list.getArray());
    }

    @Test
    public void deleteAll_WITH_EMPTY_ARRAY(){
        //Given
        var list = new MyArrayList<Integer>();
        //When
        list.deleteAll();
        //Then
        Assertions.assertArrayEquals(new Object[]{}, list.getArray());
    }

    @Test
    public void getSize_WITH_FILLED_ARRAY(){
        //Given
        var list = new MyArrayList<Integer>();
        list.add(new Integer[]{1, 2, 3});
        //When
        int size = list.getSize();
        //Then
        Assertions.assertSame(3, size);
    }

    @Test
    public void getSize_WITH_EMPTY_ARRAY(){
        //Given
        var list = new MyArrayList<Integer>();
        //When
        int size = list.getSize();
        //Then
        Assertions.assertSame(0, size);
    }
}