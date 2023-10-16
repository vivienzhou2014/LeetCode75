import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class NumberofProvinces547 {
    //for a graph, there are always two ways to loop though:bfs and dfs
    //this problem can also be solved by union find
    //let's try one by one
    public int findCircleNum1(int[][] isConnected) {
        //dfs
        //use a boolean[] or set to store visitied nodes
        //num of provinces(count) is 0
        //for each row in isConnected, if row is not visited
        //count++; pass this row number into dfs
        //in dfs, add row to visited, then loop the columns
        //if isconnected[row][column] is 1 and column is not in visited
        // (now we are treating column as row because of the 1 we found,
        // we need to use the connected nodes' column as row to keep finding new connections)
        //so pass column to dfs
        //after all the travels, when the code is back to the for row bracket, we know we found a province, go to next row
        HashSet<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if(!visited.contains(i)){
                count++;
                dfs(i, isConnected,visited);
            }
        }
        return count;
    }

    private void dfs(int row, int[][] isConnected, HashSet<Integer> visited) {
        visited.add(row);
        for (int j = 0; j < isConnected.length; j++) {
            if(isConnected[row][j] == 1 && !visited.contains(j)){
                dfs(j, isConnected, visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        //let's try bfs
        //bfs loop the matrix one by one, so we use queue
        HashSet<Integer> visited = new HashSet<>();
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int row = 0; row < isConnected.length; row++) {
            if(!visited.contains(row)) {
                q.offer(row);
                while (!q.isEmpty()) {
                    int cur = q.poll();//cur will be the row in while loop
                    //we are going to go through nodes, so add cur to visited
                    visited.add(cur);
                    for (int col = 0; col < isConnected.length; col++) {
                        if (isConnected[cur][col] == 1 && !visited.contains(col)) {
                            q.offer(col);//same idea, col will be the new cur if a node is found connected, we will start from that node
                        }
                    }
                }
                //when q is empty, travel ends, count++ and row go to the next one
                count++;
            }
        }
        return count;
    }







    /*public int findCircleNum(int[][] isConnected) {
        //use set to store all the cities
        //loop set, then loop the connected city from the first one, remove it from set
        //if there is connected ,go the that one, remove it from set
        // then from that one go to next connected one until go back to the first one, count++
        // when set is empty, loop end, return count
        HashSet<Integer> visited = new HashSet<>();
        //int  index = 0;
        for (int i = 0; i < isConnected.length; i++) {
            visited.add(i);
        }

        while(!visited.isEmpty()){
            while (!visited.contains(index)) {
                index++;
            }
            int[] city = isConnected[index];
            visited.remove(index);
            for (int c: city) {
                if(c == 1){

                }
            }
        }
        return process(isConnected, 0,visited, 0);
    }
    private static int process(int[][] isConnected, int count, HashSet<Integer> visited, int index){
        while(!visited.isEmpty()){
            while (!visited.contains(index)) {
                index++;
            }
            int[] city = isConnected[index];
            visited.remove(index);
            for (int c: city) {
                if(c == 1){

                }
            }
        }
        return count;
    }*/
}
