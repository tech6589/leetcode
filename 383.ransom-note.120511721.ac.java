/*
 * [383] Ransom Note
 *
 * https://leetcode.com/problems/ransom-note
 *
 * algorithms
 * Easy (47.25%)
 * Total Accepted:    63.1K
 * Total Submissions: 133.5K
 * Testcase Example:  '"a"\n"b"'
 *
 * 
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the
 * ransom 
 * note can be constructed from the magazines ; otherwise, it will return
 * false. 
 * 
 * 
 * Each letter in the magazine string can only be used once in your ransom
 * note.
 * 
 * 
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * 
 * 
 * 
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 * 
 */
// 2^8=256 characters
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr=new int[256];
        // supply
        for(int i=0; i<magazine.length(); i++)  arr[magazine.charAt(i)]++;
        // consume
        for(int i=0; i<ransomNote.length(); i++){
            arr[ransomNote.charAt(i)]--;
            if(arr[ransomNote.charAt(i)]<0)     return false;
        }
        return true;
    }
}
