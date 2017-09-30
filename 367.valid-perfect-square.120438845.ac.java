/*
 * [367] Valid Perfect Square
 *
 * https://leetcode.com/problems/valid-perfect-square
 *
 * algorithms
 * Easy (38.33%)
 * Total Accepted:    53.5K
 * Total Submissions: 139.6K
 * Testcase Example:  '16'
 *
 * Given a positive integer num, write a function which returns True if num is
 * a perfect square else False.
 * 
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * 
 * 
 * Example 1:
 * 
 * Input: 16
 * Returns: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 14
 * Returns: False
 * 
 * 
 * 
 * Credits:Special thanks to @elmirap for adding this problem and creating all
 * test cases.
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        return isPerfectSquare(num, 1, 46340);//1 inclusive and 46340 inclusive
    }
    private boolean isPerfectSquare(int target, int x, int y){
        int square=((x+y)/2)*((x+y)/2);
        if(x+1==y){
            if((target!=square)&&target!=y*y)   return false;
            else                                return true;
        }
        if(target>square)                       return isPerfectSquare(target, (x+y)/2, y);
        else if(target<square)                  return isPerfectSquare(target, x, (x+y)/2);
        else                                    return true;
    }
}
