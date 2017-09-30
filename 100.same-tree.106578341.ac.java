/*
 * [100] Same Tree
 *
 * https://leetcode.com/problems/same-tree
 *
 * algorithms
 * Easy (46.69%)
 * Total Accepted:    222.2K
 * Total Submissions: 475.9K
 * Testcase Example:  '[]\n[]'
 *
 * 
 * Given two binary trees, write a function to check if they are equal or
 * not.
 * 
 * 
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p==null)&&(q==null)){
            return true;
        }else if((p==null)||(q==null)){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
    }
    
}
