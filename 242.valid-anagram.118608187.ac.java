/*
 * [242] Valid Anagram
 *
 * https://leetcode.com/problems/valid-anagram
 *
 * algorithms
 * Easy (46.62%)
 * Total Accepted:    173.5K
 * Total Submissions: 372.2K
 * Testcase Example:  '""\n""'
 *
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s. 
 * 
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * 
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your
 * solution to such case?
 */
// 8 bit, 2^8=256
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] ocurrences=new int[256];//ocurrences, 0 at initial
        for(int i=0; i<s.length(); i++) ocurrences[s.charAt(i)]++;
        for(int i=0; i<t.length(); i++){
            ocurrences[t.charAt(i)]--;
            if(ocurrences[t.charAt(i)]<0)   return false;
        }
        for(int i=0; i<ocurrences.length; i++){
            if(ocurrences[i]!=0)    return false;
        }
        return true;
    }
}
