import java.util.Stack;

public class RemovingStarsFromaString2390 {
    public static String removeStars1(String s) {
        //It will be easy to use stack
        //when s.charAt is not *, push, if *, pull
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '*'){
                stack.push(s.charAt(i));
            }else{
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        /*String result = "";
        while(!stack.isEmpty()){
            result = stack.pop() + result;
        }
        return result;*/
        for(Character c: stack){
            sb.append(c);
        }
        return sb.toString();
    }
    public static String removeStars(String s) {
        //But just simulate the question also works
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '*'){
                sb.append(s.charAt(i));
            }else{
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(removeStars(s));
    }
}
