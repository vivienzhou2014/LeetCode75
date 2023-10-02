import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeafSimilarTrees872 {

 //     Definition for a binary tree node.
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

        public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
            //uss StringBuilder to store leaves for each tree
            //string does not perform well in runtime and memory, try arraylist
            /*StringBuilder str1 = new StringBuilder();
            StringBuilder str2 = new StringBuilder();*/
            List<Integer> str1 = new ArrayList<>();
            List<Integer> str2 = new ArrayList<>();
            //use DFS to recursively loop to the leaves from root
            DFS(root1, str1);
            DFS(root2, str2);
            //compare two strings
            //return str1.toString().equals(str2.toString());
            if(str1.size() != str2.size()){
                return false;
            }
            for (int i = 0; i < str2.size(); i++) {
                if(str1.get(i) != str2.get(i)){
                    return false;
                }
            }
            return true;
        }
        public static void DFS(TreeNode root, List str){
            if(root == null){
                return;
            }
            if(root.left == null && root.right == null){
                str.add(root.val);
            }
            DFS(root.left, str);
            DFS(root.right, str);
        }

    public static void main(String[] args) {
        LeafSimilarTrees872 treeComparer = new LeafSimilarTrees872();

        // Create two sample binary trees
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);

        // Test the leafSimilar method and print the result
        boolean areSimilar = treeComparer.leafSimilar(root1, root2);
        if (areSimilar) {
            System.out.println("The trees are leaf similar.");
        } else {
            System.out.println("The trees are not leaf similar.");
        }
    }

}
