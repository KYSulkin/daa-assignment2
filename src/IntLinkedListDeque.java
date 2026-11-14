public class IntLinkedListDeque implements IntDeque{
    private IntLinkedList list;

    public IntLinkedListDeque() {
        list = new IntLinkedList();
    }

    @Override
    public void addFirst(int value) {
        list.add(0, value);
    }

    @Override
    public void addLast(int value) {
        list.add(value);
    }

    @Override
    public int removeFirst() {
        if (list.isEmpty()) throw new RuntimeException("Deque is empty");
        return list.remove(0);
    }

    @Override
    public int removeLast() {
        if (list.isEmpty()) throw new RuntimeException("Deque is empty");
        return list.remove(list.size() - 1);
    }

    @Override
    public int peekFirst() {
        if (list.isEmpty()) throw new RuntimeException("Deque is empty");
        return list.get(0);
    }

    @Override
    public int peekLast() {
        if (list.isEmpty()) throw new RuntimeException("Deque is empty");
        return list.get(list.size() - 1);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
