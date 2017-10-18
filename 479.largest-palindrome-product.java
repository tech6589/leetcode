/*
 * [479] Largest Palindrome Product
 *
 * https://leetcode.com/problems/largest-palindrome-product
 *
 * algorithms
 * Easy (23.65%)
 * Total Accepted:    6.1K
 * Total Submissions: 25.9K
 * Testcase Example:  '1'
 *
 * Find the largest palindrome made from the product of two n-digit numbers.
 * ⁠Since the result could be very large, you should return the largest
 * palindrome mod 1337.
 * 
 * Example:
 * Input: 2
 * Output: 987
 * Explanation: 99 x 91 = 9009, 9009 % 1337 = 987
 * 
 * 
 * 
 * 
 * Note:
 * The range of n is [1,8].
 * 
 * 
 */
// Create Descending Palindrome Solution
class Solution {
    public int largestPalindrome(int n) {
    	if(n==1)	return 9;
        long end=(long)Math.pow(10, n)-1;
        long start=(end+1)/10;
        for(long i=end; i>=start; i--){// use i to create palindrome
        	long palindrome=Long.valueOf(i+new StringBuilder().append(i).reverse().toString());
        	// use j to verify if the palindrome is the product of two n digit number
        	for(long j=end; j*j>=palindrome&&j>=start; j--){// if j*j<palindrome, then I cann't find two n digit number whose product is palindrome because another num must be smaller than j otherwise it appears before j and of course fails
        		if(palindrome%j==0)	return (int)(palindrome%1337);
        	}
        }
        return 0;
    }
   
}
