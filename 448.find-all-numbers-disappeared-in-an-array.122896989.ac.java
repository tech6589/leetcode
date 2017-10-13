/*
 * [448] Find All Numbers Disappeared in an Array
 *
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array
 *
 * algorithms
 * Easy (51.22%)
 * Total Accepted:    62.4K
 * Total Submissions: 121.8K
 * Testcase Example:  '[4,3,2,7,8,2,3,1]'
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 * 
 * Example:
 * 
 * Input:
 * [4,3,2,7,8,2,3,1]
 * 
 * Output:
 * [5,6]
 * 
 * 
 */
// Mark negative solution, if not marked, then no this index as number
// Use negative so that I can still use the number even it has been marked
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            //System.out.println(i+" "+nums[i]+" "+(nums[i]-1));
            int index=Math.abs(nums[i])-1;
            nums[index]=-Math.abs(nums[index]);
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0)   res.add(i+1);
        }
        return res;
    }
}
