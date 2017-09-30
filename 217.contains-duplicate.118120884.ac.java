/*
 * [217] Contains Duplicate
 *
 * https://leetcode.com/problems/contains-duplicate
 *
 * algorithms
 * Easy (45.97%)
 * Total Accepted:    175.4K
 * Total Submissions: 381.6K
 * Testcase Example:  '[]'
 *
 * 
 * Given an array of integers, find if the array contains any duplicates. Your
 * function should return true if any value appears at least twice in the
 * array, and it should return false if every element is distinct.
 * 
 */
// Set Solution
import java.util.Set;
import java.util.HashSet;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i]))   return true;
            else set.add(nums[i]);
        }
        return false;
    }
}
// Array Solution, range: from 0 to Integer.MAX_VALUE
// (number, sign)
// sign bit: 0 is positive or 0, 1 is negative
// [0][0] is 0, [0][1] is Integer.MIN_VALUE
//Memory Limit Exceeded
/*
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Boolean[][] occurrence=new Boolean[Integer.MAX_VALUE][2];// all false at initial
        for(int i=0; i<nums.length; i++){
            Boolean occu=null;
            if(nums[i]>=0)                      occu=occurrence[nums[i]][0];
            else if(nums[i]==Integer.MIN_VALUE) occu=occurrence[0][1];
            else                                occu=occurrence[nums[i]][1];
            if(occu==true)  return true;
            else            occu=true;
        }
        return false;
    }
}*/
