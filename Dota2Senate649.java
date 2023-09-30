import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate649 {
    public static String predictPartyVictory(String senate) {
        //create 2 queue to store positions of R and D
        //peek queueR and queueD, if r<d, poll d, add r+n back to the end of queueR
        //which queue empty first, the other queue wins
        int n = senate.length();
        Queue<Integer> queueR = new LinkedList<>();
        Queue<Integer> queueD = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if(senate.charAt(i) == 'R'){
                queueR.offer(i);
            }else{
                queueD.offer(i);
            }
        }

        while(!queueD.isEmpty() && !queueR.isEmpty()){
            if(queueD.peek() < queueR.peek()){
                queueR.poll();
                queueD.offer(queueD.poll() + n);
            }else{
                queueD.poll();
                queueR.offer(queueR.poll() + n);
            }
        }
        return queueR.isEmpty()? "Dire": "Radiant";
    }
        //this method does not work because after deleting char in sb, index i and j moves
        //use recursion and loop with two pointer
        //loop to check if all R or all D, return result
        //if not, then loop the sb, once found a r, delete the most recent d, vice versa
        //after this, put sb.tostring into function again until we have return value
        //use count to check if count of r or d matches the length of senate
/*        int count = 0;
        for (int i = 0; i < senate.length(); i++) {
            if(senate.charAt(i) == 'R'){
                count++;
            }
        }
        if(count == 0){
            return "Dire";
        }else if(count == senate.length()){
            return "Radiant";
        }
        //put senate to stringbuilder to remove R or D
        StringBuilder sb = new StringBuilder();
        sb.append(senate);
        //two pointer to delete the first different one and continue
        int i = 0, j = 1;
        while(i < sb.length() && j < sb.length()){
            while (sb.charAt(i) == sb.charAt(j) && j < sb.length()- 1) {
                j++;
            }
            if(j == sb.length()){
                sb.deleteCharAt(0);
            }else{
                sb.deleteCharAt(j);
                i++;
            }
        }


        return predictPartyVictory(sb.toString());
    }*/

    /*public static String vote(StringBuilder sb, int i, int j){
        while (sb.charAt(i) == sb.charAt(j)) {
            j++;
        }
        if(j == sb.length()){
            sb.deleteCharAt(0);
        }else{
        sb.deleteCharAt(j);
        i++;
        }
    }*/

    public static void main(String[] args) {
        String senate = "RDD";
        System.out.println(predictPartyVictory(senate));
    }

}
