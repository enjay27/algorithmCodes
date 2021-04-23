package chap12_Graph;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        recursive(result, nums, 0, new ArrayList<>());

        return result;
    }

    public static void recursive(List<List<Integer>> result, int[] nums, int curIndex, List<Integer> buffer) {
        result.add(new ArrayList<>(buffer));

        for (int i = curIndex; i < nums.length; i++) {
            buffer.add(nums[i]);
            recursive(result, nums, i + 1, buffer);
            buffer.remove(buffer.size() - 1);
        }
    }

}
