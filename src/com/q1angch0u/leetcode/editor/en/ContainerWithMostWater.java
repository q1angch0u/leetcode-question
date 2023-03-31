//You are given an integer array height of length n. There are n vertical lines 
//drawn such that the two endpoints of the iᵗʰ line are (i, 0) and (i, height[i]).
// 
//
// Find two lines that together with the x-axis form a container, such that the 
//container contains the most water. 
//
// Return the maximum amount of water a container can store. 
//
// Notice that you may not slant the container. 
//
// 
// Example 1: 
// 
// 
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,
//3,7]. In this case, the max area of water (blue section) the container can 
//contain is 49.
// 
//
// Example 2: 
//
// 
//Input: height = [1,1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics Array Two Pointers Greedy 👍 18852 👎 1027


package com.q1angch0u.leetcode.editor.en;
public class ContainerWithMostWater{
    public static void main(String[] args) {
       Solution solution = new ContainerWithMostWater().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int res = 0;
        int left = 0, right = n - 1;
        while (left < right) {
            res = Math.max((right - left) * Math.min(height[right], height[left]), res);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}