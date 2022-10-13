package StackQueue.MinStack;

import java.util.Stack;

public class MyStack extends Stack<Integer> {
    Stack<Integer> stackOfMin;

    public MyStack() {
        this.stackOfMin = new Stack<>();
    }

    public Integer push(int value) {
        if (value <= min()) {
            stackOfMin.push(value);
        }

        return super.push(value);
    }

    @Override
    public Integer pop() {
        int value = super.pop();

        if (value == min()) {
            stackOfMin.pop();
        }

        return value;
    }


    public Integer min() {
        if (stackOfMin.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return stackOfMin.peek();
    }
}
