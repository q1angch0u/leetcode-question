  //Given a string s, find the length of the longest substring without repeating 
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 30340 👎 1297

  
package com.q1angch0u.leetcode.editor.en;

  import java.util.HashMap;
  import java.util.Map;

  public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] ss = s.toCharArray();
            int n = ss.length;
            if (n < 2) {
                return n;
            }
            Map<Character, Integer> map = new HashMap<>();
            int i = 0, j = 0, max = 0;
            while (i < n) {
                if (map.containsKey(ss[i])) {
                    map.remove(ss[j++]);
                } else {
                    map.put(ss[i], i);
                    i++;
                }
                max = Math.max(map.size(), max);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}