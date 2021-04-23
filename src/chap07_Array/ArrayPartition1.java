package chap07_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPartition1 {
    public static void main(String[] args) {
        int[] nums = new int[10000];
        for (int i = 0; i < 10000; i++) {
            nums[i] = i;
        }
        int arrayPartition = arrayPartitionV1(nums);
        System.out.println("arrayPartition = " + arrayPartition);
    }

    private static int arrayPartitionV1(int[] arr) {
        int result = 0;
        List<Integer> pair = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            pair.add(arr[i]);
            if (pair.size() == 2) {
                result += pair.stream().reduce((a, b) -> a > b ? b : a).get();
                pair.clear();
            }
        }

        return result;
    }

    private static int arrayPartitionV2(int[] arr) {
        int result = 0;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i += 2) {
            result += arr[i];
        }
        return result;
    }
}
