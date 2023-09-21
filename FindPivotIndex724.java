public class FindPivotIndex724 {
    public static int pivotIndex(int[] nums) {
        //the most easy way to solve this is to build a presum array
        //then loop through presum array to check if there is an index match the pivotIndex
        //build the presum first
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

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(pivotIndex(nums));//3
    }
}
