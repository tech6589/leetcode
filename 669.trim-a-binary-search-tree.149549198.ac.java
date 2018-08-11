/*
 * [669] Trim a Binary Search Tree
 *
 * https://leetcode.com/problems/trim-a-binary-search-tree/description/
 *
 * algorithms
 * Easy (58.16%)
 * Total Accepted:    40.1K
 * Total Submissions: 68.9K
 * Testcase Example:  '[1,0,2]\n1\n2'
 *
 * 
 * Given a binary search tree and the lowest and highest boundaries as L and R,
 * trim the tree so that all its elements lies in [L, R] (R >= L). You might
 * need to change the root of the tree, so the result should return the new
 * root of the trimmed binary search tree.
 * 
 * 
 * Example 1:
 * 
 * Input: 
 * ⁠   1
 * ⁠  / \
 * ⁠ 0   2
 * 
 * ⁠ L = 1
 * ⁠ R = 2
 * 
 * Output: 
 * ⁠   1
 * ⁠     \
 * ⁠      2
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 
 * ⁠   3
 * ⁠  / \
 * ⁠ 0   4
 * ⁠  \
 * ⁠   2
 * ⁠  /
 * ⁠ 1
 * 
 * ⁠ L = 1
 * ⁠ R = 3
 * 
 * Output: 
 * ⁠     3
 * ⁠    / 
 * ⁠  2   
 * ⁠ /
 * ⁠1
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
class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        List<TreeNode> list=new ArrayList<>();
        traverse(root, list, L, R);
        TreeNode newRoot=list.get(0);
        newRoot.left=null;newRoot.right=null;
        for(int i=1; i<list.size(); i++){
            TreeNode node=list.get(i);
            //clean node
            node.left=null;
            node.right=null;
            insert(newRoot, node);
        }
        return newRoot;
    }
    private void traverse(TreeNode node, List<TreeNode> l, int L, int R){
        if(node==null)  return;
        if(node.val>=L&&node.val<=R)    l.add(node);
        traverse(node.left, l, L, R);
        traverse(node.right, l, L, R);
    }
    private void insert(TreeNode root, TreeNode node){
        if(node.val<root.val){
            if(root.left==null){
                root.left=node;
            }else{
                insert(root.left, node);
            }
        }else{// >
            if(root.right==null){
                root.right=node;
            }else{
                insert(root.right, node);
            }
        }
    }
}
