//You are given an array of integers stones where stones[i] is the weight of 
//the iᵗʰ stone. 
//
// We are playing a game with the stones. On each turn, we choose the heaviest 
//two stones and smash them together. Suppose the heaviest two stones have weights 
//x and y with x <= y. The result of this smash is: 
//
// 
// If x == y, both stones are destroyed, and 
// If x != y, the stone of weight x is destroyed, and the stone of weight y has 
//new weight y - x. 
// 
//
// At the end of the game, there is at most one stone left. 
//
// Return the weight of the last remaining stone. If there are no stones left, 
//return 0. 
//
// 
// Example 1: 
//
// 
//Input: stones = [2,7,4,1,8,1]
//Output: 1
//Explanation: 
//We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
//we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
//we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
//we combine 1 and 1 to get 0 so the array converts to [1] then that's the 
//value of the last stone.
// 
//
// Example 2: 
//
// 
//Input: stones = [1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= stones.length <= 30 
// 1 <= stones[i] <= 1000 
// 
//
// Related Topics Array Heap (Priority Queue) 👍 4946 👎 83

package com.q1angch0u.leetcode.editor.en;

import java.util.PriorityQueue;

public class LastStoneWeight {
  public static void main(String[] args) {
    Solution solution = new LastStoneWeight(). new Solution();
  }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone: stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }