import java.sql.PreparedStatement;
import java.util.Arrays;

public class MyArrayList<T> {
    private Object[] list;
    private int size;

    public MyArrayList(){
        list = new Object[10];
    }

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

    public void add(T element){
        if(size == list.length) growCapacity();
        list[size] = element;
        size++;
    }

    public void add(int index, T element){
        if(size == list.length) growCapacity();
        for(int i = size + 1; i > index; i--){
            list[i] = list[i-1];
        }
        list[index] = element;
        size++;
    }

    public void add(T[] elements){
        while(size + elements.length >= list.length) growCapacity();
        for(int i = size, j = 0; i < size + elements.length; i++, j++){
            list[i] = elements[j];
        }
        size += elements.length;
    }

    public Object delete(int index) throws IllegalArgumentException{
        if(index < 0 || index >= size) throw new IllegalArgumentException("Index >= 0 and < size of array!");
        Object element = list[index];
        for(int i = index + 1; i < size; i++){
            list[i-1] = list[i];
        }
        return element;
    }

    public void deleteAll(){
        list = new Object[10];
        size = 0;
    }

    public Object getByIndex(int index){
        if(index < 0 || index >= size) throw new IllegalArgumentException("Index >= 0 and < size of array!");
        return list[index];
    }

    public int getSize(){
        return size;
    }
}
