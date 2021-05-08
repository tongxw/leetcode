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

        // // solution 1
        // for (int i=0; i<m; i++) {
        //     ArrayList<Integer> list = new ArrayList<>();
        //     res.add(list);
        //     for (int j=0; j<n; j++) {
        //         list.add(grid[i][j]);
        //     }
        // }

        // for (int step=0; step<k; step++) {
        //     List<List<Integer>> old = new ArrayList<List<Integer>>();
        //     for(List<Integer> sublist : res) {
        //         old.add(new ArrayList<Integer>(sublist));
        //     }

        //     for (int i=0; i<m; i++) {
        //         for (int j=0; j<n; j++) {
        //             if (i==0 && j==0) {
        //                 // last element
        //                 //cur[i][j] = old[m][n];
        //                 res.get(i).set(j, old.get(m-1).get(n-1));
        //             } else if (j==0) {
        //                 // first element of this line
        //                 // cur[i][j] = old[i-1][n]
        //                 res.get(i).set(j, old.get(i-1).get(n-1));
        //             } else {
        //                 //cur[i][j] == old[i][j-1]
        //                 res.get(i).set(j, old.get(i).get(j-1));
        //             }
        //         }
        //     }
        // }

        // solution 2, convert 2d array to 1d, push k, then convert it back
        ArrayList<Integer> old = new ArrayList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                old.add(grid[i][j]);
            }
        }

        // no need to do meaningless calculate..
        k = k % (m*n);

        // move
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i=0; i<m*n; i++) {
            if (i-k <=0) {
                // arr[i] = old[i-k+m*n]
                arr.add(old.get(i-k+(m*n)));
            } else {
                arr.add(old.get(i-k));
            }
        }

        // 2d to 1d
        // row = []
        // for i in range(m * n):
        //     if i > 0 and i % m == 0:
        //         res.append(row)
        //         row = []
        //     row.append(arr[i])
        // res.append(row)
        ArrayList<Integer> row = new ArrayList<>();
        for (int i=0; i<m*n; i++) {
            if (i > 0 && i % m == 0) {
                // new row
                row = new ArrayList<Integer>();
                res.add(row);
            }

            row.add(arr.get(i));
        }



        // [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]]\n4
        return res;
    }
}
// @lc code=end

