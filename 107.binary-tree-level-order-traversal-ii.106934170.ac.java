/*
 * [107] Binary Tree Level Order Traversal II
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii
 *
 * algorithms
 * Easy (40.61%)
 * Total Accepted:    140.1K
 * Total Submissions: 344.9K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the bottom-up level order traversal of its
 * nodes' values. (ie, from left to right, level by level from leaf to root).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its bottom-up level order traversal as:
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
 * 
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
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results=new LinkedList<>();
        int height=height(root);
        for(int i=1; i<=height; i++){
            List<Integer> result=new LinkedList<>();
            results.add(result);
        }
        traverse(root, height, results);
        return results;
    }
    private void traverse(TreeNode node, int level, List<List<Integer>> results){
        if(node==null)  return;
        results.get(level-1).add(node.val);
        if(level==1)    return;
        traverse(node.left, level-1, results);
        traverse(node.right, level-1, results);
    }
    private int height(TreeNode root){
        if(root==null)  return 0;        
        return 1+Math.max(height(root.left), height(root.right));
    }
}
