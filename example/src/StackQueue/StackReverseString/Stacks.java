package StackQueue.StackReverseString;


import java.util.Stack;

public class Stacks {
    private Stacks() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void main(String[] args) {
        String str = "dlrow olleh";

        String result = reverse(str);
        System.out.println("Result: " + result);
    }

    public static String reverse(String str) {
        Stack stack = new Stack();

        char[] chars = str.toCharArray();
        for (char ch : chars) {
            stack.push(ch);
        }

        StringBuffer result = new StringBuffer();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

}
