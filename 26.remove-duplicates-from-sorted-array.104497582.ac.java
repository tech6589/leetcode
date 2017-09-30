/*
 * [26] Remove Duplicates from Sorted Array
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array
 *
 * algorithms
 * Easy (35.42%)
 * Total Accepted:    265K
 * Total Submissions: 748.2K
 * Testcase Example:  '[]'
 *
 * 
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * 
 * Do not allocate extra space for another array, you must do this in place
 * with constant memory.
 * 
 * 
 * 
 * For example,
 * Given input array nums = [1,1,2],
 * 
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively. It doesn't matter what you leave beyond the new
 * length.
 * 
 */
public class Solution {
    //Because the inputed array is sorted array
    //The problem equals removing adjacent duplicates
    //pointer i and j, i is slow while j is fast
    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=1;
        for(; j<nums.length; i++){
            //System.out.println("i: "+i+", j: "+j);
            while((j<nums.length)&&(nums[i]==nums[j])){
                j++;
            }
            if(j>=nums.length){
                return i+1;
            }
            nums[i+1]=nums[j];
        }
        return i+2;
    }
}
