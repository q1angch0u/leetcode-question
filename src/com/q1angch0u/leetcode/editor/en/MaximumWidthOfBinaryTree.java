//Given the root of a binary tree, return the maximum width of the given tree. 
//
// The maximum width of a tree is the maximum width among all levels. 
//
// The width of one level is defined as the length between the end-nodes (the 
//leftmost and rightmost non-null nodes), where the null nodes between the end-
//nodes that would be present in a complete binary tree extending down to that level 
//are also counted into the length calculation. 
//
// It is guaranteed that the answer will in the range of a 32-bit signed 
//integer. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,3,2,5,3,null,9]
//Output: 4
//Explanation: The maximum width exists in the third level with length 4 (5,3,
//null,9).
// 
//
// Example 2: 
// 
// 
//Input: root = [1,3,2,5,null,null,9,6,null,7]
//Output: 7
//Explanation: The maximum width exists in the fourth level with length 7 (6,
//null,null,null,null,null,7).
// 
//
// Example 3: 
// 
// 
//Input: root = [1,3,2,5]
//Output: 2
//Explanation: The maximum width exists in the second level with length 2 (3,2).
//
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 3000]. 
// -100 <= Node.val <= 100 
// 
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 68
//29 👎 933

package com.q1angch0u.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class MaximumWidthOfBinaryTree {
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
  public static void main(String[] args) {
    Solution solution = new MaximumWidthOfBinaryTree(). new Solution();
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

    Map<Integer, Integer> level = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1);
    }

    public int dfs(TreeNode node, int depth, int index) {
        if (node == null) {
            return 0;
        }
        level.putIfAbsent(depth, index);
        return Math.max(
                index - level.get(depth) + 1,
                Math.max(
                        dfs(node.left, depth + 1, index * 2),
                        dfs(node.right, depth + 1, index * 2 + 1)
                )
        );
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }