/*
 * [258] Add Digits
 *
 * https://leetcode.com/problems/add-digits
 *
 * algorithms
 * Easy (51.30%)
 * Total Accepted:    174.4K
 * Total Submissions: 340K
 * Testcase Example:  '0'
 *
 * 
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit. 
 * 
 * 
 * 
 * For example:
 * 
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only
 * one digit, return it.
 * 
 * 
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
/* Basic Solution
class Solution {
    public int addDigits(int num) {
        while(num>9){
            num=add(num);
        }
        return num;
    }
    private int add(int num){
        int result=0;
        while(num>0){
            result+=num%10;
            num/=10;
        }
        return result;
    }
}*/
/*Math Solution
1     1
2     2
3     3
4     4
5     5
6     6
7     7
8     8    
9     9

10    1
11    2
12    3    
13    4
14    5
15    6
16    7
17    8
18    9

19    1
20    2
21    3
22    4
23    5
24    6
25    7
26    8
27    9

*//*
class Solution {
    public int addDigits(int num) {
        if(num==0)   return 0;
        int result=num%9;
        if(result==0)   return 9;
        else            return result;
    }
}*/
//One line Solution
class Solution {
    public int addDigits(int num) {
        return (num-1)%9+1;
    }
}



