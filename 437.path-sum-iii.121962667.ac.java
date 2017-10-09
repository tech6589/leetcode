/*
 * [437] Path Sum III
 *
 * https://leetcode.com/problems/path-sum-iii
 *
 * algorithms
 * Easy (39.83%)
 * Total Accepted:    38.9K
 * Total Submissions: 97.6K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * You are given a binary tree in which each node contains an integer value.
 * 
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards
 * (traveling only from parent nodes to child nodes).
 * 
 * The tree has no more than 1,000 nodes and the values are in the range
 * -1,000,000 to 1,000,000.
 * 
 * Example:
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 * ⁠     10
 * ⁠    /  \
 * ⁠   5   -3
 * ⁠  / \    \
 * ⁠ 3   2   11
 * ⁠/ \   \
 * 3  -2   1
 * 
 * Return 3. The paths that sum to 8 are:
 * 
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
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
    public int pathSum(TreeNode root, int sum) {
        List<Integer> prefixSums=new ArrayList<>();
        return pathSum(root, sum, prefixSums);
    }
    private int pathSum(TreeNode root, int target, List<Integer> prefixSums){
        if(root==null)  return 0;
        for(int i=0; i<prefixSums.size(); i++)  prefixSums.set(i, prefixSums.get(i)+root.val);
        prefixSums.add(root.val);
        int path=0;
        for(int i=0; i<prefixSums.size(); i++){
            if(prefixSums.get(i)==target)   path++;
        }
        int res=path+pathSum(root.left, target, prefixSums)+pathSum(root.right, target, prefixSums);
        // minus root.val so that I can reuse prefixSums List
        prefixSums.remove(prefixSums.size()-1);
        for(int i=0; i<prefixSums.size(); i++)  prefixSums.set(i, prefixSums.get(i)-root.val);
        return res;
    }
}
