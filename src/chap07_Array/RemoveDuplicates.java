package chap07_Array;

import java.util.Arrays;
import java.util.Stack;

public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
        System.out.println("ca");
    }

    public static String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char aChar : chars) {
            if(stack.isEmpty()) {
                stack.push(aChar);
            }
            else if (stack.lastElement() != aChar) {
                stack.push(aChar);
            } else {
                stack.pop();
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }


}
