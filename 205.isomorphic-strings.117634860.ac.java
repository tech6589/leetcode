/*
 * [205] Isomorphic Strings
 *
 * https://leetcode.com/problems/isomorphic-strings
 *
 * algorithms
 * Easy (34.00%)
 * Total Accepted:    114.7K
 * Total Submissions: 337.4K
 * Testcase Example:  '"egg"\n"add"'
 *
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * For example,
 * Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * Note:
 * You may assume both s and t have the same length.
 */
/* Map solution
import java.util.Map;
import java.util.HashMap;
class Solution {
    public boolean isIsomorphic(String s, String t) {
        return encode(s).equals(encode(t));
    }
    private String encode(String s){
        Map<Character, Integer> map=new HashMap<>();
        int code=0;
        StringBuilder codes=new StringBuilder();
        for(char c: s.toCharArray()){
            if(map.containsKey(c)==true){
                codes.append(map.get(c));
            }else{
                codes.append(code);
                map.put(c, code);
                code++;
            }
        }
        return codes.toString();
    }
}*/
// Use char array instead of map, since fixed-width ascii uses 8 bit, so I use 2^8 characters 
class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] chars=new char[516];
        for(int i=0; i<s.length(); i++){
            if(chars[s.charAt(i)]!=chars[t.charAt(i)+256])  return false;
            chars[s.charAt(i)]=chars[t.charAt(i)+256]=(char)(i+1);// can not start at 0 because '\u0000' (or 0) is the default value for char
        }
        return true;
    }

}
