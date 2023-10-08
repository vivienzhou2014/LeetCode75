public class LongestZigZagPathinaBinaryTree1372 {

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
        int max = 0;
        //int count = 0;
        public int longestZigZag(TreeNode root) {
            //this problem is for any node to go to left then right then left until node null, then return max path count
            //first we need to have a boolean to mark if current node isleft
            //if isleft, go to right, if !isleft, go to left
            //base case should be node == null, return
            //also need a global int count to count path and max to update the max path
            dfs(root, 0,true);
            dfs(root, 0,false);
            return max;
        }

        private void dfs(TreeNode root, int count, boolean isleft){
            if(root == null){

                return;
            }
            max = count > max ? count : max;
            //count++;
            if(isleft){
                dfs(root.right, ++count, false);
                dfs(root.left, 0, false);
            }else{
                dfs(root.left, ++count, true);
                dfs(root.right, 0, true);
            }
            //dfs(root.right, 0, false);
            //dfs(root.left, 0, true);
        }
    }

    public static void main(String[] args) {
        LongestZigZagPathinaBinaryTree1372 tree = new LongestZigZagPathinaBinaryTree1372();
        /*LongestZigZagPathinaBinaryTree1372.TreeNode root = tree.new TreeNode(1);
        root.left = tree.new TreeNode(2);
        root.right = tree.new TreeNode(3);
        root.left.right = tree.new TreeNode(4);
        root.right.left = tree.new TreeNode(5);
        root.right.right = tree.new TreeNode(6);
        root.right.left.left = tree.new TreeNode(7);*/
        LongestZigZagPathinaBinaryTree1372.TreeNode root = tree.new TreeNode(1);
        root.right = tree.new TreeNode(1);
        root.right.left = tree.new TreeNode(1);
        root.right.right = tree.new TreeNode(1);
        root.right.right.left = tree.new TreeNode(1);
        root.right.right.right = tree.new TreeNode(1);
        root.right.right.left.right = tree.new TreeNode(1);

        Solution solution = tree.new Solution();
        int result = solution.longestZigZag(root);
        System.out.println("Longest ZigZag Path Length: " + result); // Print the result
    }
}
