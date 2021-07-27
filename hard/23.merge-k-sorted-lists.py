import heapq
#
# @lc app=leetcode id=23 lang=python3
#
# [23] Merge k Sorted Lists
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        setattr(ListNode, "__lt__", lambda self, other: self.val <= other.val)
        heapq.heapify(lists)

        head = ListNode()
        node = head
        while lists:
            node.next = heapq.heappop(lists)
            node = node.next
            if node and node.next:
                heapq.heappush(lists, node.next)

        #[[],[]]
        return head.next
        
# @lc code=end

