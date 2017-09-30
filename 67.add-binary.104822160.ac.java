/*
 * [67] Add Binary
 *
 * https://leetcode.com/problems/add-binary
 *
 * algorithms
 * Easy (32.80%)
 * Total Accepted:    161.2K
 * Total Submissions: 491.6K
 * Testcase Example:  '"0"\n"0"'
 *
 * 
 * Given two binary strings, return their sum (also a binary string).
 * 
 * 
 * 
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * 
 */
public class Solution {
    public String addBinary(String a, String b) {
        String longer;
        String shorter;
        if(a.length()>b.length()){
            longer=a;
            shorter=b;
        }else{
            longer=b;
            shorter=a;
        }
        char[] result=new char[longer.length()+1];
        int carry=0;
        int s=shorter.length()-1;
        int l=longer.length()-1;
        int digit=0;
        while(l>=0){
            if(s>=0){
                digit=longer.charAt(l)-'0'+shorter.charAt(s)-'0'+carry;
            }else{
                digit=longer.charAt(l)-'0'+carry;
            }
            if(digit<2){
                carry=0;
                result[l+1]=(char)(digit+'0');
            }else{
                carry=1;
                result[l+1]=(char)(digit-2+'0');
            }
            s--;
            l--;
        }
        if(carry==1){
            result[0]='1';
            return new String(result);
        }else{
            return new String(result, 1, result.length-1);
        }
    }
}
