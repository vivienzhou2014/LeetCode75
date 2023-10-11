public class SearchinaBinarySearchTree700 {

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

        public TreeNode searchBST(TreeNode root, int val) {
            if(root == null){
                return null;
            }

            if(root.val == val){
                return root;
            } else if (root.val > val ) {
                return searchBST(root.left, val);
            }else{
                return searchBST(root.right, val);
            }

        }


        public static void main(String[] args) {
            SearchinaBinarySearchTree700 solution = new SearchinaBinarySearchTree700();

            // Example usage:
            // Create a simple binary search tree for testing
            TreeNode root = solution.new TreeNode(4);
            root.left = solution.new TreeNode(2);
            root.right = solution.new TreeNode(7);
            root.left.left = solution.new TreeNode(1);
            root.left.right = solution.new TreeNode(3);

            int targetValue = 2;
            TreeNode result = solution.searchBST(root, targetValue);

            if (result != null) {
                System.out.println("Node with value " + targetValue + " found in the tree.");
            } else {
                System.out.println("Node with value " + targetValue + " not found in the tree.");
            }
        }


}
