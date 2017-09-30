/*
 * [220] Contains Duplicate III
 *
 * https://leetcode.com/problems/contains-duplicate-iii
 *
 * algorithms
 * Medium (19.06%)
 * Total Accepted:    58.1K
 * Total Submissions: 304.6K
 * Testcase Example:  '[]\n0\n0'
 *
 * 
 * Given an array of integers, find out whether there are two distinct indices
 * i and j in the array such that the absolute difference between nums[i] and
 * nums[j] is at most t and the absolute difference between i and j is at most
 * k.
 * 
 */
import java.util.SortedSet;
import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0; i<nums.length; i++){
            if(i-k-1>=0)    set.remove(nums[i-k-1]);
            // the one that is just bigger than nums[i]
            if(set.ceiling(nums[i])!=null&&set.ceiling(nums[i])<=(long)nums[i]+t) return true;
            //the one that is just smaller than nums[i]
            if(set.floor(nums[i])!=null&&set.floor(nums[i])>=(long)nums[i]-t)     return true;
            set.add(nums[i]);
        }
        return false;
    }
}
