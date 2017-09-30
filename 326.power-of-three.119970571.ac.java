/*
 * [326] Power of Three
 *
 * https://leetcode.com/problems/power-of-three
 *
 * algorithms
 * Easy (40.35%)
 * Total Accepted:    103.6K
 * Total Submissions: 256.8K
 * Testcase Example:  '27'
 *
 * 
 * ⁠   Given an integer, write a function to determine if it is a power of
 * three.
 * 
 * 
 * ⁠   Follow up:
 * ⁠   Could you do it without using any loop / recursion?
 * 
 * 
 * Credits:Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 */
/*Loop Solution
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==0)    return false;
        while(n%3==0){
            n/=3;
        }
        if(n==1)    return true;
        else        return false;
    }
}*/
// 3^19 < 2^31-1 < 3^20
class Solution {
    public boolean isPowerOfThree(int n) {
        return n>0&&(int)Math.pow(3, 19)%n==0;
    }
}
