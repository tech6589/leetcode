/*
 * [290] Word Pattern
 *
 * https://leetcode.com/problems/word-pattern
 *
 * algorithms
 * Easy (33.14%)
 * Total Accepted:    86.2K
 * Total Submissions: 260K
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 * ⁠Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 * 
 * Examples:
 * 
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * 
 * 
 * 
 * 
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains
 * lowercase letters separated by a single space.
 * 
 * 
 * Credits:Special thanks to @minglotus6 for adding this problem and creating
 * all test cases.
 */
// 8 bit, 2^8=256
class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<String, Integer> strMap=new HashMap<>();//(String, index+1)
        int[] ptArray=new int[256];//(char, index+1), use index+1 to avoid index 0 because each slot in the array is 0 at initial
        String[] strs=str.split(" ");
        if(strs.length!=pattern.length())       return false;
        for(int i=0; i<strs.length; i++){
            int c=pattern.charAt(i);
            String s=strs[i];
            //set if 0 or null
            if(ptArray[c]==0)                   ptArray[c]=i+1;
            if(strMap.containsKey(s)==false)    strMap.put(s, i+1);
            //compare
            if(ptArray[c]!=strMap.get(s))       return false;
        }
        return true;
    }
}
