public class MaximumNumberOfVowelsInASubstringOfGivenLength1456 {
    public static int maxVowels1(String s, int k) {
        int count = 0;
        String vowel = "aeiou";
        //first loop fron 0 - k-1 to build the sliding window
        for (int i = 0; i < k; i++) {
            if(vowel.indexOf(s.charAt(i)) != -1){
                count++;
            }
        }
        //give result a temporary count to start comparing
        int result = count;
        //second loop from k to s.length() - 1 to check the rest count
        for (int i = k; i < s.length(); i++) {
            if(vowel.indexOf(s.charAt(i)) != -1){
                count++;
            }
            if(vowel.indexOf(s.charAt(i - k)) != -1){
                count--;
            }
            result = Math.max(result, count);
        }
        return result;
    }

    public static int maxVowels(String s, int k) {
        //there is another way to check if a char is vowel, the basic logic is just to add 1 if vowel
        int count = 0;

        //first loop from 0 - k-1 to build the sliding window
        for (int i = 0; i < k; i++) {
            count += isVowel(s.charAt(i));
        }
        //give result a temporary count to start comparing
        int result = count;
        //second loop from k to s.length() - 1 to calculate the rest count
        for (int i = k; i < s.length(); i++) {
            count = count + isVowel(s.charAt(i)) - isVowel(s.charAt(i - k));
            result = Math.max(result, count);
        }
        return result;
    }
    public static int isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? 1 : 0;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }
}
