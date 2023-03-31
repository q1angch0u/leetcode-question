  //Given the head of a linked list, reverse the nodes of the list k at a time, 
//and return the modified list. 
//
// k is a positive integer and is less than or equal to the length of the 
//linked list. If the number of nodes is not a multiple of k then left-out nodes, in 
//the end, should remain as it is. 
//
// You may not alter the values in the list's nodes, only nodes themselves may 
//be changed. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]
// 
//
// Example 2: 
// 
// 
//Input: head = [1,2,3,4,5], k = 3
//Output: [3,2,1,4,5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
// Follow-up: Can you solve the problem in O(1) extra memory space? 
//
// Related Topics Linked List Recursion 👍 9650 👎 551

  
package com.q1angch0u.leetcode.editor.en;
public class ReverseNodesInKGroup{
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            ListNode dummyHead = new ListNode();
            dummyHead.next = head;
            ListNode cur = dummyHead;
            while (cur != null) {
                ListNode node = cur;
                for (int i = 0; i < k && node != null; i++) {
                    node = node.next;
                }
                if (node == null) {
                    break;
                }
                ListNode prev = null, next = null;
                node = cur.next;
                for (int i = 0; i < k; i++) {
                    next = node.next;
                    node.next = prev;
                    prev = node;
                    node = next;
                }
                ListNode tail = cur.next;
                tail.next = node;
                cur.next = prev;
                cur = tail;
            }
            return dummyHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}