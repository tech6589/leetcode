/*
 * [268] Missing Number
 *
 * https://leetcode.com/problems/missing-number
 *
 * algorithms
 * Easy (44.27%)
 * Total Accepted:    132.8K
 * Total Submissions: 299.9K
 * Testcase Example:  '[0]'
 *
 * 
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 * 
 * 
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * 
 * 
 * 
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant extra space complexity?
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
/*time:O(nlogn), space: O(1)
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int x=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=x)  return x;
            x++;
        }
        return x;
    }
}*/
// Bit Solution
// a^b^b =a
// nums[i]: 0 1 3
// i:       0 1 2 3
class Solution {
    public int missingNumber(int[] nums) {
        int result=0;
        int i=0;
        for(; i<nums.length; i++){
            result=result^nums[i]^i;
        }
        result=result^i;
        return result;
    }
}
