public class DeleteNodeinaBST450 {

    //  Definition for a binary tree node.
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
        public TreeNode deleteNode(TreeNode root, int key) {
            dfs(root, key);
            return root;
        }

        private void dfs(TreeNode root, int key) {
            if(root == null){
                return;
            }
            
        }
    }
}
