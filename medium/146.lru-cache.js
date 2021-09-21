/*
 * @lc app=leetcode id=146 lang=javascript
 *
 * [146] LRU Cache
 */

// @lc code=start

class ListNode {
  constructor(key, val) {
    this.key = key;
    this.val = val;
    this.next = null;
    this.prev = null;
  }
}

class LRUCache {
  constructor(capacity) {
    this.head = new ListNode(-1, -1);
    this.tail = new ListNode(-1, -1);
    this.head.next = this.tail;
    this.tail.prev = this.head;

    this.cap = capacity;
    this.data = {};
  }

  get(key) {
    if (!(key in this.data)) {
      return -1;
    }
  
    // move list node to head
    let node = this.data[key];
    this.unlink(node);
    this.moveToHead(node);
  
    return node.val;
  };

  put(key, value) {
    if (key in this.data) {
      // update
      let node = this.data[key];
      node.val = value;
      this.unlink(node);
      this.moveToHead(node);
    } else {
      let node = new ListNode(key, value);
      if (this.cap > 0) {
        this.cap--;
      } else {
        delete this.data[this.tail.prev.key];
        this.unlink(this.tail.prev);
      }
  
      this.data[key] = node;
      this.moveToHead(node);
    }
  }

  unlink(node) {
    let prev = node.prev;
    let next = node.next;
    prev.next = next;
    next.prev = prev;
  }
  
  moveToHead(node) {
    let first = this.head.next;
    this.head.next = node;
    node.prev = this.head;
  
    node.next = first;
    first.prev = node;
  }
};

/** 
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
// @lc code=end

