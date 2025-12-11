import java.util.*;

public class NthFromEndFinder {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (list == null || list.isEmpty() || n <= 0) {
            return null;
        }
        
        Iterator<T> mainIterator = list.iterator();
        Iterator<T> aheadIterator = list.iterator();
        
        for (int i = 0; i < n; i++) {
            if (!aheadIterator.hasNext()) {
                return null;
            }
            aheadIterator.next();
        }
        
        T result = null;
        while (aheadIterator.hasNext()) {
            result = mainIterator.next();
            aheadIterator.next();
        }
        
        return mainIterator.next();
    }
    
    public static void main(String[] args) {
        LinkedList<String> letters = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        String result = findNthFromEnd(letters, 2);
        System.out.println(result);
    }
}