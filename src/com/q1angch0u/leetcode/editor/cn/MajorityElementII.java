//Given an integer array of size n, find all elements that appear more than ⌊ n/
//3 ⌋ times. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,2,3]
//Output: [3]
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: [1]
// 
//
// Example 3: 
//
// 
//Input: nums = [1,2]
//Output: [1,2]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
// Follow up: Could you solve the problem in linear time and in O(1) space? 
//
// Related Topics 数组 哈希表 计数 排序 👍 687 👎 0

package com.q1angch0u.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
  public static void main(String[] args) {
    Solution solution = new MajorityElementII(). new Solution();
  }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int candidate1 = nums[0], count1 = 0;
        int candidate2 = nums[0], count2 = 0;

        for (int num : nums) {
            if (candidate1 == num) {
                count1++;
                continue;
            }
            if (candidate2 == num) {
                count2++;
                continue;
            }

            if (count1 == 0) {
                candidate1 = num;
                count1++;
                continue;
            }
            if (count2 == 0) {
                candidate2 = num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (candidate1 == num) {
                count1++;
            } else if (candidate2 == num) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            res.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            res.add(candidate2);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }