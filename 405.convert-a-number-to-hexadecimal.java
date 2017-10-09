/*
 * [405] Convert a Number to Hexadecimal
 *
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal
 *
 * algorithms
 * Easy (41.06%)
 * Total Accepted:    27.4K
 * Total Submissions: 66.7K
 * Testcase Example:  '26'
 *
 * 
 * Given an integer, write an algorithm to convert it to hexadecimal. For
 * negative integer, two’s complement method is used.
 * 
 * 
 * Note:
 * 
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is
 * zero, it is represented by a single zero character '0'; otherwise, the first
 * character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed
 * integer.
 * You must not use any method provided by the library which converts/formats
 * the number to hex directly.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * 26
 * 
 * Output:
 * "1a"
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * -1
 * 
 * Output:
 * "ffffffff"
 * 
 * 
 */
class Solution {
    public String toHex(int num) {
        if(num==0)          return "0";
        boolean             isNeg=false;
        if(num<0)           isNeg=true;
        if(isNeg==true)     num=num+(1<<31);
        StringBuilder sb=new StringBuilder();
        while(num>0){
        	sb.append(oneToHex(num%16));
        	num/=16;
        }
        // append sign bit for negative number
        if(isNeg==true){
            int len=sb.length();
            if(len<8){// append 0 until the last one
                for(int i=0; i<8-len-1; i++){
                    sb.append("0");
                }
                sb.append("8");
            }else{
                sb.setCharAt(7, oneToHex(sb.charAt(7)-'0'+8));//plus 8
            }
        }
        sb.reverse();
        return sb.toString();
    }
    private char oneToHex(int n){
    	if(n>=0&&n<=9){
    		return (char)(n+'0');
    	}else if(n>=10&&n<=15){
    		return (char)(n+('a'-10));
    	}
    	return 'g';
    }
}
