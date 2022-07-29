//You are given the strings key and message, which represent a cipher key and a 
//secret message, respectively. The steps to decode message are as follows: 
//
// 
// Use the first appearance of all 26 lowercase English letters in key as the 
//order of the substitution table. 
// Align the substitution table with the regular English alphabet. 
// Each letter in message is then substituted using the table. 
// Spaces ' ' are transformed to themselves. 
// 
//
// 
// For example, given key = "happy boy" (actual key would have at least one 
//instance of each letter in the alphabet), we have the partial substitution table of 
//('h' -> 'a', 'a' -> 'b', 'p' -> 'c', 'y' -> 'd', 'b' -> 'e', 'o' -> 'f'). 
// 
//
// Return the decoded message. 
//
// 
// Example 1: 
// 
// 
//Input: key = "the quick brown fox jumps over the lazy dog", message = "vkbs 
//bs t suepuv"
//Output: "this is a secret"
//Explanation: The diagram above shows the substitution table.
//It is obtained by taking the first appearance of each letter in "the quick 
//brown fox jumps over the lazy dog".
// 
//
// Example 2: 
// 
// 
//Input: key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius 
//ycgk vcnjrdb"
//Output: "the five boxing wizards jump quickly"
//Explanation: The diagram above shows the substitution table.
//It is obtained by taking the first appearance of each letter in 
//"eljuxhpwnyrdgtqkviszcfmabo".
// 
//
// 
// Constraints: 
//
// 
// 26 <= key.length <= 2000 
// key consists of lowercase English letters and ' '. 
// key contains every letter in the English alphabet ('a' to 'z') at least once.
// 
// 1 <= message.length <= 2000 
// message consists of lowercase English letters and ' '. 
// 
//
// Related Topics Hash Table String 👍 206 👎 29


package com.q1angch0u.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class DecodeTheMessage{
    public static void main(String[] args) {
       Solution solution = new DecodeTheMessage().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> decoder = new HashMap<>();
        char[] kk = key.toCharArray();
        char[] mm = message.toCharArray();
        for (int i = 0, j = 'a'; i < kk.length && j <= 'z'; i++) {
            char c = kk[i];
            if (c == ' ' || decoder.containsKey(c)) {
                continue;
            }
            decoder.put(c, (char) j);
            j++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mm.length; i++) {
            char c = mm[i];
            sb.append(decoder.getOrDefault(c, c));
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}