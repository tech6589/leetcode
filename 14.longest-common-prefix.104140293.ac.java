/*
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix
 *
 * algorithms
 * Easy (31.48%)
 * Total Accepted:    206K
 * Total Submissions: 654.3K
 * Testcase Example:  '[]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }else if(strs.length==1){
            return strs[0];
        }else{//strs.length>=2
            StringBuilder result=new StringBuilder();
            for(int i=0; i<strs[0].length(); i++){
                char c=strs[0].charAt(i);
                for(int j=1; j<strs.length; j++){
                    if((i>=strs[j].length()) || (c!=strs[j].charAt(i))){
                        return result.toString();
                    }
                }
                result.append(c);
            }
            return result.toString();
        }
    }
}
