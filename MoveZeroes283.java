public class MoveZeroes283 {
    public static void moveZeroes1(int[] nums) {

        int n = nums.length;
        int j = n - 1;
        //move j to the last 0 position
        while(j >= 0) {
            while (j >= 0 && nums[j] != 0) {
                j--;
            }
            //i is the first number after last 0
            //check if there are more 0s
            if(j >= 0) {
                int i = j + 1;
                while (i < n) {
                    nums[i - 1] = nums[i];
                    i++;
                }
                //now i is the last number of nums
                nums[i - 1] = 0;
                //next time we do not touch the 0 we just moved
                n--;
            }
        }

    }
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int nonZeroIndex = 0;

        // Iterate through the array and move non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }

        // Fill the remaining elements with zeroes
        while (nonZeroIndex < n) {
            nums[nonZeroIndex] = 0;
            nonZeroIndex++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,0,5,0};
        moveZeroes(nums);
        for(int i:nums){
            System.out.print(i + " ");
        }
    }
}
