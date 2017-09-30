/*
 * [400] Nth Digit
 *
 * https://leetcode.com/problems/nth-digit
 *
 * algorithms
 * Easy (30.04%)
 * Total Accepted:    26.9K
 * Total Submissions: 89.6K
 * Testcase Example:  '3'
 *
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8,
 * 9, 10, 11, ... 
 * 
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n <
 * 231).
 * 
 * 
 * Example 1:
 * 
 * Input:
 * 3
 * 
 * Output:
 * 3
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * 11
 * 
 * Output:
 * 0
 * 
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a
 * 0, which is part of the number 10.
 * 
 * 
 */
class Solution {
    public int findNthDigit(int n) {
        if(n<10)    return n;
        int f;
        int squareOfTen=1;
        for(f=1; f<=9&&n-9.0*f*squareOfTen>0; f++){
            n-=9*f*squareOfTen;
            squareOfTen*=10;
        }
        int startNum=squareOfTen;
        n--;// the n-1 th digit from the left number
        int number=startNum+n/f;
        int z=n%f;
        return (""+number).charAt(z)-'0';
    }
}
