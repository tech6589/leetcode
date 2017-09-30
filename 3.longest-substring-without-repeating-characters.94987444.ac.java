/*
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 *
 * algorithms
 * Medium (24.41%)
 * Total Accepted:    355.2K
 * Total Submissions: 1.5M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int leftIndex=0;//if it occurs repeating character in [leftIndex,rightIndex) for current character, jump to previous repeating character+1. Otherwise keep still.
        int rightIndex=0;//scan the string
        int maxLength=0;
        while(rightIndex<s.length()){
            int previousIndex=previousPosition(s.charAt(rightIndex), s, leftIndex, rightIndex);//character before leftIndex is lefted out
            if(previousIndex!=-1)//character in rightIndex has repeating character before
                leftIndex=1+previousIndex;
            int curLength=rightIndex-leftIndex+1;
            if(curLength>maxLength)
                maxLength=curLength;
            rightIndex++;
        }
        return maxLength;
    }
    public int previousPosition(char c, String s, int beginIndex, int endIndex){//beginIndex is inclusive, endIndex is exclusive
        for(int i=endIndex-1; i>=beginIndex; i--){
            if(c==s.charAt(i))
                return i;//returns the position of previous repeating character
        }
        return -1;//-1 means no repeating character before
    }
}
