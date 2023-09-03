//Given n pairs of parentheses, write a function to generate all combinations 
//of well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// 
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3323 👎 0

package com.q1angch0u.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
  public static void main(String[] args) {
    Solution solution = new GenerateParentheses(). new Solution();
  }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if (n == 0) {
                return res;
            }
            backtrace(res, new StringBuilder(), 0, 0, n);
            return res;
        }

        private void backtrace(List<String> res, StringBuilder sb, int left, int right, int n) {
            if (left + right == 2 * n) {
                res.add(sb.toString());
                return;
            }
            if (left < n) {
                sb.append('(');
                backtrace(res, sb, left + 1, right, n);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (right < left) {
                sb.append(')');
                backtrace(res, sb, left, right + 1, n);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

  }