/*
 * [266] Palindrome Permutation
 *
 * https://leetcode.com/problems/palindrome-permutation
 *
 * algorithms
 * Easy (57.13%)
 * Total Accepted:    35.3K
 * Total Submissions: 61.9K
 * Testcase Example:  '"aab"'
 *
 * Given a string, determine if a permutation of the string could form a
 * palindrome.
 * 
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True.
 * 
 */
// 8 bit: 2^8(256) characters
// at most one character can appear odd times, otherwise the String cannot form a palindrome
class Solution {
    public boolean canPermutePalindrome(String s) {
        boolean[] array=new boolean[256];//false at initial
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(array[c]==true)  array[c]=false;
            else                array[c]=true;
        }
        int count=0;
        for(boolean b: array){
            if(b==true)  count++;
        }
        if(count>1) return false;
        else        return true;
    }
}
