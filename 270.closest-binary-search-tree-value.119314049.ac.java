/*
 * [270] Closest Binary Search Tree Value
 *
 * https://leetcode.com/problems/closest-binary-search-tree-value
 *
 * algorithms
 * Easy (39.72%)
 * Total Accepted:    38.8K
 * Total Submissions: 97.7K
 * Testcase Example:  '[1]\n4.428571'
 *
 * 
 * Given a non-empty binary search tree and a target value, find the value in
 * the BST that is closest to the target.
 * 
 * Note:
 * 
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest
 * to the target.
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int closestValue(TreeNode root, double target) {
        return getValue(root, target, root.val);
    }
    private int getValue(TreeNode root, double target, int result){
        if(root==null)              return result;
        if(Math.abs(target-root.val)<Math.abs(target-result))   result=root.val;
        if(target>root.val)         return getValue(root.right, target, result);
        else if(target<root.val)    return getValue(root.left, target, result);
        else                        return root.val;
    }
}
