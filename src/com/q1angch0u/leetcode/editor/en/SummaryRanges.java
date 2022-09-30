//You are given a sorted unique integer array nums. 
//
// A range [a,b] is the set of all integers from a to b (inclusive). 
//
// Return the smallest sorted list of ranges that cover all the numbers in the 
//array exactly. That is, each element of nums is covered by exactly one of the 
//ranges, and there is no integer x such that x is in one of the ranges but not in 
//nums. 
//
// Each range [a,b] in the list should be output as: 
//
// 
// "a->b" if a != b 
// "a" if a == b 
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [0,1,2,4,5,7]
//Output: ["0->2","4->5","7"]
//Explanation: The ranges are:
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// Example 2: 
//
// 
//Input: nums = [0,2,3,4,6,8,9]
//Output: ["0","2->4","6","8->9"]
//Explanation: The ranges are:
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 20 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// All the values of nums are unique. 
// nums is sorted in ascending order. 
// 
//
// Related Topics Array 👍 2171 👎 1219


package com.q1angch0u.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges{
    public static void main(String[] args) {
       Solution solution = new SummaryRanges().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        int length = nums.length;
        List<String> res = new ArrayList<>();
        if (length == 0) {
            return res;
        }
        int head = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] != nums[i-1] + 1) {
                StringBuffer sb = new StringBuffer();
                res.add(generateOutput(head, nums[i-1]));
                head = nums[i];
            }
        }
        res.add(generateOutput(head, nums[length-1]));
        return res;
    }

    private String generateOutput(int i, int j) {
        StringBuffer sb = new StringBuffer();
        if (i == j) {
            sb.append(i);
            return sb.toString();
        }
        sb.append(i);
        sb.append("->");
        sb.append(j);
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}