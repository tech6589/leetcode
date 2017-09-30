/*
 * [112] Path Sum
 *
 * https://leetcode.com/problems/path-sum
 *
 * algorithms
 * Easy (34.17%)
 * Total Accepted:    179.8K
 * Total Submissions: 526.3K
 * Testcase Example:  '[]\n1'
 *
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * 
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \      \
 * ⁠       7    2      1
 * 
 * 
 * 
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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
// Minus principle and check if sum==0 when it comes to leaf node.
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)  return false;//invalidate path with null node
        sum-=root.val;
        if(root.left==null&&root.right==null)   return sum==0;//Leaf Node
        return hasPathSum(root.left, sum)||hasPathSum(root.right, sum);   
    }
}
