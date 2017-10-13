/*
 * [459] Repeated Substring Pattern
 *
 * https://leetcode.com/problems/repeated-substring-pattern
 *
 * algorithms
 * Easy (38.07%)
 * Total Accepted:    39.6K
 * Total Submissions: 104K
 * Testcase Example:  '"abab"'
 *
 * Given a non-empty string check if it can be constructed by taking a
 * substring of it and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only
 * and its length  will not exceed 10000. 
 * 
 * Example 1:
 * 
 * Input: "abab"
 * 
 * Output: True
 * 
 * Explanation: It's the substring "ab" twice.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "aba"
 * 
 * Output: False
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: "abcabcabcabc"
 * 
 * Output: True
 * 
 * Explanation: It's the substring "abc" four times. (And the substring
 * "abcabc" twice.)
 * 
 * 
 */
// Two pointers solution
/*
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        char[] arr=s.toCharArray();
        int l=0;
        int r=1;
        boolean isComparing=false;
        int length=0;
        int last=0;
        while(r<arr.length){
            if(arr[l]==arr[r]){
                if(isComparing==false){
                    isComparing=true;
                    length=r-l;
                }else{// isComparing==true
                    if(arr[r]==arr[0])  last=r;
                }
                l++;
                r++;
            }else{//!=
                if(isComparing==true){
                    l=0;// back to 0
                    r=(last==0? r: last);// back to last if last exists
                    last=0;//empty last
                    isComparing=false;
                    length=0;
                }else{
                    r++;
                }
            }
        }
        if(length==0)           return false;
        else if(l%length==0)    return true;
        else                    return false;
    }
}*/
// KMP silution
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        char[] chars=s.toCharArray();
        int len=chars.length;
        int[] arr = createArray(chars);
        return arr[len-1]!=0 && len%(len-arr[len-1])==0;//check len==n*pattern_len(pattern repeats n times)
    }
    private int[] createArray(char[] chars){
        int[] arr=new int[chars.length];
        int l=0;
        int r=1;
        arr[0]=0;
        while(r<chars.length){
            if(chars[l]==chars[r]){
                arr[r]=l+1;
                l++;
                r++;
            }else{
                if(l==0){
                    arr[r]=0;
                    r++;
                }else{
                    l=arr[l-1];
                }
            }
        }
        return arr;
    }
}
