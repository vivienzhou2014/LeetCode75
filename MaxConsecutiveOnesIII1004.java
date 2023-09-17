public class MaxConsecutiveOnesIII1004 {
    public static int longestOnes(int[] nums, int k) {
        //the problem is asking if we convert k 0s to 1s in nums, what is the max length of consecutive 1s in nums
        //it is not easy to think that way
        //think like, in a subarray, we only allow k 0s, what is the max length of this subarray
        //zeroCount counts the number of 0s in a subarray
        //left is the most left element of the subarray, right is the most right element of the subarray
        int zeroCount = 0, left = 0, right = 0, result = 0;
        //right moves first to add zeroCount
        while(right < nums.length){
            if(nums[right] == 0){
                zeroCount++;
            }
            //after the first subarray is built, we adjust the left by zeroCount
            while(zeroCount > k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            //record the length of subarray to result
            result = Math.max(result, (right - left + 1));
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums,k));
    }
}
