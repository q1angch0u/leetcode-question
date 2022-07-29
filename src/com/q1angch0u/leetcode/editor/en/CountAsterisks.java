//You are given a string s, where every two consecutive vertical bars '|' are 
//grouped into a pair. In other words, the 1ˢᵗ and 2ⁿᵈ '|' make a pair, the 3ʳᵈ and 
//4ᵗʰ '|' make a pair, and so forth. 
//
// Return the number of '*' in s, excluding the '*' between each pair of '|'. 
//
// Note that each '|' will belong to exactly one pair. 
//
// 
// Example 1: 
//
// 
//Input: s = "l|*e*et|c**o|*de|"
//Output: 2
//Explanation: The considered characters are underlined: "l|*e*et|c**o|*de|".
//The characters between the first and second '|' are excluded from the answer.
//Also, the characters between the third and fourth '|' are excluded from the 
//answer.
//There are 2 asterisks considered. Therefore, we return 2. 
//
// Example 2: 
//
// 
//Input: s = "iamprogrammer"
//Output: 0
//Explanation: In this example, there are no asterisks in s. Therefore, we 
//return 0.
// 
//
// Example 3: 
//
// 
//Input: s = "yo|uar|e**|b|e***au|tifu|l"
//Output: 5
//Explanation: The considered characters are underlined: "yo|uar|e**|b|e***au|
//tifu|l". There are 5 asterisks considered. Therefore, we return 5. 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of lowercase English letters, vertical bars '|', and asterisks '*
//'. 
// s contains an even number of vertical bars '|'. 
// 
//
// Related Topics String 👍 183 👎 26


package com.q1angch0u.leetcode.editor.en;
public class CountAsterisks{
    public static void main(String[] args) {
       Solution solution = new CountAsterisks().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countAsterisks(String s) {
        char[] ss = s.toCharArray();
        int res = 0;
        boolean flag = false;
        for (char c: ss) {
            if (c == '|') {
                flag = !flag;
                continue;
            }
            if (c == '*' && !flag) {
                res++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}