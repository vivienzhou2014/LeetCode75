public class ReverseVowelsofaString345 {
    public String reverseVowels(String s) {
        //vowels are a e i o u lower and upper case
        String vowels = "aeiouAEIOU";
        //convert String to char[]
        char[] word = s.toCharArray();
        //use two pointer check from each side of the char[]
        int start = 0;
        int end = s.length() - 1;
        while(start < end){//when start == end, the loop is over
            //if the letter is not vowel, start move to the right
            while(start < end && vowels.indexOf(word[start]) == -1){
                start++;
            }
            //if the letter is not vowel, end move to the left
            while(start < end && vowels.indexOf(word[end]) == -1){
                end--;
            }
            //if both sides are out of loop, they both got a vowel, then we swap
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;

            //after swap, both pointer move to the middle
            start++;
            end--;

        }
        return new String(word);
    }
}
