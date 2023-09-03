//A valid IP address consists of exactly four integers separated by single dots.
// Each integer is between 0 and 255 (inclusive) and cannot have leading zeros. 
//
// 
// For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011
//.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses. 
// 
//
// Given a string s containing only digits, return all possible valid IP 
//addresses that can be formed by inserting dots into s. You are not allowed to reorder 
//or remove any digits in s. You may return the valid IP addresses in any order. 
//
// 
// Example 1: 
//
// 
//Input: s = "25525511135"
//Output: ["255.255.11.135","255.255.111.35"]
// 
//
// Example 2: 
//
// 
//Input: s = "0000"
//Output: ["0.0.0.0"]
// 
//
// Example 3: 
//
// 
//Input: s = "101023"
//Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 20 
// s consists of digits only. 
// 
//
// Related Topics 字符串 回溯 👍 1296 👎 0

package com.q1angch0u.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public static void main(String[] args) {
    Solution solution = new RestoreIPAddresses(). new Solution();
  }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            char[] ss = s.toCharArray();
            int n = ss.length;
            if (n < 4 || n > 12) {
                return res;
            }
            dfs(res, ss, n, 0, new ArrayList<>(), 0);
            return res;
        }

        private void dfs(List<String> res, char[] ss, int length, int split, List<String> path, int begin) {
            if (begin == length) {
                if (split == 4) {
                    res.add(String.join(".", path));
                }
                return;
            }
            for (int i = 0; i < 3; i++) {
                if (begin + i >= length) {
                    break;
                }
                int ipSegment = validateSegment(ss, begin, begin + i + 1);
                if (ipSegment == -1) {
                    continue;
                }
                path.add(String.valueOf(ipSegment));
                dfs(res, ss, length, split + 1, path, begin + i + 1);
                path.remove(path.size() - 1);
            }
        }

        private int validateSegment(char[] ss, int begin, int end) {
            if (end - begin > 1 && ss[begin] == '0') {
                return -1;
            }
            int sum = 0;
            for (int i = begin; i < end; i++) {
                sum = sum * 10 + ss[i] - '0';
            }
            return sum > 255 ? -1 : sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

  }