package chap07_Array;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int[] num = new int[100000];
        for (int i = 0; i < 100000; i++) {
            num[i] = i * 2;
        }
        int target = 300000;

        int[] twoSum = towSumV2(num, target);
        for (int i : twoSum) {
            System.out.println("i = " + i);
        }
    }

    private static int[] twoSumV1(int[] num, int target) {
        int[] result = new int[2];
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if(num[i] + num[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;
    }

    private static int[] towSumV2(int[] num, int target) {
        int[] result = new int[2];
        for (int i = 0; i < num.length; i++) {
            int complement = target - num[i];
            int binarySearch = Arrays.binarySearch(num, complement);
            if (binarySearch > 0) {
                result[0] = i;
                result[1] = num[binarySearch];
                return result;
            }
        }

        return result;
    }
}
