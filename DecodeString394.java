import java.util.Stack;

public class DecodeString394 {
    public String decodeString1(String s) {
        //the most important part of this problem is to know when to end a substring
        //so what we do when we loop the string to ']' is the key
        //create a stack to store chars in string, when not']', push to stack
        //when']', pop substring, pop'[', pop number
        //use number to loop and get new substring, push whole substring back to stack
        //go to the next char until ']', repeat until stack is empty
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ']'){
                stack.push(Character.toString(s.charAt(i)));
            }else{
                String sub = "";
                while(!stack.peek().equals("[")) {
                    sub = stack.pop() + sub;
                }
                //pop'['
                if(!stack.isEmpty()) {
                    stack.pop();
                }
                String count = "";
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    count = stack.pop() + count;
                }
                //use number to loop and get new substring
                if(count != "") {
                    String subString = "";
                    int countInt = Integer.parseInt(count);
                    while(countInt > 0){
                        subString += sub;
                        countInt--;
                    }
                    //push whole substring back to stack
                    stack.push(subString);
                }
            }
        }
        String result = "";
        for (String c:stack) {
            result += c;
        }
        return result;
    }
    int i = 0;
    public String decodeString2(String s) {
        //Use recursion
        //loop the string, when it meets a number, put number in count,
        //put sub char in sub, put sub string in result
        StringBuilder result = new StringBuilder();
        //s.charAt(i) == ']' means it reaches the end
        while(i < s.length() && s.charAt(i) != ']'){
            if(Character.isDigit(s.charAt(i))){
                //store number in num
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i++) - '0';
                }
                //skip the '['
                i++;
                //store char in str, in else
                String str = decodeString(s);
                //loop num times to get subString
                while(num-- > 0){
                    result.append(str);
                }
                //skip the ']'
                i++;
            }else{
                    result.append(s.charAt(i++));
            }
        }
        return result.toString();
    }

    public String decodeString(String s) {
        //use char stack instead of string to see if it is better
        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < s.length(); j++) {
            if(s.charAt(j) != ']'){
                stack.push(s.charAt(j));
            }else{
                StringBuilder str = new StringBuilder();
                while(stack.peek() != '['){
                    //store chars in a stringbuilder
                    str.append(stack.pop());
                }
                //pop out [
                stack.pop();
                //deal with number
                String num = "";
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    num = stack.pop() + num;
                    //System.out.println(num);
                }
                if(num != "") {//loop num times to get subString
                    StringBuilder subString = new StringBuilder();
                    int count = Integer.parseInt(num);
                    while (count-- > 0) {
                        subString.append(str);
                    }
                    //loop subString backwards to stack
                    for (int k = subString.length() - 1; k >= 0; k--) {
                        stack.push(subString.charAt(k));
                    }
                }
            }
        }
        //now we pop stack to a string
        StringBuilder result = new StringBuilder();
        for(char c: stack){
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        DecodeString394 solution = new DecodeString394();
        //String s = "3[a]2[bc]";
        String s = "100[leetcode]";
        System.out.println(solution.decodeString(s));
    }
}
