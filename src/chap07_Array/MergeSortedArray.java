package chap07_Array;

import java.util.Arrays;
import java.util.List;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.println("i = " + i);
        }

        int[] nums3 = {0};
        int[] nums4 = {1};
        merge(nums3, 0, nums4, 1);
        for (int i : nums3) {
            System.out.println("i = " + i);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int cur2 = n - 1;
        int cur1 = m - 1;
        int cur = cur2 + m;

        while (cur1 >= 0 && cur2 >= 0) {
            if (nums2[cur2] > nums1[cur1]) {
                nums1[cur--] = nums2[cur2--];
            } else {
                nums1[cur--] = nums1[cur1--];
            }
        }

        while (cur2 >= 0) {
            nums1[cur--] = nums2[cur2--];
        }

    }
}
