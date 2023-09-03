//You are given an integer array prices where prices[i] is the price of a given 
//stock on the iᵗʰ day. 
//
// On each day, you may decide to buy and/or sell the stock. You can only hold 
//at most one share of the stock at any time. However, you can buy it then 
//immediately sell it on the same day. 
//
// Find and return the maximum profit you can achieve. 
//
// 
// Example 1: 
//
// 
//Input: prices = [7,1,5,3,6,4]
//Output: 7
//Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 
//5-1 = 4.
//Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
//
//Total profit is 4 + 3 = 7.
// 
//
// Example 2: 
//
// 
//Input: prices = [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 
//5-1 = 4.
//Total profit is 4.
// 
//
// Example 3: 
//
// 
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: There is no way to make a positive profit, so we never buy the 
//stock to achieve the maximum profit of 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 3 * 10⁴ 
// 0 <= prices[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2234 👎 0

package com.q1angch0u.leetcode.editor.cn;
public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
    Solution solution = new BestTimeToBuyAndSellStockII(). new Solution();
  }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            // dp[i][0] 不持有
            // dp[i][1] 持有
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[n - 1][0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

  }