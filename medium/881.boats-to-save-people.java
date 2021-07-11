import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=881 lang=java
 *
 * [881] Boats to Save People
 */

// @lc code=start
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // Arrays.sort(people);
        // dfs(people, 0, 0, limit);

        // return count;
        return greedy(people, limit);
    }

    private int greedy(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;

        // 局部最优：
        // put the biggest person in the boat
        // then check if the lightest person can fit in the same boat
        // double pointers
        int l = 0;
        for (int r=people.length - 1; r>=l; r--) {
            // assign a new boat
            ans++;

            // limit left
            int weightLeft = limit - people[r];
            if (weightLeft >= people[l]) {
                // same boat
                l++;
            }
        }

        return ans;
    }

    private int myFirstSolution(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>((e1, e2) -> {
            return e2 - e1;
        });
        for (int i=people.length - 1; i>=0; i--) {
            if (!pQ.isEmpty() && people[i] <= pQ.peek()) {
                pQ.poll();
            } else {
                int weightLeft = limit - people[i];
                if (weightLeft > 0) {
                    pQ.offer(weightLeft);
                }
                ans++;
            }
        }

        return ans;
    }

    private int count = 0;
    private void dfs(int[] people, int cur, int limitLeft, int limit) {
        if (cur == people.length) {
            return;
        }

        if (people[cur] <= limitLeft) {
            dfs(people, cur + 1, 0, limit);
        } else {
            ++count;
            dfs(people, cur + 1, limit - people[cur], limit);
        }

        //[3,5,3,4]\n5
        //[5,1,4,2]\n6
    }
}
// @lc code=end

