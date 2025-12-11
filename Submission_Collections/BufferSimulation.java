import java.util.*;

class CircularBuffer {
    private int[] buffer;
    private int head;
    private int tail;
    private int size;
    private int capacity;
    
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }
    
    public void insert(int value) {
        if (size == capacity) {
            buffer[tail] = value;
            tail = (tail + 1) % capacity;
            head = (head + 1) % capacity;
        } else {
            buffer[tail] = value;
            tail = (tail + 1) % capacity;
            size++;
        }
    }
    
    public List<Integer> getBuffer() {
        List<Integer> result = new ArrayList<>();
        if (size == 0) return result;
        
        int current = head;
        for (int i = 0; i < size; i++) {
            result.add(buffer[current]);
            current = (current + 1) % capacity;
        }
        return result;
    }
}

public class BufferSimulation{
    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.insert(4);
        System.out.println(buffer.getBuffer());
    }
}