/*
 * [504] Base 7
 *
 * https://leetcode.com/problems/base-7/description/
 *
 * algorithms
 * Easy (43.91%)
 * Total Accepted:    31.2K
 * Total Submissions: 71.1K
 * Testcase Example:  '100'
 *
 * Given an integer, return its base 7 string representation.
 * 
 * Example 1:
 * 
 * Input: 100
 * Output: "202"
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: -7
 * Output: "-10"
 * 
 * 
 * 
 * Note:
 * The input will be in range of [-1e7, 1e7].
 * 
 */
// class Solution {
//     public String convertToBase7(int num) {
//         boolean isPositive=true;
//         if(num<0){
//             isPositive=false;
//             num=-num;
//         }
//         int res=0;
//         int base=1;
//         while(num>0){
//             res+=(num%7)*base;
//             num/=7;
//             base*=10;
//         }
//         if(isPositive==true)    return ""+res;
//         else                    return "-"+res;
//     }
// }
class Solution {
    public String convertToBase7(int num) {
        if(num==0)              return "0";
        boolean isPositive=true;
        if(num<0){
            isPositive=false;
            num=-num;
        }
        String res="";
        while(num>0){
            res=num%7+res;
            num/=7;
        }
        if(isPositive==true)    return ""+res;
        else                    return "-"+res;
    }
}

