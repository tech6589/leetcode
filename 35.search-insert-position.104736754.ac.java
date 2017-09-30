/*
 * [35] Search Insert Position
 *
 * https://leetcode.com/problems/search-insert-position
 *
 * algorithms
 * Easy (39.81%)
 * Total Accepted:    200.8K
 * Total Submissions: 504.4K
 * Testcase Example:  '[1]\n0'
 *
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * 
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        return bisearch(nums, 0, nums.length, target);
    }
    private int bisearch(int[] nums, int low, int high, int target){//low is inclusive, high is exclusive
        if((high-low)<=1){
            if(target==nums[low]){
                return low;
            }else if(target>nums[low]){
                return low+1;
            }else{
                return low;
            }
        }else{
            int medium=(low+high)/2;
            if(target==nums[medium]){
                return medium;
            }else if(target>nums[medium]){
                return bisearch(nums, medium, high, target);
            }else{
                return bisearch(nums, low, medium, target);
            }
        }
    }
}
