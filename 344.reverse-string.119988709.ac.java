/*
 * [344] Reverse String
 *
 * https://leetcode.com/problems/reverse-string
 *
 * algorithms
 * Easy (59.38%)
 * Total Accepted:    182.4K
 * Total Submissions: 307.1K
 * Testcase Example:  '"hello"'
 *
 * Write a function that takes a string as input and returns the string
 * reversed.
 * 
 * 
 * Example:
 * Given s = "hello", return "olleh".
 * 
 */
class Solution {
    public String reverseString(String s) {
        char[] array = s.toCharArray();
        for(int i=0; i<array.length-i-1; i++){
            char tmp=array[i];
            array[i]=array[array.length-i-1];
            array[array.length-i-1]=tmp;
        }
        return new String(array);
    }
}
