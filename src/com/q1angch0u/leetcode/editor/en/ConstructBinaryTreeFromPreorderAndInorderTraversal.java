//Given two integer arrays preorder and inorder where preorder is the preorder
//traversal of a binary tree and inorder is the inorder traversal of the same tree,
// construct and return the binary tree. 
//
// 
// Example 1: 
// 
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder and inorder consist of unique values. 
// Each value of inorder also appears in preorder. 
// preorder is guaranteed to be the preorder traversal of the tree. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// 
//
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 👍 11524 
//👎 327


package com.q1angch0u.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {

            int n = preorder.length;
            if (n == 0) {
                return null;
            }
            Map<Integer, Integer> inorderMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                inorderMap.put(inorder[i], i);
            }

            return buildTree(preorder, inorderMap, 0, n - 1, 0, n - 1);

        }

        private TreeNode buildTree(int[] preorder, Map<Integer, Integer> map, int preLeft, int preRight, int inLeft, int inRight) {
            if (preLeft > preRight || inLeft > inRight) {
                return null;
            }
            Integer val = preorder[preLeft];
            Integer pIndex = map.get(val);
            TreeNode node = new TreeNode(val);
            node.left = this.buildTree(preorder, map, preLeft + 1, pIndex + preLeft - inLeft, inLeft, pIndex - 1);
            node.right = this.buildTree(preorder, map, pIndex + preLeft - inLeft + 1, preRight, pIndex + 1, inRight);
            return node;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}