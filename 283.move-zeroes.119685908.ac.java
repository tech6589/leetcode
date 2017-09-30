/*
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes
 *
 * algorithms
 * Easy (50.26%)
 * Total Accepted:    216.8K
 * Total Submissions: 431.3K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * 
 * 
 * For example, given nums  = [0, 1, 0, 3, 12], after calling your function,
 * nums should be [1, 3, 12, 0, 0].
 * 
 * 
 * 
 * Note:
 * 
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
// two pointers solution, i scan until a 0, j scan until a non-zero, then swap i and j.
// note that j must be to the right of i
class Solution {
    public void moveZeroes(int[] nums) {
        int len=nums.length;
        for(int i=0, j=0; j<len; ){
            while(nums[i]!=0){
                i++;
                if(i>=len)  return;
            }
            j=i;// j is 0 now, don't use j=i+1 to avoid array outbound error
            while(nums[j]==0){
                j++;
                if(j>=len)  return;
            }
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;   
        }
    }
}
