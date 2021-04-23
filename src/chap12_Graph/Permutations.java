package chap12_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> permute = permute(nums);
        System.out.println("permute = " + permute);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();

        List<Integer> element = new ArrayList<>();
        for (int num : nums) {
            element.add(num);
        }
        recursive(element, prev, result);

        return result;
    }

    public static void recursive(List<Integer> elements, List<Integer> prev, List<List<Integer>> result) {
        if(elements.size() == 0)
            result.add(new ArrayList<>(prev));

        for (int num : elements) {
            List<Integer> next = new ArrayList<>(elements);
            next.removeIf(e -> e == num);

            prev.add(num);
            recursive(next, prev, result);
            prev.remove(prev.size() - 1);
        }
    }

}
