public class IncreasingTripletSubsequence334 {
    public static boolean increasingTriplet(int[] nums) {
        //1.greedy
        //let's assume there is such subsquence.
        // Then use 2 variables to store the first and second number
        // if nums[i] is bigger than the second number, return true
        //first opt out corner case
        if(nums.length < 3){
            return false;
        }
        //first number will start with the first number in array, second number can be a max number
        int firstNum = nums[0];
        int secondNum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > secondNum){
                return true;
            }else if(nums[i] > firstNum){
                secondNum = nums[i];
            }else{
                firstNum = nums[i];
            }
        }
        //if the loop ends, we could not find it return false
        return false;
    }

    public static void main(String[] args) {
        int nums[] = {2,1,5,0,4,6};
        System.out.println(increasingTriplet(nums));
    }
}
