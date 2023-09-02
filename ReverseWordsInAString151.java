public class ReverseWordsInAString151 {
    public static String reverseWords(String s) {
        //1. get rid of extra space
        StringBuilder word = clearSpace(s);
        //2. reverse the whole string
        reverseString(word,0,word.length()-1);
        //3. reverse each word
        reverseWord(word, word.length()-1);

        return word.toString();
    }

    private static StringBuilder clearSpace(String s) {
        StringBuilder clearS = new StringBuilder();
        int i = 0, j = s.length();
        //use while to remove all space on the left of s
        while(i < j && s.charAt(i) == ' '){
            i++;
        }
        //after this, i is pointing to the first letter of first word
        //use while to remove all spaces on the right of s
        while (i < j && s.charAt(j-1) == ' ') {
            j--;
        }
        //after this, j is pointing to the last letter of last word
        while(i < j){
            //start to add first word to clearS
            while(i < j && s.charAt(i) != ' '){
                clearS.append(s.charAt(i));
                i++;
            }
            //now i is pointing to a space
            //if last char in clearS is not space, it can add i, then we are out of this while
            while(i < j && clearS.charAt(clearS.length() - 1) != ' '){
                clearS.append(s.charAt(i));
                i++;
            }
            //now i is pointing to the next space(if there is) we need to let i go to the next word
            if(i < j && s.charAt(i) == ' ') {
                i++;
            }
        }
        return clearS;
    }

    private static void reverseWord(StringBuilder w, int n) {
        //we use i, j to define the left and right of each word
        int i = 0, j = 0;
        while(j < w.length()){
            //we let i go to the left of a word
            while(j < w.length() && w.charAt(j) == ' '){
                j++;
            }
            i = j;
            //then we record this word, and let j go to the space part
            while(j < w.length() && w.charAt(j) != ' '){
                j++;
            }
            reverseString(w,i,j-1);
        }
    }

    private static void reverseString(StringBuilder w, int start, int end) {
        while(start < end){
            char temp = w.charAt(start);
            w.setCharAt(start++, w.charAt(end));
            w.setCharAt(end--, temp);
        }
    }
    //improvement
    public static String reverseWords1(String s){
        String result = "";
        int i = 0;
        int j = 0;
        while(i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            j = i;
            while (j < s.length() && s.charAt(j) != ' ') {
                j++;
            }
            if(i < s.length()) {
                result = s.substring(i, j) + " " + result;
                i = j;
            }
        }
        return result.substring(0 , result.length() - 1);
    }
    public static void main(String[] args) {
        String s = "  the  sky   is blue   ";
        System.out.println(reverseWords1(s));
    }
}
