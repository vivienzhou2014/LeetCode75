public class MaximumAverageSubarrayI643 {
    public static double findMaxAverage1(int[] nums, int k) {
        double result = Integer.MIN_VALUE;
        if(nums.length == 1){
            return nums[0];
        }
        //first method is using presum
        //create a presum array, assign first element to 0
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        //first loop is to get the presum
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
            //System.out.println(preSum[i]);
        }
        //second loop is to get the max sum of all possible k area
        for (int i = 0; i < preSum.length - k; i++){
            result = Math.max(result, (preSum[i + k] - preSum[i]));
            //result = (preSum[i + k] - preSum[i]) > result? (preSum[i + k] - preSum[i]) : result;
        }
        return result / k;
    }

    public static double findMaxAverage(int[] nums, int k) {
        int sumK = 0;
        //first build the sliding window
        for (int i = 0; i < k; i++) {
            sumK += nums[i];
        }
        int result = sumK;
        //now we start to move the sliding window
        for (int i = k; i < nums.length; i++){
            sumK = sumK + nums[i] - nums[i - k];
            result = Math.max(result, sumK);
        }
        return result * 1.0 / k;


    //the method below has logic error
/*    double result = 0;
        if(nums.length == 1){
        return nums[0];
    }
    //second method uses sliding window
    int sumK = 0;
        for (int i = 0; i < nums.length; i++) {
        if(i < k){//this is to accumulate the sum in k area
            sumK = sumK + nums[i];
            //System.out.println(sumK);
        }else{//now we start to move, every movement will add a new element on the right, deduct an old element on the left
            sumK = sumK + nums[i] - nums[i - k];
            result = Math.max(sumK, result);
            //System.out.println(result);
        }

    }
    result = result == 0? sumK: result;
        return result / k;*/
    }

    public static void main(String[] args) {
        int[] nums = {9,7,3,5,6,2,0,8,1,9};
        System.out.println(findMaxAverage(nums, 6));
    }
}
