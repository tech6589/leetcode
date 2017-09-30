/*
 * [168] Excel Sheet Column Title
 *
 * https://leetcode.com/problems/excel-sheet-column-title
 *
 * algorithms
 * Easy (26.31%)
 * Total Accepted:    113.4K
 * Total Submissions: 431.1K
 * Testcase Example:  '1'
 *
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * ⁠   1 -> A
 * ⁠   2 -> B
 * ⁠   3 -> C
 * ⁠   ...
 * ⁠   26 -> Z
 * ⁠   27 -> AA
 * ⁠   28 -> AB 
 * 
 * Credits:Special thanks to @ifanchu for adding this problem and creating all
 * test cases.
 */
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder result=new StringBuilder();
        while(n>0){
            n--;
            int remainder=n%26;
            result.insert(0, (char)(remainder+65));// insert means insert at index 0 with this char `remainder+65`, moving other elements right.
            n/=26;
        }
        return result.toString();
    }
}
