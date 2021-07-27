import heapq
#
# @lc app=leetcode id=1046 lang=python3
#
# [1046] Last Stone Weight
#

# @lc code=start
class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        stones = [-stone for stone in stones]
        heapq.heapify(stones)
        while len(stones) >= 2:
            s1 = heapq.heappop(stones)
            s2 = heapq.heappop(stones)
            diff = s2 - s1
            if diff != 0:
                heapq.heappush(stones, -diff)


        return -heapq.heappop(stones) if stones else 0
        
# @lc code=end

