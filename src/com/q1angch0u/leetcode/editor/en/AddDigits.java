//Given an integer num, repeatedly add all its digits until the result has only 
//one digit, and return it. 
//
// 
// Example 1: 
//
// 
//Input: num = 38
//Output: 2
//Explanation: The process is
//38 --> 3 + 8 --> 11
//11 --> 1 + 1 --> 2 
//Since 2 has only one digit, return it.
// 
//
// Example 2: 
//
// 
//Input: num = 0
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= num <= 2³¹ - 1 
// 
//
// 
// Follow up: Could you do it without any loop/recursion in O(1) runtime? 
//
// Related Topics Math Simulation Number Theory 👍 2626 👎 1679


package com.q1angch0u.leetcode.editor.en;
public class AddDigits{
    public static void main(String[] args) {
       Solution solution = new AddDigits().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int addDigits(int num) {
        return num == 0 ? 0 : 1 + (num - 1) % 9;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}