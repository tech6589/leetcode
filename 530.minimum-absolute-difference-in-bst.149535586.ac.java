/*
 * [530] Minimum Absolute Difference in BST
 *
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
 *
 * algorithms
 * Easy (48.17%)
 * Total Accepted:    42.1K
 * Total Submissions: 87.3K
 * Testcase Example:  '[1,null,3,2]'
 *
 * Given a binary search tree with non-negative values, find the minimum
 * absolute difference between values of any two nodes.
 * 
 * 
 * Example:
 * 
 * Input:
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    3
 * ⁠   /
 * ⁠  2
 * 
 * Output:
 * 1
 * 
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and
 * 1 (or between 2 and 3).
 * 
 * 
 * 
 * 
 * Note:
 * There are at least two nodes in this BST.
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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> l=new ArrayList<>();
        traverse(root, l);
        Collections.sort(l);
        int min=Integer.MAX_VALUE;
        for(int i=0; i+1<l.size(); i++){
            int diff=Math.abs(l.get(i)-l.get(i+1));
            if(diff<min)    min=diff;
        }
        return min;
    }
    private void traverse(TreeNode node, List<Integer> l){
        if(node==null)  return;
        l.add(node.val);
        traverse(node.left, l);
        traverse(node.right, l);
    }
}
