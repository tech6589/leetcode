/*
 * [541] Reverse String II
 *
 * https://leetcode.com/problems/reverse-string-ii/description/
 *
 * algorithms
 * Easy (44.16%)
 * Total Accepted:    44.2K
 * Total Submissions: 100K
 * Testcase Example:  '"abcdefg"\n2'
 *
 * 
 * Given a string and an integer k, you need to reverse the first k characters
 * for every 2k characters counting from the start of the string. If there are
 * less than k characters left, reverse all of them. If there are less than 2k
 * but greater than or equal to k characters, then reverse the first k
 * characters and left the other as original.
 * 
 * 
 * Example:
 * 
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * 
 * 
 * 
 * Restrictions: 
 * 
 * ⁠The string consists of lower English letters only.
 * ⁠Length of the given string and k will in the range [1, 10000]
 * 
 */
class Solution {
    public String reverseStr(String s, int k) {
        char[] chars=s.toCharArray();
        for(int i=0; i<chars.length; ){
            int leftLen=chars.length-i;  
            if(leftLen>=2*k){
                reverseK(chars, i, k);
                i+=2*k;
            }else if(leftLen>=k){
                reverseK(chars, i, k);
                i=chars.length;
            }else{// <k
                reverseK(chars, i, leftLen);
                i=chars.length;
            }
        }
        return new String(chars);
    }
    private void reverseK(char[] chars, int i, int k){
        for(int j=i; j<i+k/2; j++){
            char tmp=chars[j];
            chars[j]=chars[2*i+k-j-1];
            chars[2*i+k-j-1]=tmp;
        }
    }
}
