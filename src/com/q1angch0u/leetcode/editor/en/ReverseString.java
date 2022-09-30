//Write a function that reverses a string. The input string is given as an 
//array of characters s. 
//
// You must do this by modifying the input array in-place with O(1) extra 
//memory. 
//
// 
// Example 1: 
// Input: s = ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]
// 
// Example 2: 
// Input: s = ["H","a","n","n","a","h"]
//Output: ["h","a","n","n","a","H"]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is a printable ascii character. 
// 
//
// Related Topics Two Pointers String Recursion 👍 5620 👎 978


package com.q1angch0u.leetcode.editor.en;
public class ReverseString{
    public static void main(String[] args) {
       Solution solution = new ReverseString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseString(char[] s) {
        int length = s.length;
        for (int i = 0; i < length / 2; i++) {
            char t = s[i];
            s[i] = s[length - i - 1];
            s[length - i - 1] = t;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}