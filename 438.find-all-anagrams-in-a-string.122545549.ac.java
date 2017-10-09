/*
 * [438] Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string
 *
 * algorithms
 * Easy (33.75%)
 * Total Accepted:    43.7K
 * Total Submissions: 129.3K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input:
 * s: "cbaebabacd" p: "abc"
 * 
 * Output:
 * [0, 6]
 * 
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of
 * "abc".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s: "abab" p: "ab"
 * 
 * Output:
 * [0, 1, 2]
 * 
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 
 */
//Window sliding algorithm
//length==3, l is inclusive while r is exclusive
//a b c r s d f g s
//l     r
//http://www.geeksforgeeks.org/window-sliding-technique/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        char[] sChar=s.toCharArray();
        char[] pChar=p.toCharArray();
        int l=0;
        int r=0;
        int[] arr=new int[26];
        for(int i=0; i<pChar.length; i++)   arr[pChar[i]-'a']++;
        while(r<sChar.length){// l inclusive, r exclusive
            arr[sChar[r]-'a']--;  
            r++;
            if(r>pChar.length-1){
                boolean isAna=true;
                for(int i=0; i<arr.length; i++){
                    if(arr[i]!=0){
                        isAna=false;
                        break;
                    }
                }
                if(isAna==true) res.add(l);    
                arr[sChar[l]-'a']++;
                l++;
            }           
        }
        return res;
    }
}
