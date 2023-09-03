//Design and implement a data structure for a Least Frequently Used (LFU) cache.
// 
//
// Implement the LFUCache class: 
//
// 
// LFUCache(int capacity) Initializes the object with the capacity of the data 
//structure. 
// int get(int key) Gets the value of the key if the key exists in the cache. 
//Otherwise, returns -1. 
// void put(int key, int value) Update the value of the key if present, or 
//inserts the key if not already present. When the cache reaches its capacity, it 
//should invalidate and remove the least frequently used key before inserting a new 
//item. For this problem, when there is a tie (i.e., two or more keys with the same 
//frequency), the least recently used key would be invalidated. 
// 
//
// To determine the least frequently used key, a use counter is maintained for 
//each key in the cache. The key with the smallest use counter is the least 
//frequently used key. 
//
// When a key is first inserted into the cache, its use counter is set to 1 (
//due to the put operation). The use counter for a key in the cache is incremented 
//either a get or put operation is called on it. 
//
// The functions get and put must each run in O(1) average time complexity. 
//
// 
// Example 1: 
//
// 
//Input
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", 
//"get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//Explanation
//// cnt(x) = the use counter for key x
//// cache=[] will show the last used order for tiebreakers (leftmost element 
//is  most recent)
//LFUCache lfu = new LFUCache(2);
//lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
//lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//lfu.get(1);      // return 1
//                 // cache=[1,2], cnt(2)=1, cnt(1)=2
//lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, 
//invalidate 2.
//                 // cache=[3,1], cnt(3)=1, cnt(1)=2
//lfu.get(2);      // return -1 (not found)
//lfu.get(3);      // return 3
//                 // cache=[3,1], cnt(3)=2, cnt(1)=2
//lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1
//.
//                 // cache=[4,3], cnt(4)=1, cnt(3)=2
//lfu.get(1);      // return -1 (not found)
//lfu.get(3);      // return 3
//                 // cache=[3,4], cnt(4)=1, cnt(3)=3
//lfu.get(4);      // return 4
//                 // cache=[4,3], cnt(4)=2, cnt(3)=3
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 10⁴ 
// 0 <= key <= 10⁵ 
// 0 <= value <= 10⁹ 
// At most 2 * 10⁵ calls will be made to get and put. 
// 
//
// 
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 672 👎 0

package com.q1angch0u.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LFUCache {
  public static void main(String[] args) {
    Solution solution = new LFUCache(). new Solution();
  }
//leetcode submit region begin(Prohibit modification and deletion)
//class LFUCache {
//
//
//    int capacity;
//    int size;
//
//    Queue<Node> queue;
//    Map<Integer, Node> cache;
//    int index;
//
//    public LFUCache(int capacity) {
//        this.capacity = capacity;
//        this.queue = new PriorityQueue<>(capacity, (o1, o2) -> {
//            int freq = o1.freq - o2.freq;
//            return freq != 0 ? freq : o1.index - o2.index;
//        });
//        this.cache = new HashMap<>();
//    }
//
//    public int get(int key) {
//        if (cache.containsKey(key)) {
//            Node node = cache.get(key);
//            node.freq++;
//            node.index = index++;
//            queue.remove(node);
//            queue.offer(node);
//            return node.value;
//        }
//        return -1;
//    }
//
//    public void put(int key, int value) {
//        if (cache.containsKey(key)) {
//            Node node = cache.get(key);
//            node.value = value;
//            node.freq++;
//            node.index = index++;
//            queue.remove(node);
//            queue.offer(node);
//            return;
//        }
//        Node node = new Node(key, value, index++);
//        size++;
//        if (size > capacity) {
//            Node tail = queue.poll();
//            cache.remove(tail.key);
//            size--;
//        }
//        queue.offer(node);
//        cache.put(key, node);
//    }
//
//    private static class Node {
//        int key;
//        int value;
//        int freq;
//        int index;
//
//        public Node(int key, int value, int index) {
//            this.key = key;
//            this.value = value;
//            this.index = index;
//        }
//    }
//
//}

    /**
     * Your LFUCacheOuter object will be instantiated and called as such:
     * LFUCacheOuter obj = new LFUCacheOuter(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    //leetcode submit region end(Prohibit modification and deletion)

  }