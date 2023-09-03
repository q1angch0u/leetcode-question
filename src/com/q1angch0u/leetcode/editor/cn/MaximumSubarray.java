//Given an integer array nums, find the subarray with the largest sum, and 
//return its sum. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: The subarray [4,-1,2,1] has the largest sum 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
//Explanation: The subarray [1] has the largest sum 1.
// 
//
// Example 3: 
//
// 
//Input: nums = [5,4,-1,7,8]
//Output: 23
//Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
// Follow up: If you have figured out the O(n) solution, try coding another 
//solution using the divide and conquer approach, which is more subtle. 
//
// Related Topics 数组 分治 动态规划 👍 6207 👎 0

package com.q1angch0u.leetcode.editor.cn;
public class MaximumSubarray {
  public static void main(String[] args) {
    Solution solution = new MaximumSubarray(). new Solution();
  }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            int sum = nums[0], max = nums[0];
            for (int i = 1; i < n; i++) {
                if (sum > 0) {
                    sum += nums[i];
                } else {
                    sum = nums[i];
                }
                max = Math.max(max, sum);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

  }