import java.util.HashMap;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {

    private class ListNode {
        ListNode prev = null;
        ListNode next = null;
        int key;
        int val;
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    private int cap = 0;
    private int size = 0;
    private ListNode head; // recent used: head.next
    private ListNode tail; // least used: tail.prev
    private HashMap<Integer, ListNode> map; // put the value in the list node

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<Integer, ListNode>();
        head = new ListNode(-1, 0);
        tail = new ListNode(-1, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            moveToHead(node);

            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        ListNode node = null;
        if (map.containsKey(key)) {
            // update
            node = map.get(key);
            node.val = value;

            // put this node to head
            moveToHead(node);
        } else {
            // create new one
            node = new ListNode(key, value);
            map.put(key, node);
            size++;
            addNodeAfterHead(node);

            if (size > cap) {
                // remove the least used one at tail
                removeNode(tail.prev);
                size--;
            }
        }
    }

    private void moveToHead(ListNode node) {
        removeNode(node);
        addNodeAfterHead(node);
    }

    private void removeNode(ListNode node) {
        ListNode prevNode = node.prev;
        ListNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void addNodeAfterHead(ListNode node) {
        ListNode afterHead = head.next;
        head.next = node;
        node.prev = head;
        afterHead.prev = node;
        node.next = afterHead;
    }
}

// ["LRUCache","put","get","put","get","get"]\n[[1],[2,1],[2],[3,2],[2],[3]]
// ["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]\n[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

