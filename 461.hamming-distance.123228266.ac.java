/*
 * [461] Hamming Distance
 *
 * https://leetcode.com/problems/hamming-distance
 *
 * algorithms
 * Easy (69.96%)
 * Total Accepted:    102.5K
 * Total Submissions: 146.5K
 * Testcase Example:  '1\n4'
 *
 * The Hamming distance between two integers is the number of positions at
 * which the corresponding bits are different.
 * 
 * Given two integers x and y, calculate the Hamming distance.
 * 
 * Note:
 * 0 ≤ x, y < 231.
 * 
 * 
 * Example:
 * 
 * Input: x = 1, y = 4
 * 
 * Output: 2
 * 
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ⁠      ↑   ↑
 * 
 * The above arrows point to positions where the corresponding bits are
 * different.
 * 
 * 
 */
class Solution {
    public int hammingDistance(int x, int y) {
        // xor to get different bits
        int z=x^y;
        // calculate how many 1s in z
        int sum=0;
        while(z>0){
            sum+=(z&1);
            z=z>>>1;
        }
        return sum;
    }
}
