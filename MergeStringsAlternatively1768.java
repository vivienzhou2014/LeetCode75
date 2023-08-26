public class MergeStringsAlternatively1768 {
    public static String mergeAlternately(String word1, String word2) {
        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();
/*        String res = "";
        for (int i = 0; i<Math.max(char1.length,char2.length); i++) {
           if(i < Math.min(char1.length,char2.length)*2){
               res += char1[i];
               res += char2[i];
           }else if(char1.length>char2.length){
               res += char1[i];
           }else{
               res += char2[i];
           }
        }*/
        //use StringBuilder instead
        StringBuilder res = new StringBuilder();
        int i = 0;

        //while loop is good enough for this case since we can control i
        while( i < Math.min(char1.length,char2.length)){
            //when both words have char, we insert them one by one
            res.append(char1[i]);
            res.append(char2[i]);
            i++;
        }
        while(i < char1.length){
            //if char2 does not have char, append the rest of char1 into res
            res.append(char1[i]);
            i++;
        }
        while(i < char2.length){
            //if char1 does not have char, append the rest of char2 into res
            res.append(char2[i]);
            i++;
        }
        return res.toString();//convert res back to string
    }

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";
        System.out.println(mergeAlternately(word1,word2));
    }
}
