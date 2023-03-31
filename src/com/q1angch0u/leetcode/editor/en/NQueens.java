  //The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
//such that no two queens attack each other. 
//
// Given an integer n, return all distinct solutions to the n-queens puzzle. 
//You may return the answer in any order. 
//
// Each solution contains a distinct board configuration of the n-queens' 
//placement, where 'Q' and '.' both indicate a queen and an empty space, respectively. 
//
// 
// Example 1: 
// 
// 
//Input: n = 4
//Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as 
//shown above
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [["Q"]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics Array Backtracking 👍 9488 👎 213

  
package com.q1angch0u.leetcode.editor.en;

  import java.util.*;

  public class NQueens{
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new ArrayList<>();
            int[] queue = new int[n];
            Arrays.fill(queue, -1);
            Set<Integer> columns = new HashSet<>();
            Set<Integer> diagonals1 = new HashSet<>();
            Set<Integer> diagonals2 = new HashSet<>();
            dfs(res, 0, n, queue, columns, diagonals1, diagonals2);
            return res;
        }

        private void dfs(List<List<String>> res, int row, int n, int[] queue,
                    Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
            if (row == n) {
                res.add(buildBoard(n, queue));
                return;
            }
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                if (diagonals1.contains(row + i)) {
                    continue;
                }
                if (diagonals2.contains(row - i)) {
                    continue;
                }
                queue[row] = i;
                columns.add(i);
                diagonals1.add(row + i);
                diagonals2.add(row - i);
                dfs(res, row + 1, n, queue, columns, diagonals1, diagonals2);
                queue[row] = -1;
                columns.remove(i);
                diagonals1.remove(row + i);
                diagonals2.remove(row - i);
            }
        }

        private List<String> buildBoard(int n, int[] queue) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[queue[i]] = 'Q';
                res.add(new String(row));
            }
            return res;
        }



    }
//leetcode submit region end(Prohibit modification and deletion)

}