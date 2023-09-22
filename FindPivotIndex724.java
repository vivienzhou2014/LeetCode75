import java.util.Arrays;

public class FindPivotIndex724 {
    public static int pivotIndex1(int[] nums) {
        //the most easy way to solve this is to build a presum array
        //then loop through presum array to check if there is an index match the pivotIndex
        //build the presum first
        //time and space complexity O(n)
        int[] preSum = new int[nums.length + 2];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        preSum[nums.length + 1] = preSum[nums.length];
        //then loop again to find pivot
        //int pivotIndex = -1;
        for (int i = 1; i < preSum.length - 1; i++) {
            if(preSum[i - 1] == preSum[preSum.length - 1] - preSum[i]){
                int pivotIndex = i - 1;
                return pivotIndex;
            }
        }
        return -1;
    }

    public static int pivotIndex(int[] nums) {
        //After studying, I learnt another method to recude space complexity to O(1)
        //the left part can be recored as leftSum, and rightSum==sum - nums[i] - leftSum
        //if leftSum == rightSum, then leftSum == sum-nums[i]-leftSum
        // 2*leftSum==sum-nums[i] -> nums[i] == sum-2*leftSum
        int leftSum = 0;
/*        for(int num : nums){
            sum += num;
        }*/
        int sum = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == sum - leftSum * 2){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(pivotIndex(nums));//3
    }
}
