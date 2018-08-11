/*
 * [260] Single Number III
 *
 * https://leetcode.com/problems/single-number-iii/description/
 *
 * algorithms
 * Medium (54.11%)
 * Total Accepted:    87.6K
 * Total Submissions: 161.8K
 * Testcase Example:  '[1,2,1,3,2,5]'
 *
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 * 
 * Example:
 * 
 * 
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * 
 * Note:
 * 
 * 
 * The order of the result is not important. So in the above example, [5, 3] is
 * also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant space complexity?
 * 
 * 
 */

class Solution {
    // return [a, b] or [b, a]
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int x=0;
        for(int n: nums){
            x^=n;
        }
        // x now equals a^b because x^x == 0
        x&=(-x); // -x flip all digits of x and plus 1, x & (-x) will get one bit 1 and other bits 0, & makes sure the remained 1 is part of x, -x makes sure only one bit 1 remains.
        // divide a and b into 2 groups. Since a and b are difference, there will be at least one digit that is 1 in a^b, clear all other digits to 0 to get the new x. x&a and x&b will result in one zero and another non-zero.
        for(int n: nums){
            if((x&n) == 0){
                res[0]^=n; // 1^1^3 == 3
            }else{
                res[1]^=n; // 2^2^5 == 5
            }
        }
        return res;
        
    }
}
