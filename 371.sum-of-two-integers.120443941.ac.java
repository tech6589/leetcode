/*
 * [371] Sum of Two Integers
 *
 * https://leetcode.com/problems/sum-of-two-integers
 *
 * algorithms
 * Easy (51.20%)
 * Total Accepted:    78.9K
 * Total Submissions: 154K
 * Testcase Example:  '1\n2'
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use
 * the operator + and -.
 * 
 * Example:
 * Given a = 1 and b = 2, return 3.
 * 
 * 
 * Credits:Special thanks to @fujiaozhu for adding this problem and creating
 * all test cases.
 */
// carry bit: a & b, has to be left shifted 1 bit: (a&b)<<1
// base bit: a xor b
// plus carry bit and home bit the same way, calculate their carry and base, carry<<1
// until carry == 0
// m:       1       1       0       0
// n:       1       0       1       0
// m+n:    10      01      01      00
//         cb      cb      cb      cb
class Solution {
    public int getSum(int a, int b) {
        while(a!=0){
            int tmpA=a;
            a=(a&b)<<1;
            b=tmpA^b;
        }
        return b;
    }
}
