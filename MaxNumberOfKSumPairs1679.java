
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MaxNumberOfKSumPairs1679 {
    public static int maxOperations1(int[] nums, int k) {
        //Time Limit Exceeded
/*        int count = 0;
        HashSet<Integer> operatedIndex = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == k && !operatedIndex.contains(i) && !operatedIndex.contains(j)){
                    count++;
                    operatedIndex.add(i);
                    operatedIndex.add(j);
                }
            }
        }
        return count;*/
        //Below is a solution I copied from a master. I can not write such amazing code right now.
        //But I will save it for future study
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int result = 0;
        //统计每个数据出现的次数，key为数据，value为次数
        for (int num : nums) {
            // 获取求和的另一个数
            int x = k - num;
            // 从map获取x
            Integer i = map.get(x);
            // 是否有 另一个数据。且统计的数量大于0
            if (i != null && map.get(x) > 0) {
                result++;//结果+1
                map.put(x, map.get(x) - 1);// 数量减一
                continue;
            }
            //这个数没有被使用，统计数量+1
            Integer count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        return result;

    }

    //The function below used two pointer and sort
    public static int maxOperations2(int[] nums, int k) {
        //sort the array
        Arrays.sort(nums);
        int count = 0, left = 0, right = nums.length - 1;
        while(left < right){
            if(nums[left] + nums[right] < k){//it means the sum needs to be bigger, so move left
                left++;
            } else if (nums[left] + nums[right] > k) {//it means the sum needs to be smaller, so move right
                right--;
            } else {//if the sum equals k, then we found the right two numbers, move both
                count++;
                left++;
                right--;
            }
        }
        return count;
    }

    //This function below used hashmap. It needs to loop through the array twice.
    public static int maxOperations(int[] nums, int k) {
        int count = 0;
        //key is number in nums, value is the amount of time this number exists in nums
        HashMap<Integer,Integer> numCount = new HashMap<>();
        //first loop to store nums and their counts
        for(int num : nums){
            int nCount = numCount.getOrDefault(num, 0);
            numCount.put(num, nCount + 1);
        }
        //second loop to count operations
        for(int num :nums){
            //if nCount is less than 0, ignore, which means it is checked before
            if(numCount.get(num) <= 0){
                continue;
            }
            int numSeek = k - num;
            //since we are going to use the num, we deduct nCount first
            numCount.put(num, numCount.get(num) - 1);
            //now we check if numSeek is in numCount
            if(numCount.containsKey(numSeek) && numCount.get(numSeek) > 0){
                //if there is a numSeek, operate once, remove this numSeek count for once
                count++;
                numCount.put(numSeek, numCount.get(numSeek) - 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0};
        System.out.println(maxOperations(nums, 0));
    }
}
