/*
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray
 *
 * algorithms
 * Easy (39.71%)
 * Total Accepted:    231.8K
 * Total Submissions: 583.7K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 
 * Find the contiguous subarray within an array (containing at least one
 * number) which has the largest sum.
 * 
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * click to show more practice.
 * 
 * More practice:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 */
// video: https://www.youtube.com/watch?v=86CQq3pKSUw
// Kadane's Algorithm to Maximum Sum Subarray Problem

public class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum=Math.max(nums[i], nums[i]+sum);
            if(sum>max){
                max=sum;
            }
        }
        return max;
        
    }
}
