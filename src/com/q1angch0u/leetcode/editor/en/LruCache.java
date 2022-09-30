//Design a data structure that follows the constraints of a Least Recently Used 
//(LRU) cache. 
//
// Implement the LRUCache class: 
//
// 
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity. 
//
// int get(int key) Return the value of the key if the key exists, otherwise 
//return -1. 
// void put(int key, int value) Update the value of the key if the key exists. 
//Otherwise, add the key-value pair to the cache. If the number of keys exceeds 
//the capacity from this operation, evict the least recently used key. 
// 
//
// The functions get and put must each run in O(1) average time complexity. 
//
// 
// Example 1: 
//
// 
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10⁴ 
// 0 <= value <= 10⁵ 
// At most 2 * 10⁵ calls will be made to get and put. 
// 
//
// Related Topics Hash Table Linked List Design Doubly-Linked List 👍 15307 👎 6
//39


package com.q1angch0u.leetcode.editor.en;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LruCache{
    public static void main(String[] args) {
       LRUCache solution = new LruCache().new LRUCache(0);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        Map<Integer, DLinkedNode> cache = new HashMap<>();
        int size, capacity;
        DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            this.head = new DLinkedNode();
            this.tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            DLinkedNode node = cache.get(key);
            this.moveToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                DLinkedNode node = cache.get(key);
                node.val = value;
                moveToHead(node);
                return;
            }
            DLinkedNode node = new DLinkedNode(key, value);
            cache.put(key, node);
            this.addToHead(node);
            this.size++;
            if (this.size > this.capacity) {
                DLinkedNode tail = this.tail.prev;
                this.removeNode(tail);
                cache.remove(tail.key);
                size--;
            }
        }

        private void addToHead(DLinkedNode node) {
            node.prev = this.head;
            node.next = this.head.next;
            this.head.next.prev = node;
            this.head.next = node;
        }

        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }


    }

    class DLinkedNode {
        int key;
        int val;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {
        }
        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}