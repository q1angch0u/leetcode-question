  //Given two integer arrays inorder and postorder where inorder is the inorder 
//traversal of a binary tree and postorder is the postorder traversal of the same 
//tree, construct and return the binary tree. 
//
// 
// Example 1: 
// 
// 
//Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: inorder = [-1], postorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder and postorder consist of unique values. 
// Each value of postorder also appears in inorder. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// postorder is guaranteed to be the postorder traversal of the tree. 
// 
//
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 👍 5746 ?
//? 86

  
package com.q1angch0u.leetcode.editor.en;

  import java.util.HashMap;
  import java.util.Map;

  public class ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length || inorder.length == 0) {
            return null;
        }
        int n = inorder.length;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(postorder, inorderMap, 0, n - 1, 0, n - 1);
    }

    private TreeNode buildTree(int[] postorder, Map<Integer, Integer> inorderMap, int postLeft, int postRight, int inLeft, int inRight) {
        if (postLeft > postRight || inLeft > inRight) {
            return null;
        }

        int val = postorder[postRight];
        int pIndex = inorderMap.get(val);

        TreeNode node = new TreeNode(val);
        node.left = buildTree(postorder, inorderMap, postLeft, pIndex - inLeft + postLeft - 1, inLeft, pIndex - 1);
        node.right = buildTree(postorder, inorderMap, pIndex - inLeft + postLeft, postRight - 1, pIndex + 1, inRight);
        return node;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}