import java.util.ArrayList;
import java.util.Stack;

public class AsteroidCollision735 {
    public int[] asteroidCollision1(int[] asteroids) {
         //use ArrayList to store the result array
        ArrayList<Integer> result = new ArrayList<>();
        //loop the asteroids
        for (int i = 0; i < asteroids.length; i++) {
            checkLeft(result, asteroids[i]);
        }
        //convert result to array
        int[] res =new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
    //define a function to check,if r is empty or b < 0(moving left), then it does not matter what a is, just add
    //if b > 0, then check a. if a > 0 , then no collison, just add
    //if a<0, collision, the result of collison depends on a+b
    //if a+b >0, then a destroy, do nothing
    //if a+b == 0, remove b
    //if a+b < 0, remove b, and check a with r again
    public void checkLeft(ArrayList<Integer> r, int a){
        if(r.isEmpty()){
            r.add(a);
        }else{
            int b = r.get(r.size() - 1);
            if(b < 0){
                r.add(a);
            }else{
                if(a > 0){
                    r.add(a);
                }else if(a + b < 0){
                    r.remove(r.size() - 1);
                    checkLeft(r, a);
                }else if(a + b == 0){
                    r.remove(r.size() - 1);
                }
            }
        }

    }
    public int[] asteroidCollision(int[] asteroids) {
        //memory usage is not good for previous one
        //try stack
        Stack<Integer> result = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            checkLast(result, asteroids[i]);
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
    public static void checkLast(Stack<Integer> s, int a){
        if(s.isEmpty()){
            s.push(a);
        }else{
            if(s.peek() < 0){
                s.push(a);
            }else{
                if(a > 0){
                    s.push(a);
                }else if(a + s.peek() == 0){
                    s.pop();
                }else if(a + s.peek() < 0){
                    s.pop();
                    checkLast(s, a);
                }
            }
        }
    }

    public static void main(String[] args) {
        AsteroidCollision735 solution = new AsteroidCollision735();
        int[] asteroids = {-2,-2,1,-2};
        int[] result = solution.asteroidCollision(asteroids);
        for(int i : result){
            System.out.println(i);
        }
    }
}
