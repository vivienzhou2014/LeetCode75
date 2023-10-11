import java.util.Arrays;

public class MissingNumber268 {
    public static int missingNumber1(int[] nums) {
        /*Arrays.sort(nums);
        int i = 0;
        if(nums[i] > 0){
            return 0;
        }
        while(i < nums.length - 1 && (nums[i + 1] - nums[i] == 1))  {
            i++;
        }
        return ++i;*/
        //time consumer is horrible, try just adding
        int sunNums = 0;
        int sunActual = 0;
        for (int i = 0; i < nums.length; i++) {
            sunNums += nums[i];
            sunActual += i;
        }
        return sunActual + nums.length - sunNums;
    }
    public static int missingNumber(int[] nums) {
        int sunNums = 0;
        int n = nums.length;
        int sunActual = n * (n + 1) / 2;
        for (int i = 0; i < n; i++) {
            sunNums += nums[i];
            //sunActual += i;
        }
        return sunActual - sunNums;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 2, 3, 0, 4, 7};
        System.out.println(missingNumber(nums));
    }
}
