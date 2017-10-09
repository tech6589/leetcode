/*
 * [408] Valid Word Abbreviation
 *
 * https://leetcode.com/problems/valid-word-abbreviation
 *
 * algorithms
 * Easy (28.10%)
 * Total Accepted:    12.3K
 * Total Submissions: 43.7K
 * Testcase Example:  '"internationalization"\n"i12iz4n"'
 *
 * 
 * Given a non-empty string s and an abbreviation abbr, return whether the
 * string matches with the given abbreviation.
 * 
 * 
 * A string such as "word" contains only the following valid abbreviations:
 * 
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d",
 * "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * 
 * 
 * Notice that only the above abbreviations are valid abbreviations of the
 * string "word". Any other string is not a valid abbreviation of "word".
 * 
 * Note:
 * Assume s contains only lowercase letters and abbr contains only lowercase
 * letters and digits.
 * 
 * 
 * Example 1:
 * 
 * Given s = "internationalization", abbr = "i12iz4n":
 * 
 * Return true.
 * 
 * 
 * 
 * Example 2:
 * 
 * Given s = "apple", abbr = "a2e":
 * 
 * Return false.
 * 
 * 
 */
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        char[] abbrArr=abbr.toCharArray();
        char[] wordArr=word.toCharArray();
        int i=0;
        int j=0;
        while(i<abbrArr.length&&j<wordArr.length){
            if(abbrArr[i]>='a'&&abbrArr[i]<='z'){
                if(abbrArr[i]!=wordArr[j])          return false; 
                i++;
                j++;
            }else{//digit
                if(abbrArr[i]=='0')                 return false;// no leading 0 for number
                int num=0;
                while(i<abbrArr.length&&abbrArr[i]<='9'&&abbrArr[i]>='0'){
                    num*=10;
                    num+=abbrArr[i]-'0';
                    i++;
                }
                j+=num;
            }
        }
        if(i!=abbrArr.length||j!=wordArr.length)    return false;
        else                                        return true;
    }
}
