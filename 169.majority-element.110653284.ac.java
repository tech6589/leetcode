/*
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element
 *
 * algorithms
 * Easy (46.90%)
 * Total Accepted:    215.7K
 * Total Submissions: 460K
 * Testcase Example:  '[1]'
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Credits:Special thanks to @ts for adding this problem and creating all test
 * cases.
 */
//Majority Vote Algorithm
//http://www.cs.utexas.edu/~moore/best-ideas/mjrty/
public class Solution {
    public int majorityElement(int[] nums) {
        int counter=0;
        int candidate=nums[0];
        for(int num:nums){
            if(counter==0){
                candidate=num;
                counter=1;
            }else{
                if(candidate==num)  counter++;
                else                counter--;
            }
        }
        return candidate;
    }
}

