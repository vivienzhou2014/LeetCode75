import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class EqualRowandColumnPairs2352 {
    public static int equalPairs1(int[][] grid) {
        //my idea is to use each row(grid[0] grid[1]..) compare to each column(grid[0][0], [1][0]..)
        //so I will flip to matrix to make columns to rows and then compare each rows of two matrix
        //to flip make grid[i][j] to grid[j][i]
        int n = grid.length;
        int[][] flippedGrid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                flippedGrid[j][i] = grid[i][j];

            }
        }

        //now compare rows
        int result = 0;
        for (int i = 0; i < n; i++) {
            int[] compare = grid[i];
            for (int j = 0; j < n; j++) {
                if(Arrays.equals(compare, flippedGrid[j])){
                    result++;
                }
            }
        }
        //if found one ==, count++
        return result;
    }
    public int equalPairs2(int[][] grid) {
        //the optimized way is to use hashmap, key can be string or arraylist, value is count
        //we first list rows in hashmap with occurance in value
        HashMap<ArrayList<Integer>, Integer> hm = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                row.add(grid[i][j]);
            }
            hm.put(row, hm.getOrDefault(row, 0) + 1);
        }
        //then put columns in hashmap
        //if columns already exist in key, we add the occurance of that key to result
        //that's how many times the column matches the row,
        //if columns does not exist, we set value to 0 so still add but no change to the result
        int result = 0;
        for (int j = 0; j < grid[0].length; j++) {
            ArrayList<Integer> col = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                col.add(grid[i][j]);
            }
            hm.put(col, hm.getOrDefault(col, 0));
            result += hm.get(col);
         }
        return result;
    }
    public int equalPairs3(int[][] grid) {
        //the solution above does not have good memory result
        //Try stringbuilder
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                sb.append(grid[i][j] + ",");
            }
            hm.put(sb.toString(), hm.getOrDefault(sb.toString(), 0) + 1);
        }

        int result = 0;
        for (int j = 0; j < grid[0].length; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < grid.length; i++) {
                sb.append(grid[i][j] + ",");
            }
            hm.put(sb.toString(), hm.getOrDefault(sb.toString(), 0));
            result += hm.get(sb.toString());
        }
        return result;
    }

    public int equalPairs(int[][] grid) {
        //The result above is even worse
        //try to save memory
        int result = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = 0;
                while(k < n){
                    if(grid[i][k] == grid[k][j]){
                        k++;
                    }else{
                        break;
                    }
                }
                if(k == n){
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        EqualRowandColumnPairs2352 res = new EqualRowandColumnPairs2352();
        int[][] grid = {{3,2,1},{1,7,6},{2,7,7}};
        System.out.println(res.equalPairs(grid));
    }
}
