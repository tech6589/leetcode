/*
 * [485] Max Consecutive Ones
 *
 * https://leetcode.com/problems/max-consecutive-ones
 *
 * algorithms
 * Easy (53.97%)
 * Total Accepted:    58.7K
 * Total Submissions: 108.8K
 * Testcase Example:  '[1,0,1,1,0,1]'
 *
 * Given a binary array, find the maximum number of consecutive 1s in this
 * array.
 * 
 * Example 1:
 * 
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive
 * 1s.
 * ⁠   The maximum number of consecutive 1s is 3.
 * 
 * 
 * 
 * Note:
 * 
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * 
 * 
 */
/*Two pointers Solution
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l=0;
        int r=0;
        int max=0;
        while(r<nums.length){
            while(l<nums.length&&nums[l]==0)   l++;
            r=l;
            while(r<nums.length&&nums[r]==1)    r++;
            int dis=r-l;
            if(dis>max)             max=dis;
            l=r;
        }
        return max;
    }
}
*/
//consecutives solution
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int consecutives=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                consecutives=0;
            }else{
                consecutives++;
                if(consecutives>max)    max=consecutives;
            }
        }
        return max;
        
    }
}
