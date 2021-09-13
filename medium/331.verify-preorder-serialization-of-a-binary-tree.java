import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=331 lang=java
 *
 * [331] Verify Preorder Serialization of a Binary Tree
 */

// @lc code=start
class Solution {
    public boolean isValidSerialization(String preorder) {
        return stackSolution(preorder);
    }

    private boolean stackSolution(String preorder) {
        String[] nodes = preorder.split(",");
        Deque<String> stack = new LinkedList<>();
        for (String node : nodes) {
            if (stack.size() == 1 && stack.peek().equals("#")) {
                // "1,#,#,#,#"
                // if we already reduce the tree to the root node
                // and there is still node left, it must be invalid
                return false;
            }

            if (node.equals("#")) {
                while ("#".equals(stackOp(stack))) {

                }
            }
            stack.push(node);
         }

         // all tree nodes are processed, the tree should be reduced to "#"
         return stack.size() == 1 && stack.peek().equals("#");
    }

    private String stackOp(Deque<String> stack) {
        if (stack.size() < 2) {
            // 2 nodes at least
            return null;
        }

        // check if the top of stack is "#"
        String top = stack.peek();
        if (!top.equals("#")) {
            return null;
        }

        stack.pop(); // pop the "#" at the top
        stack.pop(); // pop the non-empty node

        // return the top node of the stack
        return stack.isEmpty() ? null : stack.peek();
    }

    private boolean degreeSolution(String preorder) {
        // for a valid tree, indegree == outdegree;
        // for a non-empty node, indegree = 1, outdegree = 2;
        // for a empty node, indegree = 1, outdegree = 0;
        // for root node, indgree = 0, outdegree = 2
        int diff = 1; // init diff = 1, since for root node, diff = (out - in) = 2;
        String[] nodes = preorder.split(",");
        for (String node : nodes) {
            diff -= 1;
            if (diff < 0) {
                return false;
            }

            if (!node.equals("#")) {
                diff += 2;
            }
        }

        return diff == 0;
    }
}
// @lc code=end

