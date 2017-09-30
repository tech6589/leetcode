/*
 * [9] Palindrome Number
 *
 * https://leetcode.com/problems/palindrome-number
 *
 * algorithms
 * Easy (35.46%)
 * Total Accepted:    250K
 * Total Submissions: 705K
 * Testcase Example:  '-2147483648'
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * click to show spoilers.
 * 
 * Some hints:
 * 
 * Could negative integers be palindromes? (ie, -1)
 * 
 * If you are thinking of converting the integer to string, note the
 * restriction of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the
 * problem "Reverse Integer", you know that the reversed integer might
 * overflow. How would you handle such case?
 * 
 * There is a more generic way of solving this problem.
 * 
 * 
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int length=String.valueOf(x).length();
        int originalLength=length;
        int i=10;
        while(length>(originalLength/2)){
            if(((x%i)/(i/10))!=((x/(int)Math.pow(10, length-1))%10)){
                //System.out.println(Math.pow(10, length-1));
                System.out.println("x: "+x+", i: "+i+", length"+length);
                return false;
            }
            i*=10;
            length--;
        }
        return true;
        
    }
}
