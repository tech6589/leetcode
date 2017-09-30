/*
 * [58] Length of Last Word
 *
 * https://leetcode.com/problems/length-of-last-word
 *
 * algorithms
 * Easy (31.91%)
 * Total Accepted:    159.9K
 * Total Submissions: 501K
 * Testcase Example:  '""'
 *
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * 
 * For example, 
 * Given s = "Hello World",
 * return 5.
 * 
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        
        String[] strings=s.split(" ");
        if(strings.length<1){
            return 0;
        }else{
            return strings[strings.length-1].length();
        }
    }
}
