import java.util.Deque;
import java.util.LinkedList;


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static TreeNode constructTree(Integer[] nums){
        if (nums.length == 0) return new TreeNode(0);
        Deque<TreeNode> nodeQueue = new LinkedList<>();

        TreeNode root = new TreeNode(nums[0]);
        nodeQueue.offer(root);
        TreeNode cur;

        int lineNodeNum = 2; // all tree nodes in the current line
        int startIndex = 1; // array index of the current line
        int restLength = nums.length - 1; // total elements left in array

        while(restLength > 0) {
            for (int i = startIndex; i < startIndex + lineNodeNum; i = i + 2) {
                if (i == nums.length) return root;
                cur = nodeQueue.poll();
                if (nums[i] != null) {
                    cur.left = new TreeNode(nums[i]);
                    nodeQueue.offer(cur.left);
                }

                if (i + 1 == nums.length) return root;
                if (nums[i + 1] != null) {
                    cur.right = new TreeNode(nums[i + 1]);
                    nodeQueue.offer(cur.right);
                }
            }
            startIndex += lineNodeNum;
            restLength -= lineNodeNum;
            lineNodeNum = nodeQueue.size() * 2;
        }

        return root;
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrder(root.left);
        System.out.print(root.val + " ");
        midOrder(root.right);
    }
    public static void aftOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        aftOrder(root.left);
        aftOrder(root.right);
        System.out.print(root.val + " ");
    }
}