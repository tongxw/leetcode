/*
 * @lc app=leetcode id=1260 lang=java
 *
 * [1260] Shift 2D Grid
 */

// @lc code=start
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int m = grid.length;
        int n = grid[0].length;

        for (int i=0; i<m; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            res.add(list);
            for (int j=0; j<n; j++) {
                list.add(grid[i][j]);
            }
        }

        for (int step=0; step<k; step++) {
            List<List<Integer>> old = new ArrayList<List<Integer>>();
            for(List<Integer> sublist : res) {
                old.add(new ArrayList<Integer>(sublist));
            }

            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (i==0 && j==0) {
                        // last element
                        //cur[i][j] = old[m][n];
                        res.get(i).set(j, old.get(m-1).get(n-1));
                    } else if (j==0) {
                        // first element of this line
                        // cur[i][j] = old[i-1][n]
                        res.get(i).set(j, old.get(i-1).get(n-1));
                    } else {
                        //cur[i][j] == old[i][j-1]
                        res.get(i).set(j, old.get(i).get(j-1));
                    }
                }
            }
        }

        // [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]]\n4
        return res;
    }
}
// @lc code=end

