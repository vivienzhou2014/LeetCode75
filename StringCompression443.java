public class StringCompression443 {
    public static int compress(char[] chars) {

        //move i to the last letter of the first group of consecutive repeating characters
        /*while(i < chars.length){
            if(i == chars.length - 1){
                return chars.length;
            }
            while(chars[i] == chars[i + 1]){
                i++;
            }
            count = i - j + 1;
            //put count after the character
            if((j+1) <chars.length && k < chars.length) {
                chars[k] = chars[i];
                if (count != 1) {
                    chars[j + 1] = (char) count;
                    k = j + 2 <chars.length? j + 2: k;
                } else {
                    k = j + 1;
                }
            }

            j = ++i;
            //now j and i are the first letter of next group
            //repeat until i reaches the end
        }*/
        //left is the left point of a consecutive same chars
        int left = 0, write = 0, count = 0;
        //go through chars
        for (int i = 0; i < chars.length; i++) {
            //we only deal with senarios that i moved to the right point of a consecutive same chars
            if((i == chars.length - 1) || chars[i] != chars[i+1]){
                chars[write] = chars[i];
                count = i - left + 1;
                write++;
                left = i + 1;
                if(count != 1){
                    String countString = Integer.toString(count);
                    for (int j = 0; j < countString.length(); j++) {
                        chars[write] = countString.charAt(j);
                        write++;
                    }
                }
            }
        }
        chars = new char[write];
        return chars.length;
    }

    public static void main(String[] args) {
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b','c','c','c'};
        System.out.println(compress(chars));
        for(char c : chars){
            System.out.print(c);
        }
    }
}
