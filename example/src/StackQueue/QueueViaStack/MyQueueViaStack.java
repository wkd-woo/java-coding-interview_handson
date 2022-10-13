package StackQueue.QueueViaStack;

import java.util.Stack;

public class MyQueueViaStack<E> {
    private final Stack<E> stackEnque = new Stack();
    private final Stack<E> stackDeque = new Stack();

    public void enqueue(E insert) {
        stackEnque.push(insert);
        System.out.println("Enqueued: " + insert);
    }

    public E deque() {
        while (!stackEnque.isEmpty()) {
            stackDeque.push(stackEnque.pop());
        }
        E result = stackDeque.pop();
        while (!stackDeque.isEmpty()) {
            stackEnque.push(stackDeque.pop());
        }
        return result;
    }

    public E peek() {
        return stackEnque.get(0);
    }

    public int size() {
        return stackEnque.size();
    }

}
