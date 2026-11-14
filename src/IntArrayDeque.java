public class IntArrayDeque implements IntDeque{
    private IntArray array;
    private int front;
    private int size;
    private int capacity;

    public IntArrayDeque() {
        capacity = 8;
        array = new IntArray();
        for (int i = 0; i < capacity; i++) array.add(0);
        front = 0;
        size = 0;
    }

    @Override
    public void addFirst(int value) {
        if (size == capacity) {
            IntArray bigger = new IntArray();
            for (int i = 0; i < size; i++) bigger.add(array.get((front + i) % capacity));
            for (int i = size; i < capacity * 2; i++) bigger.add(0);
            array = bigger;
            capacity *= 2;
            front = 0;
        }
        front = (front - 1 + capacity) % capacity;
        array.set(front, value);
        size++;
    }

    @Override
    public void addLast(int value) {
        if (size == capacity) {
            IntArray bigger = new IntArray();
            for (int i = 0; i < size; i++) bigger.add(array.get((front + i) % capacity));
            for (int i = size; i < capacity * 2; i++) bigger.add(0);
            array = bigger;
            capacity *= 2;
            front = 0;
        }
        array.set((front + size) % capacity, value);
        size++;
    }

    @Override
    public int removeFirst() {
        if (size == 0) throw new RuntimeException("Deque is empty");
        int value = array.get(front);
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    @Override
    public int removeLast() {
        if (size == 0) throw new RuntimeException("Deque is empty");
        int value = array.get((front + size - 1) % capacity);
        size--;
        return value;
    }

    @Override
    public int peekFirst() {
        if (size == 0) throw new RuntimeException("Deque is empty");
        return array.get(front);
    }

    @Override
    public int peekLast() {
        if (size == 0) throw new RuntimeException("Deque is empty");
        return array.get((front + size - 1) % capacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) sb.append(", ");
            sb.append(array.get((front + i) % capacity));
        }
        return sb.append("]").toString();
    }
}
