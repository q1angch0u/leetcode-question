  //Given an integer array nums, return all the triplets [nums[i], nums[j], nums[
//k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation: 
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not 
//matter.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
// 
//
// Example 3: 
//
// 
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics Array Two Pointers Sorting 👍 24335 👎 2201

  
package com.q1angch0u.leetcode.editor.en;

  import java.sql.Array;
  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.List;

  public class ThreeSum{
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int n = nums.length;
            if (n == 0) {
                return res;
            }
            Arrays.sort(nums);
            for (int i = 0; i < n - 2 && nums[i] <= 0; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int j = i + 1, k = n - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                        while (j < k && nums[j] == nums[++j]) {}
                        while (j < k && nums[k] == nums[--k]) {}
                    } else if (sum < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}