import java.util.*;

public class BinaryTreeRightSideView199 {

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
/*        public List<Integer> rightSideView(TreeNode root) {
            //brute force method
            //use hashmap, key is each level of tree, value is node.val
            //since we keep updating the value, the most right one is the one we last updated
            //loop through the hashmap, add all the value to an arraylist
            HashMap<Integer, Integer> right = new HashMap<>();
            dfs(root, 0, right);
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < right.size(); i++) {
                result.add(right.get(i));
            }
            return result;
        }

        private void dfs(TreeNode root, int level, HashMap<Integer, Integer> right) {
            if(root == null){
                return;
            }
            right.put(level, root.val);
            dfs(root.left, level + 1, right);
            dfs(root.right, level + 1, right);
        }*/

        /*public List<Integer> rightSideView(TreeNode root) {
            //try bfs
            //use queue to store children, put the last one in queue to result
            // (how to know the last one?)
            //queue.size() - 1 is the last one since we put both side's children into the queue after polling the node

            Queue<TreeNode> queue = new LinkedList<>();
            List<Integer> result = new ArrayList<>();
            if(root == null){
                return result;
            }
            //image we are standing one a level higher than root, root is our child, so put root inside
            queue.offer(root);
            while(!queue.isEmpty()){
                //make size constant in for loop
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if(node.left != null){
                        queue.offer(node.left);
                    }
                    if(node.right != null){
                        queue.offer(node.right);
                    }
                    if(i == size - 1) {
                        result.add(node.val);
                    }
                }

            }
            return result;
        }*/

        List<Integer> result = new ArrayList<>();
        //not putting result in parameter has better memory result
        public List<Integer> rightSideView(TreeNode root) {
            //optimize dfs
            //in previous hashmap, the keys we stored are purely 0-n, so we can actually store it in an arraylist
            //List<Integer> result = new ArrayList<>();
            dfs(root, 0);
            return result;
        }
        private void dfs(TreeNode root, int level){
            //go from right to left so the first one stored in the arraylist is the one we need
            //so we only put node.val in when result[level] is null
            if(root == null){
                return;
            }
            //this is the most important step
            //the size of the arraylist is the same as the new level when children first step into this level
            if(result.size() == level){
                result.add(root.val);
            }
            dfs(root.right, level + 1);
            dfs(root.left, level + 1);
        }
    }
    public static void main(String[] args) {
        BinaryTreeRightSideView199 binaryTreeRightSideView = new BinaryTreeRightSideView199();
        BinaryTreeRightSideView199.TreeNode root = new BinaryTreeRightSideView199.TreeNode(1);
        root.left = new BinaryTreeRightSideView199.TreeNode(2);
        root.left.right = new BinaryTreeRightSideView199.TreeNode(3);
        root.left.left = new BinaryTreeRightSideView199.TreeNode(5);
        root.left.left.left = new BinaryTreeRightSideView199.TreeNode(4);

        BinaryTreeRightSideView199.Solution solution = binaryTreeRightSideView.new Solution();
        List<Integer> result = solution.rightSideView(root);

        System.out.println("Right Side View of the Binary Tree:");
        for (Integer val : result) {
            System.out.print(val + " ");
        }
    }
}





