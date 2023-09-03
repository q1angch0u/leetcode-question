//Given an integer array nums of unique elements, return all possible subsets (
//the power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in 
//any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// Example 2: 
//
// 
//Input: nums = [0]
//Output: [[],[0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// All the numbers of nums are unique. 
// 
//
// Related Topics 位运算 数组 回溯 👍 2108 👎 0

package com.q1angch0u.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
    Solution solution = new Subsets(). new Solution();
  }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums.length == 0) {
                return res;
            }
            dfs(res, new ArrayList<>(), nums, 0);
            return res;
        }

        private void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, int depth) {
            if (depth == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            dfs(res, path, nums, depth + 1);
            path.add(nums[depth]);
            dfs(res, path, nums, depth + 1);
            path.remove(path.size() - 1);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}