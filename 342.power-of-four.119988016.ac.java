/*
 * [342] Power of Four
 *
 * https://leetcode.com/problems/power-of-four
 *
 * algorithms
 * Easy (38.62%)
 * Total Accepted:    71.3K
 * Total Submissions: 184.5K
 * Testcase Example:  '16'
 *
 * 
 * Given an integer (signed 32 bits), write a function to check whether it is a
 * power of 4.
 * 
 * Example:
 * Given num = 16, return true.
 * Given num = 5, return false.
 * 
 * 
 * Follow up: Could you solve it without loops/recursion?
 * 
 * Credits:Special thanks to @yukuairoy  for adding this problem and creating
 * all test cases.
 */
// 4^15 < 2^31-1 < 4^16
// note that 4^0 is a power of 4
// care 2
// powerOfFour = 2^even
// 2^even/2^odd == 2^odd
// check if odd: log2(2^odd) == odd
/* exclude 2 solution
class Solution {
    public boolean isPowerOfFour(int num) {
        int maxPowerOfFour=(int)Math.pow(4, 15);//4^15==2^30
        return  num>0 &&
                maxPowerOfFour%num==0 &&// num can be divided by 4^15
                (int)(Math.log(maxPowerOfFour/num)/Math.log(2))%2==0;// exclude the case of 2^1, 2^3, 2^5, 2^7, 2^9, ...
    }
}*/
// log, round to int and power solution
class Solution {
    public boolean isPowerOfFour(int num) {
        if(num<=0)  return false;
        int exp = (int)(Math.log(num)/Math.log(4));
        return      Math.pow(4, exp)==num;
    }
}
