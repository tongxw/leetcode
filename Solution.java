import java.util.Stack;

class Solution {
  public int[][] generateMatrix(int n) {
    int[][] res = new int[n][n];

    int total = n * n;
    int count = 1;

    int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    final int RIGHT = 0;
    final int DOWN = 1;
    final int LEFT = 2;
    final int UP = 3;

    int row = 0;
    int col = 0;
    int direction = RIGHT;
    int leftLimit = -1;
    int rightLimit = n;
    int upLimit = 0;
    int downLimit = n;
    while (count <= total) {
        res[row][col] = count++;

        // try moving to the next grid, and change the direction if meet the boundary
        int nextRow = row + directions[direction][0];
        int nextCol = col + directions[direction][1];

        if (nextRow == downLimit) {
            direction = LEFT;
            downLimit--;
        } else if (nextRow == upLimit && count > n + 1) {
            direction = RIGHT;
            upLimit++;
        }

        if (nextCol == rightLimit) {
            direction = DOWN;
            rightLimit--;
        } else if (nextCol == leftLimit) {
            direction = UP;
            leftLimit++;
        }

        // re-calculate
        nextRow = row + directions[direction][0];
        nextCol = col + directions[direction][1];

        row = nextRow;
        col = nextCol;
    }

    return res;
}

    public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.generateMatrix(3));
    }
}


