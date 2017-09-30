/*
 * [171] Excel Sheet Column Number
 *
 * https://leetcode.com/problems/excel-sheet-column-number
 *
 * algorithms
 * Easy (47.45%)
 * Total Accepted:    141.9K
 * Total Submissions: 299.1K
 * Testcase Example:  '"A"'
 *
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * 
 * For example:
 * ⁠   A -> 1
 * ⁠   B -> 2
 * ⁠   C -> 3
 * ⁠   ...
 * ⁠   Z -> 26
 * ⁠   AA -> 27
 * ⁠   AB -> 28 
 * 
 * Credits:Special thanks to @ts for adding this problem and creating all test
 * cases.
 */
class Solution {
    public int titleToNumber(String s) {
        int sum=0;
        for(int i=s.length()-1; i>=0; i--){
            char c=s.charAt(i);
            sum+=(c-64)*Math.pow(26, s.length()-1-i);
        }
        return sum;
    }
}
