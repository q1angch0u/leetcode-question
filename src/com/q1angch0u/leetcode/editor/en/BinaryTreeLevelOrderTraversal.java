  //Given the root of a binary tree, return the level order traversal of its 
//nodes' values. (i.e., from left to right, level by level). 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[9,20],[15,7]]
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: [[1]]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2000]. 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics Tree Breadth-First Search Binary Tree 👍 11518 👎 221

  
package com.q1angch0u.leetcode.editor.en;

  import java.util.ArrayList;
  import java.util.LinkedList;
  import java.util.List;
  import java.util.Queue;

  public class BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
    }
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

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> nodes = new LinkedList<>();
            nodes.offer(root);
            while (!nodes.isEmpty()) {
                int size = nodes.size();
                List<Integer> levelRes = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = nodes.poll();
                    levelRes.add(node.val);
                    if (node.left != null) {
                        nodes.offer(node.left);
                    }
                    if (node.right != null) {
                        nodes.offer(node.right);
                    }
                }
                res.add(levelRes);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}