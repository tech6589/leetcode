/*
 * [415] Add Strings
 *
 * https://leetcode.com/problems/add-strings
 *
 * algorithms
 * Easy (41.54%)
 * Total Accepted:    42.8K
 * Total Submissions: 103K
 * Testcase Example:  '"0"\n"0"'
 *
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb=new StringBuilder();
        int carry=0;
        char[] a1=num1.toCharArray();
        char[] a2=num2.toCharArray();
        int i=a1.length-1;
        int j=a2.length-1;
        while(i>=0||j>=0){
            int x=carry;
            if(i>=0)    x+=a1[i]-'0';
            if(j>=0)    x+=a2[j]-'0';
            carry=x/10;
            sb.append(""+x%10);
            i--;
            j--;
        }
        if(carry==1)    sb.append(carry);
        return sb.reverse().toString();
    }
}
