package StackQueue.StackBraces;

import java.util.Stack;

public class Stacks {
    private Stacks() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void main(String[] args) {
        String goodBracesStr = "{}{{{}}}{{}}{}";
        String wrongBracesStr = "{}{{{}}}{{}{{}";

        System.out.println("Good (should return true): "
                + bracesMatching(goodBracesStr));

        System.out.println("Wrong (should return false): "
                + bracesMatching(wrongBracesStr));
    }

    public static boolean bracesMatching(String bracesStr) {
        char[] braces = bracesStr.toCharArray();
        Stack stack = new Stack();

        for (char brace : braces) {
            if (brace == '{') {
                stack.push(brace);
            } else if (stack.isEmpty() && brace == '}') {
                return false;
            } else if (!stack.isEmpty() && brace == '}') {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
