package chap12_Graph;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        System.out.println(combine(5, 3));

    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        recursive(new ArrayList<>(), result, 1, n, k);

        return result;
    }

    public static void recursive(List<Integer> elements, List<List<Integer>> result, int start, int n, int k) {
        if(k == 0) {
            result.add(new ArrayList<>(elements));
            return;
        }

        for (int i = start; i < n + 1; i++) {
            elements.add(i);
            recursive(elements, result,i + 1, n, k - 1);
            elements.remove(elements.size() - 1);
        }
    }
}
