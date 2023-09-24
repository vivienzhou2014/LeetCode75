import java.util.HashMap;


public class DetermineifTwoStringsAreClose1657 {
    public boolean closeStrings(String word1, String word2) {
        //This problem is actually to check 3 thing
        //1. the length of 2 strings are the same
        if(word1.length() != word2.length()){
            return false;
        }
        //2. the charactor are the same(does not matter occurance of each char)
        //   so we can put word1 in hashmap1, word2 in hashmap2, and check if their keyset equals
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            hm1.put(word1.charAt(i), hm1.getOrDefault(word1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < word2.length(); i++) {
            hm2.put(word2.charAt(i), hm2.getOrDefault(word2.charAt(i), 0) + 1);
        }
        //3. the number of each charactors are the same(does not have to be same char)
        //    so we can put occurance of each char in word 1 in hashmap1, same for word2, and check if their values equals
        if(!hm1.keySet().equals(hm2.keySet())){
            return false;
        }
        

    }
}
