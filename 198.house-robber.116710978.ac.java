/*
 * [198] House Robber
 *
 * https://leetcode.com/problems/house-robber
 *
 * algorithms
 * Easy (39.14%)
 * Total Accepted:    154.6K
 * Total Submissions: 394.9K
 * Testcase Example:  '[]'
 *
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping
 * you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent
 * houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight
 * without alerting the police.
 * 
 * Credits:Special thanks to @ifanchu for adding this problem and creating all
 * test cases. Also thanks to @ts for adding additional test cases.
 */
/*My original solutiom, two dimensions
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)  return 0;
        int[][] money=new int[nums.length][2];//(house i, rob or not)
        money[0][1]=nums[0];
        money[0][0]=0;
        for(int i=1; i<nums.length; i++){
            //rob
            money[i][1]=money[i-1][0]+nums[i];
            //not rob
            money[i][0]=Math.max(money[i-1][1], money[i-1][0]);
        }
        return Math.max(money[nums.length-1][0], money[nums.length-1][1]);
    }
}*/
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)  return 0;
        if(nums.length==1)  return nums[0];
        int[] money=new int[nums.length];//(house i)
        money[0]=nums[0];
        money[1]=Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++){
            money[i]=Math.max(money[i-2]+nums[i], money[i-1]);
        }
        return money[nums.length-1];
    }
}
