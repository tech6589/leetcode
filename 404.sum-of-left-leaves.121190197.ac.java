/*
 * [404] Sum of Left Leaves
 *
 * https://leetcode.com/problems/sum-of-left-leaves
 *
 * algorithms
 * Easy (47.09%)
 * Total Accepted:    64.8K
 * Total Submissions: 137.5K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Find the sum of all left leaves in a given binary tree.
 * 
 * Example:
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * There are two left leaves in the binary tree, with values 9 and 15
 * respectively. Return 24.
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
// Left Leaves
// if I am left and both my left and right are null, then add my val
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)  return 0;
        else            return sum(root.left, true)+sum(root.right, false);
    }
    private int sum(TreeNode root, boolean isLeft){
        if(root==null)                                                  return 0;
        else if((isLeft==true)&&(root.left==null)&&(root.right==null))  return root.val;
        else                                                            return sum(root.left, true)+sum(root.right, false);                               
    }
    
}
