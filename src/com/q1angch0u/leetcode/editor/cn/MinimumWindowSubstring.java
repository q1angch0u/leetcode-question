//Given two strings s and t of lengths m and n respectively, return the minimum 
//window substring of s such that every character in t (including duplicates) is 
//included in the window. If there is no such substring, return the empty string 
//"". 
//
// The testcases will be generated such that the answer is unique. 
//
// 
// Example 1: 
//
// 
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' 
//from string t.
// 
//
// Example 2: 
//
// 
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
// 
//
// Example 3: 
//
// 
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
// 
//
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
// Follow up: Could you find an algorithm that runs in O(m + n) time? 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2637 👎 0

package com.q1angch0u.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring(). new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();
            int m = ss.length;
            int n = tt.length;
            if (m < n || m == 0 || n == 0) {
                return "";
            }
            Map<Character, Integer> cache = new HashMap<>();
            int left = 0, right = 0;
            int min = Integer.MAX_VALUE, begin = -1;
            for (char c : tt) {
                cache.put(c, cache.getOrDefault(c, 0) + 1);
            }
            int diff = cache.size();
            while (right < m) {
                char c = ss[right++];
                cache.put(c, cache.getOrDefault(c, 0) - 1);
                if (cache.get(c) == 0) {
                    diff--;
                }
                while (diff == 0) {
                    if (right - left < min) {
                        min = right - left;
                        begin = left;
                    }
                    c = ss[left++];
                    cache.put(c, cache.getOrDefault(c, 0) + 1);
                    if (cache.get(c) > 0) {
                        diff++;
                    }
                }
            }
            return min == Integer.MAX_VALUE ? "" : s.substring(begin, begin + min);

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

  }