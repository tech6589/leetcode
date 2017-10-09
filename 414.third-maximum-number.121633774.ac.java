/*
 * [414] Third Maximum Number
 *
 * https://leetcode.com/problems/third-maximum-number
 *
 * algorithms
 * Easy (27.89%)
 * Total Accepted:    45.2K
 * Total Submissions: 162.1K
 * Testcase Example:  '[3,2,1]'
 *
 * Given a non-empty array of integers, return the third maximum number in this
 * array. If it does not exist, return the maximum number. The time complexity
 * must be in O(n).
 * 
 * Example 1:
 * 
 * Input: [3, 2, 1]
 * 
 * Output: 1
 * 
 * Explanation: The third maximum is 1.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [1, 2]
 * 
 * Output: 2
 * 
 * Explanation: The third maximum does not exist, so the maximum (2) is
 * returned instead.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: [2, 2, 3, 1]
 * 
 * Output: 1
 * 
 * Explanation: Note that the third maximum here means the third maximum
 * distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 * 
 * 
 */
/* Original Solution
class Solution {
    public int thirdMax(int[] nums) {
        int len=nums.length;
        int max=nums[0];
        for(int i=0; i<len; i++){
            if(nums[i]>max)                                         max=nums[i];
        }
        int secondMax=Integer.MIN_VALUE;
        for(int i=0; i<len; i++){
            if(nums[i]>secondMax&&nums[i]!=max)                     secondMax=nums[i];
        }
        int thirdMax=Integer.MIN_VALUE;
        boolean hasMin=false;
        for(int i=0; i<len; i++){
            if(nums[i]>thirdMax&&nums[i]!=max&&nums[i]!=secondMax)  thirdMax=nums[i];
            if(nums[i]==Integer.MIN_VALUE)  hasMin=true;
        }
        if(thirdMax!=Integer.MIN_VALUE){
            return thirdMax;
        }else{
            if(hasMin==true&&secondMax!=Integer.MIN_VALUE)  return thirdMax;
            else                                            return max;
        }
        
    }
}*/
class Solution {
    public int thirdMax(int[] nums) {
        long max=Long.MIN_VALUE;
        long max2=Long.MIN_VALUE;
        long max3=Long.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>max){
                max3=max2;
                max2=max;
                max=nums[i];
            }else if(nums[i]<max&&nums[i]>max2){
                max3=max2;
                max2=nums[i];
            }else if(nums[i]<max2&&nums[i]>max3){
                max3=nums[i];
            }
        }
        if(max3==Long.MIN_VALUE)    return (int)max;
        else                        return (int)max3;
        
    }
}
