package chap12_Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        System.out.println(combinationSumV2(candidates, 7));
    }

    public static List<List<Integer>> combinationSumV1(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        recursiveV1(result, candidates, new ArrayList<>(), 0, target);

        return result;
    }

    public static void recursiveV1(List<List<Integer>> result, int[] candidates, List<Integer> buffer, int sum, int target) {

        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(buffer));
            return;
        }

        for (int num : candidates) {

            buffer.add(num);

            recursiveV1(result, candidates, buffer, sum + num, target);

            buffer.remove(buffer.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSumV2(int[] candidates, int target) {

        if(candidates.length == 0)
            return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();

        recursiveV2(result, candidates, new ArrayList<>(), 0, 0, target);

        return result;
    }

    public static void recursiveV2(List<List<Integer>> result, int[] candidates, List<Integer> buffer, int curIndex, int sum, int target) {

        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(buffer));
            return;
        }

        for (int i = curIndex; i < candidates.length; i++) {

            buffer.add(candidates[i]);

            recursiveV2(result, candidates, buffer, i,sum + candidates[i], target);

            buffer.remove(buffer.size() - 1);
        }
    }
}
