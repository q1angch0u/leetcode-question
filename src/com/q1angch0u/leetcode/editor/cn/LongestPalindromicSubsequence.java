//Given a string s, find the longest palindromic subsequence's length in s. 
//
// A subsequence is a sequence that can be derived from another sequence by 
//deleting some or no elements without changing the order of the remaining elements. 
//
// 
// Example 1: 
//
// 
//Input: s = "bbbab"
//Output: 4
//Explanation: One possible longest palindromic subsequence is "bbbb".
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: 2
//Explanation: One possible longest palindromic subsequence is "bb".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists only of lowercase English letters. 
// 
//
// Related Topics 字符串 动态规划 👍 1100 👎 0

package com.q1angch0u.leetcode.editor.cn;
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
    Solution solution = new LongestPalindromicSubsequence(). new Solution();
  }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindromeSubseq(String s) {
            char[] ss = s.toCharArray();
            int n = ss.length;
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (ss[i] == ss[j]) {
                        dp[j][i] = dp[j + 1][i - 1] + 2;
                    } else {
                        dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

  }