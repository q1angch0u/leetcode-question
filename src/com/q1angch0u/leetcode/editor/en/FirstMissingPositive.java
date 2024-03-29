  //Given an unsorted integer array nums, return the smallest missing positive 
//integer. 
//
// You must implement an algorithm that runs in O(n) time and uses constant 
//extra space. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,0]
//Output: 3
//Explanation: The numbers in the range [1,2] are all in the array.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,4,-1,1]
//Output: 2
//Explanation: 1 is in the array but 2 is missing.
// 
//
// Example 3: 
//
// 
//Input: nums = [7,8,9,11,12]
//Output: 1
//Explanation: The smallest positive integer 1 is missing.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// Related Topics Array Hash Table 👍 12695 👎 1514

  
package com.q1angch0u.leetcode.editor.en;
public class FirstMissingPositive{
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return -1;
            }
            for (int i = 0; i < n; i++) {
                while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, i, nums[i] - 1);
                }
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return n + 1;
        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}