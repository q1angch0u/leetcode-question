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
// Related Topics 哈希表 字符串 滑动窗口 👍 9432 👎 0

package com.q1angch0u.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) {
    Solution solution = new LongestSubstringWithoutRepeatingCharacters(). new Solution();
  }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            char[] ss = s.toCharArray();
            int n = ss.length, max = 0;
            int i = 0, j = 0;
            while (i < n) {
                if (set.contains(ss[i])) {
                    set.remove(ss[j++]);
                    continue;
                }
                set.add(ss[i]);
                i++;
                max = Math.max(max, i - j);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

  }