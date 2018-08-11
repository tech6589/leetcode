/*
 * [501] Find Mode in Binary Search Tree
 *
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 *
 * algorithms
 * Easy (37.86%)
 * Total Accepted:    39.6K
 * Total Submissions: 104.6K
 * Testcase Example:  '[1,null,2,2]'
 *
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the
 * most frequently occurred element) in the given BST.
 * 
 * Assume a BST is defined as follows:
 * 
 * 
 * The left subtree of a node contains only nodes with keys less than or equal
 * to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or
 * equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * 
 * 
 * For example:
 * Given BST [1,null,2,2],
 * 
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  2
 * 
 * 
 * 
 * 
 * return [2].
 * 
 * Note: If a tree has more than one mode, you can return them in any order.
 * 
 * Follow up: Could you do that without using any extra space? (Assume that the
 * implicit stack space incurred due to recursion does not count).
 * 
 */
/*
 * [501] Find Mode in Binary Search Tree
 *
 * https://leetcode.com/problems/find-mode-in-binary-search-tree
 *
 * algorithms
 * Easy (37.74%)
 * Total Accepted:    23.8K
 * Total Submissions: 63K
 * Testcase Example:  '[1,null,2,2]'
 *
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the
 * most frequently occurred element) in the given BST.
 * 
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than or equal
 * to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or
 * equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * 
 * 
 * For example:
 * Given BST [1,null,2,2],
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  2
 * 
 * 
 * 
 * return [2].
 * 
 * 
 * Note:
 * If a tree has more than one mode, you can return them in any order.
 * 
 * 
 * Follow up:
 * Could you do that without using any extra space? (Assume that the implicit
 * stack space incurred due to recursion does not count).
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
    public int[] findMode(TreeNode root) {
    	Frequency f=new Frequency();
        findMode(root, f);
        int[] res=new int[f.list.size()];
        for(int i=0; i<res.length; i++)	res[i]=f.list.get(i);
		return res;
    }
    private void findMode(TreeNode root, Frequency f){
    	if(root==null)					return;
    	findMode(root.left, f);
    	if(f.fre==0)					f.fre=1;
    	else if(f.preRootVal==root.val)	f.fre++;
    	else							f.fre=1;
    	f.preRootVal=root.val;
    	if(f.fre>f.maxFre){
    		f.maxFre=f.fre;
    		f.list.clear();//clear list before
    		f.list.add(root.val);
    	}else if(f.fre==f.maxFre){
    		f.list.add(root.val);
    	}
    	findMode(root.right, f);
    }
}
class Frequency{
	int fre=0;
	int maxFre=0;
	int preRootVal=0;
	List<Integer> list=new ArrayList<>();
}
