/*
 * [219] Contains Duplicate II
 *
 * https://leetcode.com/problems/contains-duplicate-ii
 *
 * algorithms
 * Easy (32.50%)
 * Total Accepted:    121.7K
 * Total Submissions: 374.4K
 * Testcase Example:  '[]\n0'
 *
 * 
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 * 
 */
/* Only adjacent index sharing the same number have more possibility to satisfy k contraint.
// New index will replace old index if |old-new<=k| can not be satisfied.
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();//(number, index)
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                if(Math.abs(map.get(nums[i])-i)<=k) return true;
                else                                map.put(nums[i], i);
            }else{
                map.put(nums[i], i);
            }
        }
        return false;
    }
}*/
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(i-k-1>=0)    set.remove(nums[i-k-1]);
            if(set.contains(nums[i])==true) return true;
            set.add(nums[i]);
        }
        return false;
        
    }
}
