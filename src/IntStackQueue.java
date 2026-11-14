public class IntStackQueue implements IntQueue{
    private IntArrayStack in;
    private IntArrayStack out;

    public IntStackQueue() {
        in = new IntArrayStack();
        out = new IntArrayStack();
    }

    @Override
    public void enqueue(int value) {
        in.push(value);
    }

    @Override
    public int dequeue() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) out.push(in.pop());
        }
        if (out.isEmpty()) throw new RuntimeException("Queue is empty");
        return out.pop();
    }

    @Override
    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) out.push(in.pop());
        }
        if (out.isEmpty()) throw new RuntimeException("Queue is empty");
        return out.peek();
    }

    @Override
    public int size() {
        return in.size() + out.size();
    }

    @Override
    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        boolean first = true;
        IntArrayStack temp = new IntArrayStack();

        while (!out.isEmpty()) {
            int v = out.pop();
            if (!first) sb.append(", ");
            sb.append(v);
            first = false;
            temp.push(v);
        }
        while (!temp.isEmpty()) out.push(temp.pop());

        while (!in.isEmpty()) temp.push(in.pop());
        while (!temp.isEmpty()) {
            int v = temp.pop();
            if (!first) sb.append(", ");
            sb.append(v);
            first = false;
            in.push(v);
        }
        return sb.append("]").toString();
    }
}
