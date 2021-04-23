package chap07_Array;


import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] trapping = {0, 1, 4, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int trapped = trappingWaterV2(trapping);
        System.out.println("trapped = " + trapped);
    }

    private static int trappingWaterV1(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            if (max <= height[i]) {
                right = i;
                if (max < height[i]) {
                    left = i;
                    max = height[i];
                }
            }
        }

        int curHeight = 0;
        for (int i = 0; i < left; i++) {
            if (curHeight < height[i])
                curHeight = height[i];
            else if(curHeight > height[i])
                result += curHeight- height[i];
        }

        return result;
    }

    private static int trappingWaterV2(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int prev = 0;
        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty()) {
                if(height[i] <= height[stack.firstElement()])
                    break;

                int top = stack.pop();

                if(stack.isEmpty())
                    break;

                int distance = i - stack.firstElement() - 1;
                int waters = Math.min(height[i], height[stack.firstElement()]) - height[top];

                result += distance * waters;
            }

            stack.push(i);
        }

        return result;
    }
}
