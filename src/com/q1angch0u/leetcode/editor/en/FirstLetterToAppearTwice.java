//Given a string s consisting of lowercase English letters, return the first 
//letter to appear twice. 
//
// Note: 
//
// 
// A letter a appears twice before another letter b if the second occurrence of 
//a is before the second occurrence of b. 
// s will contain at least one letter that appears twice. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "abccbaacz"
//Output: "c"
//Explanation:
//The letter 'a' appears on the indexes 0, 5 and 6.
//The letter 'b' appears on the indexes 1 and 4.
//The letter 'c' appears on the indexes 2, 3 and 7.
//The letter 'z' appears on the index 8.
//The letter 'c' is the first letter to appear twice, because out of all the 
//letters the index of its second occurrence is the smallest.
// 
//
// Example 2: 
//
// 
//Input: s = "abcdd"
//Output: "d"
//Explanation:
//The only letter that appears twice is 'd' so we return 'd'.
// 
//
// 
// Constraints: 
//
// 
// 2 <= s.length <= 100 
// s consists of lowercase English letters. 
// s has at least one repeated letter. 
// 
//
// Related Topics Hash Table String Counting 👍 157 👎 6


package com.q1angch0u.leetcode.editor.en;
public class FirstLetterToAppearTwice{
    public static void main(String[] args) {
       Solution solution = new FirstLetterToAppearTwice().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char repeatedCharacter(String s) {
            char[] ss = s.toCharArray();
            boolean[] res = new boolean[26];
            for (int c: ss) {
                c -= 'a';
                if (res[c]) {
                    return (char) (c + 'a');
                }
                res[c] = true;
            }
            return ' ';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}