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
// sum(root, cur) - target(diff or sum(middle exclusive, cur))== sum(root, middle)
class Solution {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map=new HashMap<>();//(prefixSum, frequency/occurrences)
        map.put(0, 1);//make sure root belongs to middle nodes, since sum(root, cur)-terget==0 if target==sum(root, cur)
        return pathSum(root, 0, sum, map);
    }
    private int pathSum(TreeNode root, int prefixSum, int target, Map<Integer, Integer> map){// prefixSum means the sum from root to current node
        if(root==null)  return 0;
        int res=0;
        prefixSum+=root.val;
        // if prefixSum-target exist in map, add the frequency into res
        if(map.containsKey(prefixSum-target))   res+=map.get(prefixSum-target);
        // add sum(root->cur) to map
        if(map.containsKey(prefixSum))          map.put(prefixSum, 1+map.get(prefixSum));
        else                                    map.put(prefixSum, 1);
        res+=pathSum(root.left, prefixSum, target, map)+pathSum(root.right, prefixSum, target, map);
        // revert map to previous status to so that branch a won't influence branch b
        map.put(prefixSum, map.get(prefixSum)-1);
        return res;
    }
}

