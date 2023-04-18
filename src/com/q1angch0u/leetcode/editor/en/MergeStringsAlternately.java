//You are given two strings word1 and word2. Merge the strings by adding 
//letters in alternating order, starting with word1. If a string is longer than the 
//other, append the additional letters onto the end of the merged string. 
//
// Return the merged string. 
//
// 
// Example 1: 
//
// 
//Input: word1 = "abc", word2 = "pqr"
//Output: "apbqcr"
//Explanation: The merged string will be merged as so:
//word1:  a   b   c
//word2:    p   q   r
//merged: a p b q c r
// 
//
// Example 2: 
//
// 
//Input: word1 = "ab", word2 = "pqrs"
//Output: "apbqrs"
//Explanation: Notice that as word2 is longer, "rs" is appended to the end.
//word1:  a   b 
//word2:    p   q   r   s
//merged: a p b q   r   s
// 
//
// Example 3: 
//
// 
//Input: word1 = "abcd", word2 = "pq"
//Output: "apbqcd"
//Explanation: Notice that as word1 is longer, "cd" is appended to the end.
//word1:  a   b   c   d
//word2:    p   q 
//merged: a p b q c   d
// 
//
// 
// Constraints: 
//
// 
// 1 <= word1.length, word2.length <= 100 
// word1 and word2 consist of lowercase English letters. 
// 
//
// Related Topics Two Pointers String 👍 1593 👎 27

package com.q1angch0u.leetcode.editor.en;
public class MergeStringsAlternately {
  public static void main(String[] args) {
    Solution solution = new MergeStringsAlternately(). new Solution();
  }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuffer sb = new StringBuffer();
        char[] ss1 = word1.toCharArray();
        char[] ss2 = word2.toCharArray();
        int m = ss1.length, n = ss2.length;
        int i = 0, j = 0;
        while (i < m || j < n) {
            if (i < m) {
                sb.append(ss1[i]);
            }
            if (j < n) {
                sb.append(ss2[j]);
            }
            i++;
            j++;
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }