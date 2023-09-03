//Given an integer array nums and an integer k, return the kᵗʰ largest element 
//in the array. 
//
// Note that it is the kᵗʰ largest element in the sorted order, not the kᵗʰ 
//distinct element. 
//
// Can you solve it without sorting? 
//
// 
// Example 1: 
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
// 
// Example 2: 
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
// 
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2214 👎 0

package com.q1angch0u.leetcode.editor.cn;
public class KthLargestElementInAnArray {
  public static void main(String[] args) {
    Solution solution = new KthLargestElementInAnArray(). new Solution();
  }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        int left = 0, right = n - 1, target = n - k;
        while (left < right) {
            int mid = quickSelect(nums, left, right);
            if (mid == target) {
                return nums[mid];
            }
            if (mid < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    private int quickSelect(int[] nums, int left, int right) {
        int base = left;
        while (left < right) {
            while (left < right && nums[base] <= nums[right]) {
                right--;
            }
            while (left < right && nums[base] >= nums[left]) {
                left++;
            }
            swap(nums, left, right);
        }
        swap(nums, base, left);
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

  }