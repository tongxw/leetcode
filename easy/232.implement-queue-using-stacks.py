#
# @lc app=leetcode id=232 lang=python3
#
# [232] Implement Queue using Stacks
#

# @lc code=start
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.push_stack = []
        self.pop_stack = []
        self.top = 0
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        if self.empty():
            self.top = x

        while self.pop_stack:
            self.push_stack.append(self.pop_stack.pop())
        self.push_stack.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        while self.push_stack:
            self.pop_stack.append(self.push_stack.pop())
        ret = self.pop_stack.pop()
        if self.pop_stack:
            self.top = self.pop_stack[-1]
        else:
            self.top = 0
        return ret

    def peek(self) -> int:
        """
        Get the front element.
        """
        return self.top

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return not self.push_stack and not self.pop_stack
        

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
# @lc code=end

