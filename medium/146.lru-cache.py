#
# @lc app=leetcode id=146 lang=python3
#
# [146] LRU Cache
#

# @lc code=start
class LRUCache:
    class ListNode:
        next = None
        prev = None
        def __init__(self, key: int, val: int):
            self.key = key
            self.val = val
    cap = 0
    head = ListNode(-1, -1)
    tail = ListNode(-1, -1)
    data = {}

    def __init__(self, capacity: int):
        self.cap = capacity
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key: int) -> int:
        if key not in self.data.keys():
            return -1
        
        node = self.data[key]

        # update pointers
        self.unlink(node)
        
        # add node to head
        self.addToHead(node)

        self.printData('get')
        return node.val

    def put(self, key: int, value: int) -> None:
        if self.get(key) != -1:
            # update
            self.data[key].val = value
        else:
            #new
            if len(self.data) == self.cap:
                # full, remove tail
                remove_node = self.tail.prev
                self.unlink(remove_node)
                del self.data[remove_node.key]

            node = self.ListNode(key, value)
            self.data[key] = node
            self.addToHead(node)

        self.printData('put')

        
    def unlink(self, node: ListNode) -> None:
        if not node:
            return

        prev_node = node.prev
        next_node = node.next
        if prev_node:
            prev_node.next = next_node
        if next_node:
            next_node.prev = prev_node
    
    def addToHead(self, node: ListNode) -> None:
        if not node:
            return
        
        next_head = self.head.next
        self.head.next = node
        node.prev = self.head
        node.next = next_head
        next_head.prev = node

    def printData(self, desc: str) -> None:
        node = self.head
        output = [desc]
        while node:
            output.append(node.val)
            node = node.next
        
        print(output)

#["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,0],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
# @lc code=end

