//Given an integer numRows, return the first numRows of Pascal's triangle. 
//
// In Pascal's triangle, each number is the sum of the two numbers directly 
//above it as shown: 
// 
// 
// Example 1: 
// Input: numRows = 5
//Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
// Example 2: 
// Input: numRows = 1
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= numRows <= 30 
// 
//
// Related Topics Array Dynamic Programming 👍 7155 👎 233


package com.q1angch0u.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle{
public static void main(String[] args) {
   Solution solution = new PascalsTriangle().new Solution();
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
//        int[][] res = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            List<Integer> tRes = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    tRes.add(1);
                    continue;
                }
                tRes.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            res.add(tRes);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}