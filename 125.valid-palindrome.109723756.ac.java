/*
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome
 *
 * algorithms
 * Easy (26.40%)
 * Total Accepted:    179.5K
 * Total Submissions: 680K
 * Testcase Example:  '""'
 *
 * 
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * 
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * 
 * 
 * Note:
 * Have you consider that the string might be empty? This is a good question to
 * ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 */
//Two pointers
//Skip char if it's not alphanumeric
//Compare char at i and j ignoring case

public class Solution {
    public boolean isPalindrome(String s) {
        int length=s.length();
        int i=0;
        int j=length-1;
        while(i<j){
            while(i<j&&Character.isLetterOrDigit(s.charAt(i))==false)    i++;
            if(i>=j)    return true;
            while(i<j&&Character.isLetterOrDigit(s.charAt(j))==false)    j--;
            if(i==j)   return true; 
            if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j)))  return false;
            i++;
            j--;
        }
        return true;
    }
}
