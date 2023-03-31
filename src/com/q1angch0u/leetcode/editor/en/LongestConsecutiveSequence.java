  //Given an unsorted array of integers nums, return the length of the longest 
//consecutive elements sequence. 
//
// You must write an algorithm that runs in O(n) time. 
//
// 
// Example 1: 
//
// 
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. 
//Therefore its length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics Array Hash Table Union Find 👍 13861 👎 571

  
package com.q1angch0u.leetcode.editor.en;

  import java.util.HashMap;
  import java.util.Map;

  public class LongestConsecutiveSequence{
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                if (map.containsKey(nums[i])) {
                    continue;
                }
                if (map.containsKey(nums[i] + 1)) {
                    uf.union(i, map.get(nums[i] + 1));
                }
                if (map.containsKey(nums[i] - 1)) {
                    uf.union(i, map.get(nums[i] - 1));
                }
                map.put(nums[i], i);
            }

            return uf.getMaxConnectedSize();
        }

        class UnionFind {
            int []parent;
            int []weight;
            int group;

            public UnionFind(int size) {
                this.parent = new int[size];
                this.weight = new int[size];
                this.group = size;
                for (int i = 0; i < size; i++) {
                    this.parent[i] = i;
                    this.weight[i] = 1;
                }
            }

            public int getMaxConnectedSize() {
                int maxSize = 0;
                for (int i = 0; i < this.parent.length; i++) {
                    if (this.parent[i] == i) {
                        maxSize = Math.max(maxSize, this.weight[i]);
                    }
                }
                return maxSize;
            }

            public void union(int firstElement, int secondElement) {
                int firstRoot = this.find(firstElement);
                int secondRoot = this.find(secondElement);
                if (firstRoot == secondRoot) {
                    return;
                }
                if (this.weight[firstRoot] > this.weight[secondRoot]) {
                    this.parent[secondRoot] = firstRoot;
                    this.weight[firstRoot] += this.weight[secondRoot];
                } else {
                    this.parent[firstRoot] = secondRoot;
                    this.weight[secondRoot] += this.weight[firstRoot];
                }
                this.group--;
            }

            private int find(int element) {
                if (this.parent[element] != element) {
                    this.parent[element] = this.find(this.parent[element]);
                }
                return this.parent[element];
            }


        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}