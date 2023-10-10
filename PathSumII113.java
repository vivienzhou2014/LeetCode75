import java.util.ArrayList;
import java.util.List;

public class PathSumII113 {

    //  Definition for a binary tree node.
      public static class TreeNode {
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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            //pass to dfs root, diffSum(targetSum-node.val), path,result. everytime go down, add node.val to path
            //if leaf.val = diffSum then add path to result
            //also when leaf.val != diffSum, remove remove node.val from path when go up
            List<List<Integer>> result = new ArrayList<>();
            dfs(root, targetSum, new ArrayList<>(), result);
            return result;
        }

        private void dfs(TreeNode root, int diffSum, List<Integer> path, List<List<Integer>> result) {
            if(root == null){
                return;
            }
            path.add(root.val);
            if(root.left == null && root.right == null && root.val == diffSum){
                result.add(path);
            }
            dfs(root.left, diffSum - root.val, new ArrayList<>(path), result);//copy current path and give it to children
            dfs(root.right, diffSum - root.val, new ArrayList<>(path), result);
            if(root.val != diffSum) {
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PathSumII113 pathSumII = new PathSumII113();
        PathSumII113.TreeNode root = new PathSumII113.TreeNode(5);
        root.left = new PathSumII113.TreeNode(4);
        root.right = new PathSumII113.TreeNode(8);
        root.left.left = new PathSumII113.TreeNode(11);
        root.left.left.left = new PathSumII113.TreeNode(7);
        root.left.left.right = new PathSumII113.TreeNode(2);
        root.right.left = new PathSumII113.TreeNode(13);
        root.right.right = new PathSumII113.TreeNode(4);
        root.right.right.left = new PathSumII113.TreeNode(5);
        root.right.right.right = new PathSumII113.TreeNode(1);

        int targetSum = 22;

        PathSumII113.Solution solution = pathSumII.new Solution();
        List<List<Integer>> result = solution.pathSum(root, targetSum);

        // Print the result
        for (List<Integer> path : result) {
            System.out.println(path);
        }
    }
}
