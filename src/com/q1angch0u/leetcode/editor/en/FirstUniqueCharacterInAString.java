//Given a string s, find the first non-repeating character in it and return its 
//index. If it does not exist, return -1. 
//
// 
// Example 1: 
// Input: s = "leetcode"
//Output: 0
// 
// Example 2: 
// Input: s = "loveleetcode"
//Output: 2
// 
// Example 3: 
// Input: s = "aabb"
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of only lowercase English letters. 
// 
//
// Related Topics Hash Table String Queue Counting 👍 5451 👎 211


package com.q1angch0u.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString{
    public static void main(String[] args) {
       Solution solution = new FirstUniqueCharacterInAString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        char[] ss = s.toCharArray();
        int length = ss.length;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            char c = ss[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < length; i++) {
            char c = ss[i];
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}