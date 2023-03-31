  //Given n non-negative integers representing an elevation map where the width 
//of each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
// 
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) 
//are being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics Array Two Pointers Dynamic Programming Stack Monotonic Stack ?
//? 23814 👎 330

  
package com.q1angch0u.leetcode.editor.en;
public class TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            if (n < 2) {
                return 0;
            }
            int sum = 0;
            int[] leftHeight = new int[n];
            int[] rightHeight = new int[n];
            for (int i = 1; i < n - 1; i++) {
                leftHeight[i] = Math.max(leftHeight[i - 1], height[i]);
            }
            for (int i = n - 2; i > 0; i--) {
                rightHeight[i] = Math.max(rightHeight[i + 1], height[i]);
            }
            for (int i = 1; i < n - 1; i++) {
                int min = Math.min(leftHeight[i], rightHeight[i]);
                if (min > height[i]) {
                    sum += min - height[i];
                }
            }
            return sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}