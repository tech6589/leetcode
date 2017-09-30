/*
 * [231] Power of Two
 *
 * https://leetcode.com/problems/power-of-two
 *
 * algorithms
 * Easy (40.27%)
 * Total Accepted:    146.9K
 * Total Submissions: 364.7K
 * Testcase Example:  '1'
 *
 * 
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
// 2^-1, 2^0, 2^1, 2^2, 2^3,... is power of two, now that n is a integer, then number satisfying the constraint starts from 2^0.
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)    return false;
        while(n!=1){
            if(n%2!=0)  return false;
            n=n/2;
        }
        return true;
    }
}
