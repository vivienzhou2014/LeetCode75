public class CountGoodNodesinBinaryTree1448 {

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
        /*public int goodNodes(TreeNode root) {
            //set max to -10^4 since this is stated in the constraint for node value
            int max = -10000;
            return dfs(root,max);
        }
        public int dfs(TreeNode root,  int max){
            if(root == null){
                return 0;
            }
            //if root.val is the max in the path, count = 1, otherwise count is 0
            int count = 0;
            if(root.val >= max){
                max = root.val;
                count = 1;
            }
            //add all counts from left and right leaves to get total count
            //System.out.println(count);
            count += dfs(root.left, max);
            //System.out.println(count);
            count += dfs(root.right, max);
            //System.out.println(count);
            return count;
        }*/
        //use global variable to lock the max of count
        int count = 0;
        //int max = -10000;
        public int goodNodes(TreeNode root) {
            //try to do void dfs
            dfs(root, -10000);
            return count;
        }

        public void dfs(TreeNode root, int max) {
            if(root == null){
                return;
            }
            if(root.val >= max){
                max = root.val;
                count++;
            }
            dfs(root.left, max);
            dfs(root.right, max);
        }
    }

    public static void main(String[] args) {
        CountGoodNodesinBinaryTree1448 main = new CountGoodNodesinBinaryTree1448();
        CountGoodNodesinBinaryTree1448.Solution solution = main.new Solution();

        // Create a binary tree
        TreeNode root = main.new TreeNode(3);
        root.left = main.new TreeNode(1);
        root.right = main.new TreeNode(4);
        root.left.left = main.new TreeNode(3);
        root.right.left = main.new TreeNode(1);
        root.right.right = main.new TreeNode(5);

        // Call the goodNodes method to count good nodes
        int goodNodeCount = solution.goodNodes(root);
        System.out.println("Number of good nodes: " + goodNodeCount);
    }
}
