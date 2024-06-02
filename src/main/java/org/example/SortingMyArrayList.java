import java.util.Comparator;
import java.util.Objects;

public class SortingMyArrayList {
    public void quickSort(MyArrayList<Object> arr, Comparator<Object> comparator, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, comparator, begin, end);

            quickSort(arr, comparator, begin, partitionIndex-1);
            quickSort(arr, comparator, partitionIndex+1, end);
        }
    }

    private int partition(MyArrayList<Object> arr, Comparator<Object> comparator, int begin, int end) {
        Object pivot = arr.getByIndex(end);
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (comparator.compare(arr.getByIndex(j), pivot) <= 0) {
                i++;

                Object swapTemp = arr.getByIndex(i);
                arr.add(i, arr.getByIndex(j));
                arr.add(j, swapTemp);
            }
        }

        Object swapTemp = arr.getByIndex(i+1);
        arr.add(i+1, arr.getByIndex(end));
        arr.add(end, swapTemp);

        return i+1;
    }
}
