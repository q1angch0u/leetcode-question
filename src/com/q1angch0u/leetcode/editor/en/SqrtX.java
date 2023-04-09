//Given a non-negative integer x, return the square root of x rounded down to 
//the nearest integer. The returned integer should be non-negative as well. 
//
// You must not use any built-in exponent function or operator. 
//
// 
// For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python. 
// 
//
// 
// Example 1: 
//
// 
//Input: x = 4
//Output: 2
//Explanation: The square root of 4 is 2, so we return 2.
// 
//
// Example 2: 
//
// 
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since we round it down 
//to the nearest integer, 2 is returned.
// 
//
// 
// Constraints: 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// Related Topics Math Binary Search 👍 6196 👎 3976

package com.q1angch0u.leetcode.editor.en;
public class SqrtX {
  public static void main(String[] args) {
    Solution solution = new SqrtX().new Solution();
  }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int lo = 2, hi = x / 2;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long sq = (long) mid * mid;
            if (sq > x)
                hi = mid - 1;
            else if (sq < x)
                lo = mid + 1;
            else
                return mid;
        }
        return hi;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }