/*
 * [434] Number of Segments in a String
 *
 * https://leetcode.com/problems/number-of-segments-in-a-string
 *
 * algorithms
 * Easy (36.61%)
 * Total Accepted:    28.9K
 * Total Submissions: 79.1K
 * Testcase Example:  '"Hello, my name is John"'
 *
 * Count the number of segments in a string, where a segment is defined to be a
 * contiguous sequence of non-space characters.
 * 
 * Please note that the string does not contain any non-printable characters.
 * 
 * Example:
 * 
 * Input: "Hello, my name is John"
 * Output: 5
 * 
 * 
 */
class Solution {
    public int countSegments(String s) {
        char[] arr=s.toCharArray();
        int i=0;
        int count=0;
        while(i<arr.length){
            while(i<arr.length&&arr[i]==' ')  i++;
            boolean isSeg=false;
            while(i<arr.length&&arr[i]!=' '){
                isSeg=true;
                i++;
            }
            if(isSeg==true) count++;
        }
        return count;
    }
}
