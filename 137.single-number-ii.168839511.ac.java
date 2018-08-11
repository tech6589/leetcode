/*
 * [137] Single Number II
 *
 * https://leetcode.com/problems/single-number-ii/description/
 *
 * algorithms
 * Medium (43.44%)
 * Total Accepted:    141.6K
 * Total Submissions: 326K
 * Testcase Example:  '[2,2,3,2]'
 *
 * Given a non-empty array of integers, every element appears three times
 * except for one, which appears exactly once. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * 
 * Input: [2,2,3,2]
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 * 
 */
/* When n==0, low and high keep the same
 * For bit 1 in a certain index
 *                  hl
 * appear 0 time    00
 * appear 1 time    01
 * appear 2 times   10
 * appear 3 times   00(should be 11, but to leave low index 1 for appear 1 time, use 00 instead)
 *
 * appear 4 time    01
 * appear 5 time    10
 * appear 6 time    00
 * appear 7 time    01
 * 1 digit requires 2 digits to express the times bit 1 appears, so 32 digits require 64 digits.
 * Therefore use two int low and high to make up 64bits.
 * the ith digit of number is expressed by ith digit of low and ith digit of high, low and high express all digits
 *
 * low is 1 only when bit 1 appears 1/4/7/3n+1 times, which corresponds to the appearing exactly once case.
 * So after traversing, low is the appearing once result to return
 *
 * low: 0 -> 1 -> 0 -> 0(mid 1), ^ 1 mostly(n is 1), so use low^=n
 * For the irregular change of low 0 -> 0, preH==1 is the mark.
 * If preH==1, preL==0 -> midL==1 -> newL==0. If preH==0, preL==0 -> midL==1 -> newL==1
 * So midL ^ preH -> newL, which is low^=high
 *
 * high: 0 -> 0(mid 1) -> 1 -> 0, ^ 1 mostly(n is 1), so use high^=n
 * For the irregular change of high 0 -> 0, newL==1 is the mark.
 * If newL==1, preH==0 -> midH==1 -> newH==0, Of newL==0, preH==0 -> midH==1 -> newH==1
 * So midH ^ newL -> newH, which is high^=low
 * 
 * When n==0, there will be something wrong
 * For l: preH==1, preL==0 -> midL==0, midL ^ preH -> newL==1, but newL should be 0
 * For h and appear 2 times: preL==1 -> newL==1, preH==0 -> midH==0, midH ^ newL -> newH==1, but newH should be 0
 * So use &n to solve it, when n==0, x&0==0, x^0==x
 * That is high&n instead of high, low&n instead of low
*/
class Solution {
    public int singleNumber(int[] nums) {
        int low=0, high=0;
        for(int n: nums){
            low^=n; // proceed
            low^=(high&n); // high==1 as mark to solve 0 -> 0(mid 1)
            high^=n; // proceed
            high^=(low&n); // low==1 as mark to solve 0 -> 0(mid 1)
        }
        return low;
    }
}
