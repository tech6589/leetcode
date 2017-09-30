/*
 * [303] Range Sum Query - Immutable
 *
 * https://leetcode.com/problems/range-sum-query-immutable
 *
 * algorithms
 * Easy (30.18%)
 * Total Accepted:    77.8K
 * Total Submissions: 257.7K
 * Testcase Example:  '["NumArray","sumRange","sumRange","sumRange"]\n[[[-2,0,3,-5,2,-1]],[0,2],[2,5],[0,5]]'
 *
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * Example:
 * 
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 
 * 
 * 
 * Note:
 * 
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 * 
 * 
 */
// sum(i, j)=mem[j+1]-mem[i]
// mem[i] is the sum of numbers from 0 to i-1, i is exclusive
class NumArray {
    private int[] nums;
    private int[] mem;
    public NumArray(int[] nums) {
        this.nums=nums;
        // pre-computation
        mem=new int[nums.length+1];
        //mem starts from 1 to avoid if(i==0)
        for(int i=0; i+1<mem.length; i++){
            mem[i+1]=mem[i]+nums[i];// when i==0, mem[1]=mem[0]+nums[0], which is equal to mem[1]=nums[0]
        }
    }
    
    public int sumRange(int i, int j) {
        return mem[j+1]-mem[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
