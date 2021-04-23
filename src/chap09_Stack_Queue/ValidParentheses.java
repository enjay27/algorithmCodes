package chap09_Stack_Queue;

import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()[]{aa}";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        Map<Character, Character> table = new HashMap<>();
        table.put(')', '(');
        table.put('}', '{');
        table.put(']', '[');

        System.out.println(table.get('}'));

        Stack<Character> stack = new Stack<>();
        for (int c : s.chars().toArray()) {
            System.out.println("c = " + (char)c);
            if(!table.containsKey((char)c)) {
                System.out.println("push = " + (char)c);
                stack.push((char) c);
            }
            else {
                Character pop = stack.pop();
                System.out.println("pop = " + pop);
                if(table.get((char)c) != pop)
                    return false;
            }
        }

        return stack.last == null;
    }
}
