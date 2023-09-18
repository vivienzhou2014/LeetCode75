public class LongestSubarrayof1sAfterDeletingOneElement1493 {
    public int longestSubarray(int[] nums) {
        //this problem is removing one element from nums to get max length of subarray which has consecutive 1s
        //think as the longest subarray that contains only one 0 or if all 1s, return nums.length - 1
        //use sliding window, left is the left edge of window, right is the right edge of window
        int left = 0, right = 0, count = 0, maxL = 0;
        //move right in loop, count 0s during every movement, if no 0 at all, right will move to the most right part, still ok
        while(right < nums.length){
            if(nums[right] == 0){
                count++;
            }
            //if subarray contains more than one 0, adjust left until only one 0 in subarray
            while(count > 1){
                if(nums[left] == 0){
                    count--;
                }
                left++;
            }
            maxL = Math.max(maxL, right - left);
            right++;
        }
        return maxL;
    }
}
