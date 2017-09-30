/*
 * [136] Single Number
 *
 * https://leetcode.com/problems/single-number
 *
 * algorithms
 * Easy (54.68%)
 * Total Accepted:    240.9K
 * Total Submissions: 440.6K
 * Testcase Example:  '[1]'
 *
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 */
//exclusive or
//[1,1,2]
//1^1=0, 0^2=2
//(1^2)^1=2
public class Solution {
    public int singleNumber(int[] nums) {
        int result=nums[0];
        for(int i=1; i<nums.length; i++){
            result^=nums[i];
        }
        return result;
    }
}
