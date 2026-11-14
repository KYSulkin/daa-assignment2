public class IntQueueStack implements IntStack{
    private IntLinkedListQueue main = new IntLinkedListQueue();
    private IntLinkedListQueue helper = new IntLinkedListQueue();

    @Override
    public void push(int value) {
        main.enqueue(value);
    }

    @Override
    public int pop() {
        if (main.isEmpty()) throw new RuntimeException("Stack is empty");
        while (main.size() > 1) helper.enqueue(main.dequeue());
        int top = main.dequeue();
        IntLinkedListQueue t = main;
        main = helper;
        helper = t;
        return top;
    }

    @Override
    public int peek() {
        if (main.isEmpty()) throw new RuntimeException("Stack is empty");
        while (main.size() > 1) helper.enqueue(main.dequeue());
        int top = main.dequeue();
        helper.enqueue(top);
        IntLinkedListQueue t = main;
        main = helper;
        helper = t;
        return top;
    }

    @Override
    public int size() {
        return main.size();
    }

    @Override
    public boolean isEmpty() {
        return main.isEmpty();
    }

    @Override
    public String toString() {
        return main.toString();
    }
}
