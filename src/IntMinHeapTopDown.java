public class IntMinHeapTopDown implements IntQueue{
    private IntArray heap;

    public IntMinHeapTopDown() {
        heap = new IntArray();
    }

    public IntMinHeapTopDown(int [] values) {
        heap = new IntArray();
        for (int v : values) enqueue(v);
    }

    @Override
    public void enqueue(int value) {
        heap.add(value);
        int i = heap.size() - 1;
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(parent) <= heap.get(i)) break;
            int t = heap.get(parent);
            heap.set(parent, heap.get(i));
            heap.set(i, t);
            i = parent;
        }
    }

    @Override
    public int dequeue() {
        if (heap.isEmpty()) throw new RuntimeException("Heap is empty");
        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (heap.isEmpty()) return min;
        heap.set(0, last);
        int n = heap.size();
        int i = 0;
        while (true) {
            int left = 2 * i + 1, right = 2 * i + 2, smallest = i;
            if (left < n && heap.get(left) < heap.get(smallest)) smallest = left;
            if (right < n && heap.get(right) < heap.get(smallest)) smallest = right;
            if (smallest == i) break;
            int t = heap.get(i);
            heap.set(i, heap.get(smallest));
            heap.set(smallest, t);
            i = smallest;
        }
        return min;
    }

    @Override
    public int peek() {
        if (heap.isEmpty()) throw new RuntimeException("Heap is empty");
        return heap.get(0);
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
