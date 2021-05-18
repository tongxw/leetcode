/*
 * @lc app=leetcode id=109 lang=cpp
 *
 * [109] Convert Sorted List to Binary Search Tree
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
private:
     vector<int> stack;
public:
    TreeNode* sortedListToBST(ListNode* head) {
        // cout << stack.size() << "\n";

        // stack.push_back(1);

        // if (head == nullptr) {
        //     stack.pop_back();
        //     return nullptr;
        // } else if (head->next == nullptr) {
        //     stack.pop_back();
        //     return new TreeNode(head->val);
        // }

        // ListNode* fast = head;
        // ListNode* slow = head;
        // ListNode* pre = nullptr;
        // while (fast != nullptr && fast->next != nullptr) {
        //     pre = slow;
        //     slow = slow->next;
        //     fast = fast->next->next;
        // }

        // if (pre != nullptr) {
        //     pre->next = nullptr;
        // }

        // TreeNode* root = new TreeNode(slow->val);
        // root->left = sortedListToBST(head);
        // root->right = sortedListToBST(slow->next);

        // stack.pop_back();
        // return root;

        if (head == nullptr) {
            return nullptr;
        }

        return buildBst(head, nullptr);
    }

private:
    TreeNode* buildBst(ListNode* start, ListNode* end) {
        if (start == end) {
            return nullptr;
        }

        ListNode* slow = start;
        ListNode* fast = start;
        while (fast != end && fast->next != end) {
            slow = slow->next;
            fast = fast->next->next;
        }

        cout << slow->val <<"\n";

        TreeNode* root = new TreeNode(slow->val);
        root->left = buildBst(start, slow);
        root->right = buildBst(slow->next, nullptr);
        // if (end == slow->next || (end != nullptr && slow->next != nullptr && end->val <= slow->next->val)) {
        //     root->right = nullptr;
        // } else {
        //     root->right = buildBst(slow->next, nullptr);
        // }

        return root;
    }
};
// @lc code=end

