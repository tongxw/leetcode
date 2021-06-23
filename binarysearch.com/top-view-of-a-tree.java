import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    // https://binarysearch.com/problems/Top-View-of-a-Tree
    public int[] solve(Tree root) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return new int[0];
        }

        Queue<Data> q = new LinkedList<>();
        q.offer(new Data(root, 0));
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i=0; i<len; i++) {
                Data d = q.poll();

                if (!set.contains(d.col)) {
                    set.add(d.col);
                    if (d.col < 0) {
                        ans.add(0, d.node.val);
                    } else {
                        ans.add(d.node.val);
                    }
                }

                if (d.node.left != null) {
                    q.offer(new Data(d.node.left, d.col - 1));
                }
                if (d.node.right != null) {
                    q.offer(new Data(d.node.right, d.col + 1));
                }
            }
        }

        int[] ret = new int[ans.size()];
        for (int i=0; i<ret.length; i++) {
            ret[i] = ans.get(i);
        }

        return ret;
    }

    private class Data {
        Tree node;
        int col;
        Data(Tree node, int col) {
            this.node = node;
            this.col = col;
        }
    }
}