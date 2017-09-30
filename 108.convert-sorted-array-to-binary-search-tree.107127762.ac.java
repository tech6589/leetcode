/*
 * [108] Convert Sorted Array to Binary Search Tree
 *
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree
 *
 * algorithms
 * Easy (42.41%)
 * Total Accepted:    140.3K
 * Total Submissions: 330.8K
 * Testcase Example:  '[]'
 *
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length);
    }
    private TreeNode buildBST(int[] nums, int low, int high){//low is inclusive and high is exclusive
        if(low>=high)    return null;
        int middle=(low+high)/2;
        TreeNode node=new TreeNode(nums[middle]);
        node.left=buildBST(nums, low, middle);
        node.right=buildBST(nums, middle+1, high);
        return node;
    }
}
