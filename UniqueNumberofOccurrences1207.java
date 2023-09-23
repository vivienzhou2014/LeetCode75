import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueNumberofOccurrences1207 {
    public static boolean uniqueOccurrences(int[] arr) {
        //use hashmap to store element as key and occurrence as value
        HashMap<Integer,Integer> occ = new HashMap<>();
        for(int num : arr){
            occ.put(num, occ.getOrDefault(num, 0) + 1);
        }
        //put all the occurrences in a set
        HashSet<Integer> occUni = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry: occ.entrySet()){
            occUni.add(entry.getValue());
        }
        //if map size equals set size, then they are unique
        return occUni.size() == occ.size();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(arr));
    }
}
