package chap07_Array;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println("bestTimeToBuySellStock(nums) = " + bestTimeToBuySellStock(nums));
    }

    private static int bestTimeToBuySellStock(int[] nums) {
        int max_benefit = 0;
        int low = nums[0];

        for (int num : nums) {
            if (low > num) {
                low = num;
            } else if (low < num) {
                int benefit = num - low;
                if(benefit > max_benefit)
                    max_benefit = benefit;
            }
        }

        return max_benefit;
    }
}
