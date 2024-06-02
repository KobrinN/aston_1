package org.example;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *Implementation of ArrayList with variable array length. Implements array operations such as:<br>
 * 1)Adding one element or an entire array of elements to the end of an array;<br>
 * 2)Removing elements and clearing an array;<br>
 * 3)Getting the value of an array element by index;<br>
 * 4)Getting the array size value.<br>
 *
 * @param <T> type of elements stored in the array.
 * @author KobrinN
 */
public class MyArrayList<T> {
    private Object[] list;
    private int size;

    /**
     * No argument constructor.
     */
    public MyArrayList(){
        list = new Object[10];
    }

    /**
     * Constructor with arguments to initialize an array with a given initial capacity.
     * @param capacity given initial capacity.
     * @throws IllegalArgumentException if the capacity is less than 0.
     */
    public MyArrayList(int capacity) throws IllegalArgumentException{
        if(capacity > 0){
            this.list = new Object[capacity];
        }
        if(capacity == 0){
            this.list = new Object[]{};
        }
        else throw new IllegalArgumentException("Capacity should be >= 0!");
    }

    private void growCapacity(){
        int newCapacity = list.length * 3 / 2 + 1;
        list = Arrays.copyOf(list, newCapacity);
    }

    /**
     * Adding element in the end of array/
     * @param element to which is added to the array.
     */
    public void add(T element){
        if(size == list.length) growCapacity();
        list[size] = element;
        size++;
    }

    /**
     * Replacing an element by index.
     * @param index by which the replacement will be made.
     * @param element to which the current one at index will be replaced.
     */
    public void add(int index, T element){
        if(index < 0 || index >= size) throw new IllegalArgumentException("Index >= 0 and < size of array!");
        list[index] = element;
    }

    /**
     * Adding an array of elements to the end.
     * @param elements an array of elements that will be appended to the end.
     */
    public void add(T[] elements){
        while(size + elements.length >= list.length) growCapacity();
        for(int i = size, j = 0; i < size + elements.length; i++, j++){
            list[i] = elements[j];
        }
        size += elements.length;
    }

    /**
     * Removing an element by index.
     * @param index by which will be removed element.
     * @return removed element.
     * @throws IllegalArgumentException when the index is outside the bounds of the array.
     */
    public T delete(int index) throws IllegalArgumentException{
        if(index < 0 || index >= size) throw new IllegalArgumentException("Index >= 0 and < size of array!");
        Object element = list[index];
        for(int i = index + 1; i < size; i++){
            list[i-1] = list[i];
        }
        size--;
        return (T) element;
    }

    /**
     * Complete array cleanup.
     */
    public void deleteAll(){
        list = new Object[10];
        size = 0;
    }

    /**
     * Getting the value of an element by its index.
     * @param index by which the value of the element will be requested.
     * @return value of element.
     * @throws IllegalArgumentException when the index is outside the bounds of the array.
     */
    public T getByIndex(int index) throws IllegalArgumentException{
        if(index < 0 || index >= size) throw new IllegalArgumentException("Index >= 0 and < size of array!");
        return (T) list[index];
    }

    /**
     *Getting the current size of the array.
     * @return current size of array/
     */
    public int getSize(){
        return size;
    }

    /**
     * Allows you to get an array of objects contained in the wrapper MyArraylist.
     * @return array of elements.
     */
    public Object[] getArray(){
        var result = new Object[size];
        for (int i = 0; i < size; i++){
            result[i] = list[i];
        }
        return result;
    }
}
