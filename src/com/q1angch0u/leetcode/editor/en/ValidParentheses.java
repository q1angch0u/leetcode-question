//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: s = "(]"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of parentheses only '()[]{}'. 
// 
//
// Related Topics String Stack 👍 14350 👎 672


package com.q1angch0u.leetcode.editor.en;

import java.util.Stack;

public class ValidParentheses{
public static void main(String[] args) {
   Solution solution = new ValidParentheses().new Solution();
}
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Stack<Character> data = new Stack<>();

    public boolean isValid(String s) {
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            char c = ss[i];
            if (c == '{' || c == '[' || c == '(') {
                data.push(c);
            } else {
                if (data.isEmpty()) {
                    return false;
                }
                char d = data.pop();
                if (!checkParentheses(d, c)) {
                    return false;
                }
            }
        }
        return data.isEmpty();
    }

    private boolean checkParentheses(char s, char d) {
        return (s == '(' && d == ')') || (s == '{' && d == '}') || (s == '[' && d == ']');
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}