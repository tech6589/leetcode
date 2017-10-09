/*
 * [409] Longest Palindrome
 *
 * https://leetcode.com/problems/longest-palindrome
 *
 * algorithms
 * Easy (45.46%)
 * Total Accepted:    50.1K
 * Total Submissions: 110.1K
 * Testcase Example:  '"abccccdd"'
 *
 * Given a string which consists of lowercase or uppercase letters, find the
 * length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome
 * here.
 * 
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * 
 * 
 * Example: 
 * 
 * Input:
 * "abccccdd"
 * 
 * Output:
 * 7
 * 
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * 
 * 
 */
class Solution {
    public int longestPalindrome(String s) {
        int[] arr=new int[58];
        char[] chars=s.toCharArray();
        for(int i=0; i<chars.length; i++){
            arr[chars[i]-'A']++;
        }
        int res=0;
        boolean isSingle=false;
        for(int i=0; i<arr.length; i++){
            if(arr[i]%2==0){//even
                res+=arr[i];
            }else{
                res+=arr[i]-1;
                isSingle=true;
            }
        }
        if(isSingle==true)  res++;
        return res;
    }
}
