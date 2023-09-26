import java.util.Arrays;

public class EqualRowandColumnPairs2352 {
    public static int equalPairs(int[][] grid) {
        //my idea is to use each row(grid[0] grid[1]..) compare to each column(grid[0][0], [1][0]..)
        //so I will flip to matrix to make columns to rows and then compare each rows of two matrix
        //to flip make grid[i][j] to grid[j][i]
        int n = grid.length;
        //int[][] flippedGrid = new int[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //flippedGrid[j][i] = grid[i][j];
                if(grid[i][j] == grid[j][i]){
                    count++;
                }
            }
        }

        //now compare rows
        //int count = 0;
/*        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == flippedGrid[i][j]){
                    count++;
                }
            }
        }*/
        //if found one ==, count++
        return count/n;
    }

    public static void main(String[] args) {
        int[][] grid = {{3,2,1},{1,7,6},{2,7,7}};
        System.out.println(equalPairs(grid));
    }
}
