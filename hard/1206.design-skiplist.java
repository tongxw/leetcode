/*
 * @lc app=leetcode id=1206 lang=java
 *
 * [1206] Design Skiplist
 */

// @lc code=start
class Skiplist {

    // https://www.jianshu.com/p/9d8296562806
    // https://leetcode-cn.com/problems/design-skiplist/solution/javashou-xie-shi-xian-tiao-biao-by-feng-omdm0/
    private int MAX_LEVEL = 30;
    private Node head;
    private int curMaxLevel = 1;

    public Skiplist() {
        head = new Node(-1, MAX_LEVEL);
        curMaxLevel = 1;
    }
    
    public boolean search(int target) {
        Node node = head;
        for (int i=curMaxLevel-1; i>=0; i--) {
            while (node.next[i] != null && node.next[i].value < target) {
                node = node.next[i];
            }

            if (node.next[i] != null && node.next[i].value == target) {
                return true;
            }
        }

        return false;
    }
    
    public void add(int num) {
        int level = randomLevel();
        Node newNode = new Node(num, level);

        Node node = head;
        for (int i=curMaxLevel-1; i>=0; i--) {
            while (node.next[i] != null && node.next[i].value < num) {
                node = node.next[i];
            }

            if (i < level) {
                Node nextNode = node.next[i];
                node.next[i] = newNode;
                newNode.next[i] = nextNode;
            }
        }

        if (level > curMaxLevel) {
            for (int i=curMaxLevel; i<level; i++) {
                head.next[i] = newNode;
            }

            curMaxLevel = level;
        }
    }
    
    public boolean erase(int num) {
        boolean found = false;
        Node node = head;
        for (int i=curMaxLevel-1; i>=0; i--) {
            while (node.next[i] != null && node.next[i].value < num) {
                node = node.next[i];
            }

            if (node.next[i] != null && node.next[i].value == num) {
                node.next[i] = node.next[i].next[i];
                found = true;
            }
        }

        return found;

        
    }

    private int randomLevel() {
        double DEFAULT_P_FACTOR = 0.25;
        int level = 1;
        while(Math.random() < DEFAULT_P_FACTOR && level < MAX_LEVEL) {
            level++;
        }

        return level;
    }

    class Node {
        int value;
        Node[] next;

        public Node(int value, int size) {
            this.value = value;
            this.next = new Node[size];
        }
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
// @lc code=end

