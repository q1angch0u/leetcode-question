//Given two non-negative integers num1 and num2 represented as strings, return 
//the product of num1 and num2, also represented as a string. 
//
// Note: You must not use any built-in BigInteger library or convert the inputs 
//to integer directly. 
//
// 
// Example 1: 
// Input: num1 = "2", num2 = "3"
//Output: "6"
// 
// Example 2: 
// Input: num1 = "123", num2 = "456"
//Output: "56088"
// 
// 
// Constraints: 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 and num2 consist of digits only. 
// Both num1 and num2 do not contain any leading zero, except the number 0 
//itself. 
// 
//
// Related Topics 数学 字符串 模拟 👍 1247 👎 0

package com.q1angch0u.leetcode.editor.cn;


import java.util.Arrays;

public class MultiplyStrings {
public static void main(String[] args) {
    Solution solution = new MultiplyStrings(). new Solution();
    System.out.println(solution.multiply("123", "45"));
}
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            char[] ss1 = num1.toCharArray();
            char[] ss2 = num2.toCharArray();
            int m = ss1.length;
            int n = ss2.length;
            int[] res = new int[m + n];
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int mul = (ss1[i] - '0') * (ss2[j] - '0');
                    int p1 = i + j, p2 = i + j + 1;
                    int sum = mul + res[p2] + 10 * res[p1];
                    res[p2] = sum % 10;
                    res[p1] = sum / 10;
                }
            }
            StringBuilder sb = new StringBuilder();
            boolean flag = true;
            for (int i = 0; i < res.length; i++) {
                if (res[i] == 0 && flag) {
                    continue;
                }
                flag = false;
                sb.append(res[i]);
            }
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}