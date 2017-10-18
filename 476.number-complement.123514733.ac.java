/*
 * [476] Number Complement
 *
 * https://leetcode.com/problems/number-complement
 *
 * algorithms
 * Easy (60.91%)
 * Total Accepted:    57.2K
 * Total Submissions: 93.9K
 * Testcase Example:  '5'
 *
 * Given a positive integer, output its complement number. The complement
 * strategy is to flip the bits of its binary representation.
 * 
 * Note:
 * 
 * The given integer is guaranteed to fit within the range of a 32-bit signed
 * integer.
 * You could assume no leading zero bit in the integer’s binary
 * representation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits),
 * and its complement is 010. So you need to output 2.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and
 * its complement is 0. So you need to output 0.
 * 
 * 
 */
/*
    101 res
xor 001 mask
=   100 res
xor 010 mask
=   110 res
xor 100 mask
=   010 res
*/
class Solution {
    public int findComplement(int num) {
        if(num==0)  return 1;
        int res=num;
        int mask=1;
        while(num>0){
            res=res^mask;
            mask=mask<<1;
            num=num>>>1;
        }
        return res;
    }
}
