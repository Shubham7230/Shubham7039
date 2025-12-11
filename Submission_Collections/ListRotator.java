import java.util.*;

public class ListRotator {
    public static <T> void rotateList(List<T> list, int positions) {
        if (list == null || list.isEmpty()) return;
        
        int size = list.size();
        positions = positions % size;
        if (positions < 0) positions += size;
        
        List<T> temp = new ArrayList<>(list.subList(0, positions));
        
        for (int i = 0; i < size - positions; i++) {
            list.set(i, list.get(i + positions));
        }
        
        for (int i = 0; i < positions; i++) {
            list.set(size - positions + i, temp.get(i));
        }
    }
    
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Original list: " + numbers);
        rotateList(numbers, 2);
        System.out.println("After rotating by 2: " + numbers);
    }
}