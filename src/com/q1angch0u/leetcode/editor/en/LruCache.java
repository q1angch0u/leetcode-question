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
// Related Topics Hash Table Linked List Design Doubly-Linked List 👍 15852 👎 6
//77

  
package com.q1angch0u.leetcode.editor.en;

  import java.util.HashMap;
  import java.util.Map;

  public class LruCache{
    public static void main(String[] args) {
        LRUCache solution = new LruCache().new LRUCache(0);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        Map<Integer, DLinkedNode> cache = new HashMap<>();
        int capacity;
        int size;
        DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.head = new DLinkedNode();
            this.tail = new DLinkedNode();
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        public int get(int key) {
            if (!this.cache.containsKey(key)) {
                return -1;
            }
            DLinkedNode node = this.cache.get(key);
            this.move2Head(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (this.cache.containsKey(key)) {
                DLinkedNode node = this.cache.get(key);
                node.val = value;
                move2Head(node);
                return;
            }
            DLinkedNode node = new DLinkedNode(key, value);
            this.add2Head(node);
            cache.put(key, node);
            size++;
            if (size > capacity) {
                DLinkedNode tail = this.tail.prev;
                removeNode(tail);
                cache.remove(tail.key);
                size--;
            }
        }

        private void add2Head(DLinkedNode node) {
            node.next = this.head.next;
            node.prev = this.head;
            this.head.next.prev = node;
            this.head.next = node;
        }

        private void removeNode(DLinkedNode node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        private void move2Head(DLinkedNode node) {
            this.removeNode(node);
            this.add2Head(node);
        }

        class DLinkedNode {
            int key;
            int val;
            DLinkedNode prev;
            DLinkedNode next;

            public DLinkedNode() {}
            public DLinkedNode(int k, int v) {
                this.key = k;
                this.val = v;
            }
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