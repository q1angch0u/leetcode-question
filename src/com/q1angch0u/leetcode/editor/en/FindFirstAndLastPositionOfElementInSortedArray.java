  //Given an array of integers nums sorted in non-decreasing order, find the 
//starting and ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// 
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// 
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums is a non-decreasing array. 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics Array Binary Search 👍 15988 👎 377

  
package com.q1angch0u.leetcode.editor.en;
public class FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int n = nums.length;
        if (n == 0) {
            return res;
        }
        int left = 0, right = n - 1;
        while (left <= right) {
            if (nums[left] < target) {
                left++;
                continue;
            }
            if (nums[right] < target) {
                right--;
                continue;
            }
            while (left >= 0 && nums[left] == target) {
                left--;
            }
            while (right < n && nums[right] == target) {
                right++;
            }
            res[0] = left + 1;
            res[1] = right - 1;
            return res;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}