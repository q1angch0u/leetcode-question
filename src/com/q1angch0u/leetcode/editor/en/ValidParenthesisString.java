//Given a string s containing only three types of characters: '(', ')' and '*', 
//return true if s is valid. 
//
// The following rules define a valid string: 
//
// 
// Any left parenthesis '(' must have a corresponding right parenthesis ')'. 
// Any right parenthesis ')' must have a corresponding left parenthesis '('. 
// Left parenthesis '(' must go before the corresponding right parenthesis ')'. 
//
// '*' could be treated as a single right parenthesis ')' or a single left 
//parenthesis '(' or an empty string "". 
// 
//
// 
// Example 1: 
// Input: s = "()"
//Output: true
// 
// Example 2: 
// Input: s = "(*)"
//Output: true
// 
// Example 3: 
// Input: s = "(*))"
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s[i] is '(', ')' or '*'. 
// 
//
// Related Topics String Dynamic Programming Stack Greedy 👍 3611 👎 90


package com.q1angch0u.leetcode.editor.en;

import java.util.Stack;

public class ValidParenthesisString{
public static void main(String[] args) {
    Solution solution = new ValidParenthesisString().new Solution();
    boolean res = solution.checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()");
    System.out.println(res);
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkValidString(String s) {
        char[] ss = s.toCharArray();
        int lo = 0, hi = 0;
        for (char c: ss) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}