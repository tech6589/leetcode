/*
 * [137] Single Number II
 *
 * https://leetcode.com/problems/single-number-ii/description/
 *
 * algorithms
 * Medium (43.44%)
 * Total Accepted:    141.6K
 * Total Submissions: 326K
 * Testcase Example:  '[2,2,3,2]'
 *
 * Given a non-empty array of integers, every element appears three times
 * except for one, which appears exactly once. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * 
 * Input: [2,2,3,2]
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 * 
 */
class Solution {
    public int singleNumber(int[] nums) {
        int[] map = new int[32];
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<32; j++){
                map[31-j]+=(nums[i]>>j & 1);
            }
        }
        // for(int i: map){
        //     System.out.print(i);
        // }
        int res=0;
        for(int i=0; i<32; i++){
            if(map[i]%3 == 1){
                res+=(1<<(31-i));
            }
        }
        return res;
    }
}
