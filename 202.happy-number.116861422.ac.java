/*
 * [202] Happy Number
 *
 * https://leetcode.com/problems/happy-number
 *
 * algorithms
 * Easy (40.85%)
 * Total Accepted:    134.8K
 * Total Submissions: 330.1K
 * Testcase Example:  '1'
 *
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 
 * 
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 
 * 
 * Credits:Special thanks to @mithmatt and @ts for adding this problem and
 * creating all test cases.
 */
/*When n is not a happy number, it will repeat.
* 2
* 4
* 16
* 37
* 58
* 89
* 145
* 42
* 20
* 4
* 16
* 37
* 58
* 89
* 145
* 42
* 20
* 4
* 16
* 37
* 58
* 89
* 145
* 42
* 20
*/
class Solution {
    public boolean isHappy(int n) {
        int squareSum=0;
        List<Integer> nums=new LinkedList<>();
        while(nums.add(n)){
            squareSum=0;
            while(n>0){
                squareSum+=Math.pow(n%10, 2);
                n/=10;
            }
            n=squareSum;
            //System.out.println(n);
            if(n==1)    return true;
            if(nums.contains(n))    return false;
        }  
        //System.out.println(squareSum);
        return false;
    }
}
