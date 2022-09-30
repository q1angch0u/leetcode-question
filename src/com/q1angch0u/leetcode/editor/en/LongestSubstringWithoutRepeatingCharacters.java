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
// Related Topics Hash Table String Sliding Window 👍 28832 👎 1229


package com.q1angch0u.leetcode.editor.en;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
       Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
       int r = solution.lengthOfLongestSubstring(" ");
        System.out.println(r);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int i = 0, j = 0, ans = 0, n = s.length();
            while(j < n) {
                if(!map.containsKey(s.charAt(j))){
                    map.put(s.charAt(j), j);
                    j++;
                } else {
                    map.remove(s.charAt(i));
                    i++;
                }
                ans = Math.max(ans, j - i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}