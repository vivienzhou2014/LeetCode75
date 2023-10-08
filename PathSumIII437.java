import java.util.HashMap;
import java.util.HashSet;

public class PathSumIII437 {

      //Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    class Solution {
        //HashMap<Integer, Integer> sumCount = new HashMap<>();
/*        public int pathSum(TreeNode root, int targetSum) {
        //get each path's presum and store them in a hashmap, value is how many time the presum appears
            HashMap<Integer, Integer> sumCount = new HashMap<>();
            int presum = 0;
            dfs(root, presum);
            return sumCount.get(targetSum);
        }

        private void dfs(TreeNode root, int presum) {
            //basecase
            if(root == null){
                return;
            }
            //when recursively down, add presum
            presum += root.val;
            dfs(root.left, presum);
            dfs(root.right, presum);
            //when recursively up, put presum to sumCount
            sumCount.put(presum, sumCount.getOrDefault(presum,0)+1);
        }*/

        /*public int pathSum(TreeNode root, int targetSum) {
            //https://chaudhary1337.com/path-sum-iii-solution-explained/
            // Create a HashMap to store the prefix sums and their counts
            HashMap<Integer, Integer> sumCount = new HashMap<>();
            // Initialize the HashMap with a presum of 0
            sumCount.put(0, 1);

            // Start DFS from the root
            return dfs(root, 0, targetSum, sumCount);
        }

        private int dfs(TreeNode node, int currentSum, int targetSum, HashMap<Integer, Integer> sumCount) {
            if (node == null) {
                return 0;
            }

            // Update the current sum by adding the node's value
            currentSum += node.val;

            // Calculate how many paths with the current sum - targetSum we've seen so far
            int count = sumCount.getOrDefault(currentSum - targetSum, 0);

            // Update the sumCount HashMap
            sumCount.put(currentSum, sumCount.getOrDefault(currentSum, 0) + 1);

            // Recursively explore the left and right subtrees
            int leftCount = dfs(node.left, currentSum, targetSum, sumCount);
            int rightCount = dfs(node.right, currentSum, targetSum, sumCount);

            // Backtrack by removing the current sum from the HashMap
            sumCount.put(currentSum, sumCount.get(currentSum) - 1);

            // Return the total count, which includes counts from left and right subtrees
            return count + leftCount + rightCount;
        }*/

        public int pathSum(TreeNode root, int targetSum) {
            //brute force solution
            //get pathsum, if pathsum == targetsum, count++
            //add reset to avoid recount resetted node
            return dfs(root, 0, targetSum, false);
        }
        HashSet<TreeNode> resetted = new HashSet<>();
        private int dfs(TreeNode root, long pathsum, int targetSum, boolean reset){
            if(root == null){
                return 0;
            }
            if(reset && resetted.contains(root)){
                return 0;
            }
            if(reset && pathsum == 0){
                resetted.add(root);
            }

            pathsum += root.val;
            int count = pathsum == targetSum? 1: 0;
            /*System.out.print("pathsum: " + pathsum);
            System.out.print("count: "+ count);
            System.out.println("--------");*/
            count += dfs(root.left, pathsum, targetSum, false);
            count += dfs(root.right, pathsum, targetSum, false);
            //System.out.println(count);
            count += dfs(root.left, 0, targetSum, true);
            count += dfs(root.right, 0, targetSum, true);
            //System.out.println(count);

            return count;
        }

        /*int result = 0;
        HashMap<Long, Integer> presum = new HashMap<>();
        public int pathSum(TreeNode root, int targetSum) {
            presum.put(Long.valueOf(targetSum), 1);
             dfs(root, 0,targetSum);
             return result;
        }

        private void dfs(TreeNode root, long pathsum,int targetSum) {
            if(root == null){
                return;
            }
            pathsum += root.val;
            result += presum.getOrDefault(pathsum,0);
            presum.put(pathsum+targetSum, presum.getOrDefault(pathsum+targetSum, 0) + 1);
            dfs(root.left, pathsum,targetSum);
            dfs(root.right, pathsum,targetSum);
            presum.put(pathsum+targetSum, presum.get(pathsum+targetSum) - 1);
        }*/

    }

    public static void main(String[] args) {
          PathSumIII437 path = new PathSumIII437();
          PathSumIII437.Solution solution = path.new Solution();
        TreeNode root = path.new TreeNode(10);
        root.left = path.new TreeNode(5);
        root.right = path.new TreeNode(-3);
        root.left.left = path.new TreeNode(3);
        root.left.right = path.new TreeNode(2);
        root.right.right = path.new TreeNode(11);
        root.left.left.left = path.new TreeNode(3);
        root.left.left.right = path.new TreeNode(-2);
        root.left.right.right = path.new TreeNode(1);
/*        TreeNode root = path.new TreeNode(1000000000);
        root.left = path.new TreeNode(100000000);
        root.left.left = path.new TreeNode(294967296);
        root.left.left.left = path.new TreeNode(1000000000);
        root.left.left.left.left = path.new TreeNode(1000000000);
        root.left.left.left.left.left = path.new TreeNode(1000000000);*/

        int targetSum = 8;

        int result = solution.pathSum(root, targetSum);

        System.out.println("Number of paths with sum " + targetSum + ": " + result);
    }

}
