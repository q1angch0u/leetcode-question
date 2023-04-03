//You are given an array people where people[i] is the weight of the iᵗʰ person,
// and an infinite number of boats where each boat can carry a maximum weight of 
//limit. Each boat carries at most two people at the same time, provided the sum 
//of the weight of those people is at most limit. 
//
// Return the minimum number of boats to carry every given person. 
//
// 
// Example 1: 
//
// 
//Input: people = [1,2], limit = 3
//Output: 1
//Explanation: 1 boat (1, 2)
// 
//
// Example 2: 
//
// 
//Input: people = [3,2,2,1], limit = 3
//Output: 3
//Explanation: 3 boats (1, 2), (2) and (3)
// 
//
// Example 3: 
//
// 
//Input: people = [3,5,3,4], limit = 5
//Output: 4
//Explanation: 4 boats (3), (3), (4), (5)
// 
//
// 
// Constraints: 
//
// 
// 1 <= people.length <= 5 * 10⁴ 
// 1 <= people[i] <= limit <= 3 * 10⁴ 
// 
//
// Related Topics Array Two Pointers Greedy Sorting 👍 3830 👎 101

package com.q1angch0u.leetcode.editor.en;

import java.util.Arrays;

public class BoatsToSavePeople{
  public static void main(String[] args) {
    Solution solution = new BoatsToSavePeople().new Solution();
    int res = solution.numRescueBoats(new int[]{5, 1, 4, 2}, 6);
      System.out.println(res);
  }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int i = 0, j = n - 1, res = 0;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            res++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }