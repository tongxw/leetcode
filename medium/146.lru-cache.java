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
    private HashMap<Integer, ListNode> map; // { node->key : node }

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

            // printList("get " + key);
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

            // this is the most recent one
            moveToHead(node);
            // printList("update " + key);
        } else {
            // create a new one
            node = new ListNode(key, value);

            map.put(key, node);
            addHeadNode(node);
            size++;

            // printList("put " + key);

            if (size > cap) {
                if (tail.prev != null) {
                    // remove the least used one at tail
                    int removeKey = tail.prev.key;
                    unlinkNode(tail.prev);

                    // printList("remove cap " + removeKey);

                    // remove from map
                    map.remove(removeKey);
                }

                size--;
            }
        }
    }

    private void moveToHead(ListNode node) {
        unlinkNode(node);
        addHeadNode(node);
    }

    private void unlinkNode(ListNode node) {
        if (node == null) {
            return;
        }

        // { prev <-> node <-> next } => { prev <-> next }
        ListNode prevNode = node.prev;
        ListNode nextNode = node.next;
        if (prevNode != null) {
            prevNode.next = nextNode;
        }
        if (nextNode != null) {
            nextNode.prev = prevNode;
        }

        node.prev = null;
        node.next = null;
    }

    private void addHeadNode(ListNode node) {
        if (node == null) {
            return;
        }
        // { head <-> headNext } => { head <-> node <-> headNext }
        ListNode headNext = head.next;
        head.next = node;
        node.prev = head;
        if (headNext != null) {
            headNext.prev = node;
            node.next = headNext;
        }
    }

    private void printList(String note) {
        ListNode node = head;
        StringBuffer out = new StringBuffer(note);
        while (node != null) {
            out.append(node.key);
            out.append(" -> ");
            node = node.next;
        }
        System.out.println(out.toString());
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

