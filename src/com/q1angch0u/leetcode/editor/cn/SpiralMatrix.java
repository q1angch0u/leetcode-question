//Given an m x n matrix, return all elements of the matrix in spiral order. 
//
// 
// Example 1: 
// 
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
// 
// 
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1477 👎 0

package com.q1angch0u.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
    Solution solution = new SpiralMatrix(). new Solution();
  }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            int m = matrix.length;
            if (m == 0) {
                return res;
            }
            int n = matrix[0].length;
            if (n == 0) {
                return res;
            }

            int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int directionIdx = 0;

            boolean[][] visited = new boolean[m][n];
            int total = m * n;
            int rowIdx = 0, colIdx = 0;
            for (int i = 0; i < total; i++) {
                res.add(matrix[rowIdx][colIdx]);
                visited[rowIdx][colIdx] = true;
                int nextRowIdx = rowIdx + directions[directionIdx][0];
                int nextColIdx = colIdx + directions[directionIdx][1];
                if (nextRowIdx < 0
                        || nextRowIdx >= m
                        || nextColIdx < 0
                        || nextColIdx >= n
                        || visited[nextRowIdx][nextColIdx]) {
                    directionIdx = (directionIdx + 1) % 4;
                }
                rowIdx += directions[directionIdx][0];
                colIdx += directions[directionIdx][1];
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

  }