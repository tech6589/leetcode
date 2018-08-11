/*
 * [520] Detect Capital
 *
 * https://leetcode.com/problems/detect-capital/description/
 *
 * algorithms
 * Easy (51.88%)
 * Total Accepted:    64.8K
 * Total Submissions: 124.9K
 * Testcase Example:  '"USA"'
 *
 * 
 * Given a word, you need to judge whether the usage of capitals in it is right
 * or not.
 * 
 * 
 * 
 * We define the usage of capitals in a word to be right when one of the
 * following cases holds:
 * 
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one
 * letter, like "Google".
 * 
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "USA"
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "FlaG"
 * Output: False
 * 
 * 
 * 
 * Note:
 * The input will be a non-empty word consisting of uppercase and lowercase
 * latin letters.
 * 
 */
class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length()==1)    return true;
        char[] chars=word.toCharArray();
        if(chars[0]>='a'&&chars[0]<='z'){//first letter not capital
            for(int i=1; i<chars.length; i++){
                if(chars[i]>='A'&&chars[i]<='Z')    return false;
            }
            return true;
        }else{//first letter capital
            if(chars[1]>='a'&&chars[1]<='z'){//second letter not capital
                //all following letter should be lowercase
                for(int i=2; i<chars.length; i++){
                    if(chars[i]>='A'&&chars[i]<='Z')    return false;//uppercase, against the law
                }
                return true;
            }else{//second letter capital
                //all following letter should be uppercase
                for(int i=2; i<chars.length; i++){
                    if(chars[i]>='a'&&chars[i]<='z')    return false;//lowercase, against the law
                }
                return true;
            }
        }
    }
}
