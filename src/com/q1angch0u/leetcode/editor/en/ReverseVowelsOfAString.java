//Given a string s, reverse only all the vowels in the string and return it. 
//
// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both 
//cases. 
//
// 
// Example 1: 
// Input: s = "hello"
//Output: "holle"
// 
// Example 2: 
// Input: s = "leetcode"
//Output: "leotcede"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s consist of printable ASCII characters. 
// 
//
// Related Topics Two Pointers String 👍 1754 👎 1935


package com.q1angch0u.leetcode.editor.en;
public class ReverseVowelsOfAString{
    public static void main(String[] args) {
       Solution solution = new ReverseVowelsOfAString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    String v = "aeiouAEIOU";

    public String reverseVowels(String s) {
        char[] ss = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!isVowel(ss[i])) {
                i++;
            }
            if (!isVowel(ss[j])) {
                j--;
            }
            if (isVowel(ss[i]) && isVowel(ss[j])) {
                char t = ss[i];
                ss[i] = ss[j];
                ss[j] = t;
                i++;
                j--;
            }
        }
        return String.valueOf(ss);
    }
    private boolean isVowel(char c) {
        return v.contains(String.valueOf(c));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}