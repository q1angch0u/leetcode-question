//You are given a string s. You can convert s to a palindrome by adding 
//characters in front of it. 
//
// Return the shortest palindrome you can find by performing this 
//transformation. 
//
// 
// Example 1: 
// Input: s = "aacecaaa"
//Output: "aaacecaaa"
// 
// Example 2: 
// Input: s = "abcd"
//Output: "dcbabcd"
// 
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of lowercase English letters only. 
// 
//
// Related Topics 字符串 字符串匹配 哈希函数 滚动哈希 👍 539 👎 0

package com.q1angch0u.leetcode.editor.cn;
public class ShortestPalindrome {
  public static void main(String[] args) {
    Solution solution = new ShortestPalindrome(). new Solution();
  }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        String longestPalindrome = longestPalindrome(s);
//        System.out.println(longestPalindrome);
        int charAt = longestPalindrome.length();
        return new StringBuilder(s.substring(charAt, n)).reverse().append(s).toString();
    }

    private String longestPalindrome(String s) {
        char[] ss = s.toCharArray();
        int n = ss.length;
        if (n == 0) {
            return "";
        }
        boolean[][] dp = new boolean[n][n];
        int end = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (ss[i] != ss[j]) {
                    continue;
                }
                if (j - i < 2 || dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (j - i > end && i == 0) {
                        end = j;
                    }
                }
            }
        }
        return s.substring(0, end + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }