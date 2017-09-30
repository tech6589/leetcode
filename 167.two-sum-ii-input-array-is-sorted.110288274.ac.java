/*
 * [167] Two Sum II - Input array is sorted
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
 *
 * algorithms
 * Easy (47.13%)
 * Total Accepted:    99.3K
 * Total Submissions: 210.7K
 * Testcase Example:  '[2,3,4]\n6'
 *
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note
 * that your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution and you may
 * not use the same element twice.
 * 
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 
 */
// Two pointers
// j goes to the last element which is the same as numbers[i]
// then assign j-1 to i
// 0 0 0 0 0 0
//         i j

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int length=numbers.length;
        while(i<length-1){
            int j=i+1;
            while(j+1<length&&numbers[j+1]==numbers[i]) j++;
            i=j-1;
            while(j<length&&numbers[i]+numbers[j]<target)    j++;
            if(j==length||numbers[i]+numbers[j]>target){//j exceeds the length or sum is bigger than target, try next i
                i++;
                continue;
            }else{//numbers[i]+numbers[j]==target
                return new int[]{i+1, j+1};
            }
        }
        return null;
    }
}
