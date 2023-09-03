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
// Related Topics 数组 回溯 👍 1820 👎 0

package com.q1angch0u.leetcode.editor.cn;

import java.util.*;

public class NQueens {
  public static void main(String[] args) {
    Solution solution = new NQueens(). new Solution();
  }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        int[] queen = new int[n];
        Arrays.fill(queen, -1);
        dfs(res, set, set2, set3, queen, n, 0);
        return res;
    }

    private void dfs(List<List<String>> res, Set<Integer> set, Set<Integer> set2,
                     Set<Integer> set3, int[] queen, int n, int row) {
        if (n == row) {
            res.add(generateBoard(n, queen));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (set.contains(i)) {
                continue;
            }
            int s1 = row + i;
            if (set2.contains(s1)) {
                continue;
            }
            int s2 = row - i;
            if (set3.contains(s2)) {
                continue;
            }
            set.add(i);
            set2.add(s1);
            set3.add(s2);
            queen[row] = i;
            dfs(res, set, set2, set3, queen, n, row + 1);
            queen[row] = -1;
            set3.remove(s2);
            set2.remove(s1);
            set.remove(i);
        }
    }

    private List<String> generateBoard(int n, int[] queen) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] t = new char[n];
            Arrays.fill(t, '.');
            t[queen[i]] = 'Q';
            res.add(new String(t));
        }
        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

  }