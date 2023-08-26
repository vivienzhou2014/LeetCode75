import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> result = new ArrayList<>();
        //get the max num of candies
/*        for (int i = 0; i < candies.length; i++) {
            max = candies[i]>max ? candies[i]: max;
        }*/
        //make the code easier to read
        for (int candy:candies) {
            max = Math.max(candy, max);
        }
        //compare num of candies after getting extra candies with max, if new max exist, then true
/*        for (int i = 0; i < candies.length; i++) {
            result.add((candies[i] + extraCandies) >= max ? true : false);
        }*/
        //make the code easier to read
        for(int candy: candies){
            result.add((candy+extraCandies) >= max);
        }
        return result;
    }
}
