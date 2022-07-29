//A phrase is a palindrome if, after converting all uppercase letters into 
//lowercase letters and removing all non-alphanumeric characters, it reads the same 
//forward and backward. Alphanumeric characters include letters and numbers. 
//
// Given a string s, return true if it is a palindrome, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
// 
//
// Example 2: 
//
// 
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric 
//characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s consists only of printable ASCII characters. 
// 
//
// Related Topics Two Pointers String 👍 4310 👎 5649


package com.q1angch0u.leetcode.editor.en;
public class ValidPalindrome{
    public static void main(String[] args) {
       Solution solution = new ValidPalindrome().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            char[] ss = s.toCharArray();
            int left = 0;
            int right = ss.length - 1;
            while (left < right) {

                while (!Character.isLetterOrDigit(ss[left]) && left < right) {
                    left++;
                }
                while (!Character.isLetterOrDigit(ss[right]) && left < right) {
                    right--;
                }

                if (Character.toLowerCase(ss[left++]) != Character.toLowerCase(ss[right--])) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}