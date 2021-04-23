package chap07_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] num = new int [1000];
        for (int i = -500; i < 500; i++) {
            num[i+500] = 1;
        }

        List<List<Integer>> threeSum = threeSumV2(num);


    }

    private static List<List<Integer>> threeSumV1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                if(j > j + 1 && nums[j] == nums[j - 1])
                    continue;
                for (int k = j + 1; k < nums.length; k++) {
                    if(k > j + 1 && nums[k] == nums[k - 1])
                        continue;

                    if (nums[i] + nums[j] + nums[k] == 0)
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                }
            }
        }

        return result;
    }

    private static List<List<Integer>> threeSumV2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        int left;
        int right;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];

                if(sum < 0)
                    left++;
                else if(sum > 0)
                    right++;
                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;
                }
            }
        }

        return result;
    }
}

