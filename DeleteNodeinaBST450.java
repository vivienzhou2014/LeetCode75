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
            //this problem needs us to divide all the situations
            //key < root, use root.left as new root and return root.left in case root.left changes
            // key > root, use root.right as new root and return root.right in case root.right changes
            //key == root, then we need to see if root has any child
            //if no child, root == null
            //if left child, no right, root = root.left
            //if right child, no left, root = root.right
            //if both children, use the min node in right tree to replace root
            // then recursively use min node and min val in deleteNode to delete min node
            if(root == null){
                return null;
            }
            if(key < root.val){
                root.left = deleteNode(root.left, key);
                //return root;
            } else if (key > root.val) {
                root.right = deleteNode(root.right, key);
                //return root;
            }else {
                if(root.right == null && root.left == null){
                    return null;
                } else if (root.right == null) {
                    return root.left;
                } else if (root.left == null) {
                    return root.right;
                }else{
                    //define a node and find the most left one from root.right
                    TreeNode node = root.right;
                    while(node.left != null){
                        node = node.left;
                    }
                    //someone pointed out that replacing value is not the perfect solution since val can be very complex
                    //root.val = node.val;
                    root.right = deleteNode(root.right, node.val);
                    //so I will do with ->
                    node.right = root.right;
                    node.left = root.left;
                    root = node;

                }
            }
           return root;

        }

        //optimized
        public TreeNode deleteNode1(TreeNode root, int key) {
            if(root == null){
                return null;
            }
            if(key < root.val){
                root.left = deleteNode(root.left, key);
                //return root;
            } else if (key > root.val) {
                root.right = deleteNode(root.right, key);
                //return root;
            }else {
                //seperated each if so that it can also handle no child situation
                if (root.right == null) {
                    return root.left;
                }
                if (root.left == null) {
                    return root.right;
                }

                TreeNode node = root.right;
                while(node.left != null){
                    node = node.left;
                }

                root.right = deleteNode(root.right, node.val);
                node.right = root.right;
                node.left = root.left;
                root = node;


            }
            return root;
        }


    }

    public static void main(String[] args) {
        DeleteNodeinaBST450 deleteNodeinaBST450 = new DeleteNodeinaBST450();
        DeleteNodeinaBST450.Solution solution = deleteNodeinaBST450.new Solution();

        // Create a sample BST
        //        5
        //       / \
        //      3   8
        //     / \ / \
        //    2  4 6  9

        TreeNode root = deleteNodeinaBST450.new TreeNode(5);
        root.left = deleteNodeinaBST450.new TreeNode(3);
        root.right = deleteNodeinaBST450.new TreeNode(8);
        root.left.left = deleteNodeinaBST450.new TreeNode(2);
        root.left.right = deleteNodeinaBST450.new TreeNode(4);
        root.right.left = deleteNodeinaBST450.new TreeNode(6);
        root.right.right = deleteNodeinaBST450.new TreeNode(9);

        // Print the original BST
        System.out.println("Original BST:");
        printBST(root);

        // Delete a node with key 3
        int keyToDelete = 3;
        root = solution.deleteNode(root, keyToDelete);

        // Print the BST after deletion
        System.out.println("BST after deleting node with key " + keyToDelete + ":");
        printBST(root);
    }

    // Helper method to print the BST in-order
    public static void printBST(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        printBST(node.left);

        printBST(node.right);
    }
}
