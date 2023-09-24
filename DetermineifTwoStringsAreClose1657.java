import java.util.*;


public class DetermineifTwoStringsAreClose1657 {
    public boolean closeStrings1(String word1, String word2) {
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
        if(!hm1.keySet().equals(hm2.keySet())){
            return false;
        }
        //3. the number of each charactors are the same(does not have to be same char)
        //    so we can put occurance of each char in word 1 in hashmap1, same for word2, and check if their values equals
        List<Integer> occ1 = new ArrayList<>();
        List<Integer> occ2 = new ArrayList<>();
        for(Object key: hm1.keySet()){
            occ1.add(hm1.get(key));
        }
        for(Object key: hm2.keySet()){
            occ2.add(hm2.get(key));
        }
        Collections.sort(occ1);
        Collections.sort(occ2);
        if(!occ1.equals(occ2)){
            return false;
        }

        return true;

    }
    public boolean closeStrings(String word1, String word2) {
        //the previous method used hashmap and arraylist, but we just need 26 lower case numbers
        //so an int[] is good enough for that
        //we just need to put int[0] for the occurance of a... int[25] for the occurence of z
        //then check if any place is empty for one but not empty for another
        //then we sort the two arrays to compare
        int[] occ1 = new int[26];
        int[] occ2 = new int[26];
        for (char c : word1.toCharArray()){
            occ1[c - 'a']++;
        }
        for(char c : word2.toCharArray()){
            occ2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if((occ1[i] + occ2[i]) > 0 && (occ1[i] == 0 || occ2[i] == 0)){
                return false;
            }
        }
        Arrays.sort(occ1);
        Arrays.sort(occ2);

        return Arrays.equals(occ1, occ2);
    }
}
