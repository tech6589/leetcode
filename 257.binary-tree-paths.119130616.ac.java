/*
 * [257] Binary Tree Paths
 *
 * https://leetcode.com/problems/binary-tree-paths
 *
 * algorithms
 * Easy (39.03%)
 * Total Accepted:    125.4K
 * Total Submissions: 321.2K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * 
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * 
 * For example, given the following binary tree:
 * 
 * 
 * 
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 * 
 * 
 * 
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new LinkedList<>();
        if(root==null)  return result;
        path(root, "", result);
        return result;
    }
    private void path(TreeNode root, String s, List<String> result){
        s=s+root.val;
        if(root.left==null&&root.right==null){
            result.add(s);
            return;
        }
        s=s+"->";
        if(root.left!=null)     path(root.left, s, result);
        if(root.right!=null)    path(root.right, s, result);
    }
}
