import java.util.HashSet;

public class PathSum112 {

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
    static class Solution {
        /*public boolean hasPathSum(TreeNode root, int targetSum) {
        //brute force solution, using set to store all pathsum
        //return if set contains targetsum
            HashSet<Integer> set = new HashSet<>();
            dfs(root, 0, set);
            return set.contains(targetSum);
        }
        private void dfs(TreeNode root, int pathsum, HashSet set){
            if(root == null){
                return;
            }
            pathsum += root.val;
            System.out.print(pathsum + " ");
            if(root.left == null && root.right == null) {
                set.add(pathsum);
            }
            dfs(root.left, pathsum, set);
            dfs(root.right, pathsum, set);

        }*/
/*        public boolean hasPathSum(TreeNode root, int targetSum) {
            return dfs(root, 0, targetSum);
        }

        private boolean dfs(TreeNode root, int pathsum, int targetSum) {
            //check if leaves pathsum == targetsum
            //return all the leaves result using or, any leave is true, then true
            if(root == null){
                return false;
            }
            pathsum += root.val;
            if(root.left == null && root.right == null && pathsum == targetSum){
                return true;
            }
            return dfs(root.left, pathsum, targetSum) || dfs(root.right, pathsum, targetSum);
        }*/
        //optimize a bit by using diffSum(targetSum-root.val)
        //the first diffSum is targetSum
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root == null){
                return false;
            }
            //pathsum += root.val;
            if(root.left == null && root.right == null &&  root.val == targetSum){
                return true;
            }
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }

    }
    public static void main(String[] args) {
        // Create a sample binary tree
        PathSum112 pathSum112 = new PathSum112();
        PathSum112.TreeNode root = pathSum112.new TreeNode(5);
        root.left = pathSum112.new TreeNode(4);
        root.right = pathSum112.new TreeNode(8);
        root.left.left = pathSum112.new TreeNode(11);
        root.right.left = pathSum112.new TreeNode(13);
        root.right.right = pathSum112.new TreeNode(4);
        root.left.left.left = pathSum112.new TreeNode(7);
        root.left.left.right = pathSum112.new TreeNode(2);
        root.right.right.right = pathSum112.new TreeNode(1);

        PathSum112.Solution solution = new PathSum112.Solution();

        // Test cases
        int target1 = 22;
        int target2 = 21;
        int target3 = 18;

        boolean result1 = solution.hasPathSum(root, target1);
        boolean result2 = solution.hasPathSum(root, target2);
        boolean result3 = solution.hasPathSum(root, target3);

        System.out.println("Path with sum " + target1 + " exists: " + result1);
        System.out.println("Path with sum " + target2 + " exists: " + result2);
        System.out.println("Path with sum " + target3 + " exists: " + result3);
    }
}
