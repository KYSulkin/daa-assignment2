public class IntArray {
    private int[] data;
    private int size;

    public IntArray(){
        data = new int[8];
        size = 0;
    }

    public void add(int value){
        add(size, value);
    }

    public void add(int index, int value){
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        if (size == data.length) {
            int[] bigger = new int[data.length * 2];
            for (int i = 0; i < size; i++) bigger[i] = data[i];
            data = bigger;
        }
        for (int i = size; i > index; i--) data[i] = data[i - 1];
        data[index] = value;
        size++;
    }

    public int get(int index){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return data[index];
    }

    public void set(int index, int value){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        data[index] = value;
    }

    public int remove(int index){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        int removed = data[index];
        for (int i = index; i < size - 1; i++) data[i] = data[i + 1];
        size--;
        if (data.length > 8 && size <= data.length / 4) {
            int[] smaller = new int[data.length / 2];
            for (int i = 0; i < size; i++) smaller[i] = data[i];
            data = smaller;
        }
        return removed;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(int[] values){
        if (size + values.length > data.length) {
            int capacity = data.length;
            while (capacity < size + values.length) capacity *= 2;
            int[] bigger = new int[capacity];
            for (int i = 0; i < size; i++) bigger[i] = data[i];
            data = bigger;
        }
        for (int v : values) data[size++] = v;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) sb.append(", ");
            sb.append(data[i]);
        }
        return sb.append("]").toString();
    }
}
