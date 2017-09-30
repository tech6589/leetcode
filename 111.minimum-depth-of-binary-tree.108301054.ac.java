/*
 * [111] Minimum Depth of Binary Tree
 *
 * https://leetcode.com/problems/minimum-depth-of-binary-tree
 *
 * algorithms
 * Easy (33.26%)
 * Total Accepted:    182.7K
 * Total Submissions: 549.3K
 * Testcase Example:  '[]'
 *
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
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
// Leaf node is a node without left or right child.
// Two children are null:   leaf node
// One children is null:    1+min depth of another child
// No children is null:     1+min depth of two children
public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)  return 0;
        return min(root);
    }
    private int min(TreeNode node){
        if(node.left==null&&node.right==null)  return 1;//leaf node
        if(node.left==null){
            return 1+min(node.right);
        }
        if(node.right==null){
            return 1+min(node.left);
        }
        return 1+Math.min(min(node.left), min(node.right));
    }
}
