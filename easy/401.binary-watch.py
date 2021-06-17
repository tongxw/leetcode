#
# @lc app=leetcode id=401 lang=python3
#
# [401] Binary Watch
#

# @lc code=start
class Solution:
    def readBinaryWatch(self, turnedOn: int) -> List[str]:
        def countBits(num):
            count = 0
            while (num != 0):
                count += num & 1
                num = num >> 1

            # print("num: %d, count: %d" %(num, count))
            return count
        
        ans = []
        for i in range(12):
            for j in range (60):
                if countBits((i << 6) | j) == turnedOn:
                    ans.append("%d:%02d" % (i, j))

        return ans
        
# @lc code=end

