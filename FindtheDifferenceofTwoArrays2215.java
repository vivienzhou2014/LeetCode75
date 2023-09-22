import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindtheDifferenceofTwoArrays2215 {
    public static List<List<Integer>> findDifference1(int[] nums1, int[] nums2) {
        //first use the most easy method to do
        //create a list that matches the return type
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        result.add(result1);
        result.add(result2);
        //use hashset to store all nums in each array for later comparation
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        //if a num in nums2 is not in set1 and not in result2, then it is safe to add to result2
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
            if(!set1.contains(nums2[i]) && !result2.contains(nums2[i])){
                result2.add(nums2[i]);
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            if(!set2.contains(nums1[i]) && !result1.contains(nums1[i])){
                result1.add(nums1[i]);
            }
        }
        return result;
     }
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        //this method reduced run time since we loop set1 and set2 so we do not need to
        //check if arraylist contains that element

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        result.add(result1);
        result.add(result2);
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums1) {set1.add(num);}
        for (int num : nums2) {set2.add(num);}
        for (int num : set1) {
            if(!set2.contains(num)){
                result1.add(num);
            }
        }
        for (int num : set2) {
            if(!set1.contains(num)){
                result2.add(num);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,3}, nums2 = {1,1,2,2};
        System.out.println(findDifference(nums1,nums2));
    }
}
