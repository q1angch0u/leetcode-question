//Given two sorted arrays nums1 and nums2 of size m and n respectively, return 
//the median of the two sorted arrays. 
//
// The overall run time complexity should be O(log (m+n)). 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 6679 👎 0

package com.q1angch0u.leetcode.editor.cn;
public class MedianOfTwoSortedArrays {
  public static void main(String[] args) {
    Solution solution = new MedianOfTwoSortedArrays(). new Solution();
  }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int k = m + n;
            int prev = 0, curr = 0;
            int i = 0, j = 0;
            for (int l = 0; l <= k / 2; l++) {
                prev = curr;
                if (i < m && (j >= n || nums1[i] < nums2[j])) {
                    curr = nums1[i++];
                } else {
                    curr = nums2[j++];
                }
            }
            if (k % 2 == 0) {
                return (prev + curr) / 2D;
            }
            return curr;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

  }