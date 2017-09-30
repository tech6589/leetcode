/*
 * [27] Remove Element
 *
 * https://leetcode.com/problems/remove-element
 *
 * algorithms
 * Easy (39.41%)
 * Total Accepted:    223.8K
 * Total Submissions: 567.7K
 * Testcase Example:  '[3,2,2,3]\n3'
 *
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * 
 * Do not allocate extra space for another array, you must do this in place
 * with constant memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave
 * beyond the new length.
 * 
 * 
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * 
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 2.
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0; 
        int j=nums.length-1;
        for(; i<=j; i++){
            //System.out.println(i);
            while((i<=j)&&(nums[j]==val)){
                //System.out.println(j);
                j--;
            }
            if(i>j){
                //System.out.println("i: "+i+", j: "+j);
                return j+1;
            }
            if(nums[i]==val){
                swap(nums, i, j);
            }
        }
        return j+1;
    }
    private void swap(int[] nums, int i, int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
