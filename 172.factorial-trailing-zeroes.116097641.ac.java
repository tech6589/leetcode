/*
 * [172] Factorial Trailing Zeroes
 *
 * https://leetcode.com/problems/factorial-trailing-zeroes
 *
 * algorithms
 * Easy (36.23%)
 * Total Accepted:    100.3K
 * Total Submissions: 276.7K
 * Testcase Example:  '0'
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * Credits:Special thanks to @ts for adding this problem and creating all test
 * cases.
 */
/*
For instance, 100!

Divide until you reach a number which is `less than 5`.

100/5 -> 20/5 -> 4

20+4 is the result, the number of trailing zeros in factorial one hundred.
*/
class Solution {
    public int trailingZeroes(int n) {
        int result=0;
        while(n>=5){
            n/=5;
            result+=n;
        }
        return result;
    }
}
