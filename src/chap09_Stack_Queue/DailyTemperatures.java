package chap09_Stack_Queue;

public class DailyTemperatures {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.pop();
        System.out.println(stack.isEmpty());
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        for (int temperature : temperatures) {
            stack.push(temperature);
        }
        return null;
    }
}
