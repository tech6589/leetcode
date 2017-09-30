/*
 * [66] Plus One
 *
 * https://leetcode.com/problems/plus-one
 *
 * algorithms
 * Easy (38.83%)
 * Total Accepted:    189.7K
 * Total Submissions: 488.7K
 * Testcase Example:  '[0]'
 *
 * Given a non-negative integer represented as a non-empty array of digits,
 * plus one to the integer.
 * 
 * You may assume the integer do not contain any leading zero, except the
 * number 0 itself.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry=0;
        for(int i=digits.length-1; i>=0; i--){
            int digit=digits[i]+carry;
            if(i==digits.length-1){
                digit++;
            }
            if(digit>9){
                carry=1;
                digits[i]=digit-10;
            }else{
                carry=0;
                digits[i]=digit;
            }
        }
        if(carry==1){
            int[] longerArray=new int[digits.length+1];
            longerArray[0]=1;
            System.arraycopy(digits, 0, longerArray, 1, digits.length);
            return longerArray;
        }else{
            return digits;
        }
    }
}
