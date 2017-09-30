/*
 * [88] Merge Sorted Array
 *
 * https://leetcode.com/problems/merge-sorted-array
 *
 * algorithms
 * Easy (32.09%)
 * Total Accepted:    184.9K
 * Total Submissions: 576.1K
 * Testcase Example:  '[1]\n1\n[]\n0'
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * 
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to
 * m + n) to hold additional elements from nums2. The number of elements
 * initialized in nums1 and nums2 are m and n respectively.
 */
public class Solution {
    // From the end to the beginning
    // Three pointers problem
    // p is the current position to place either number from array 1 or 2
    // l and r are pointers pointing to nums1 and nums2 respectively
    // num1[l] and nums2[r] are competing for being placed in p
    // The larger one will be placed in p
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p=m+n-1;
        int l=m-1;
        int r=n-1;
        while((r>=0)&&(l>=0)){
            if(nums1[l]>=nums2[r]){
                nums1[p]=nums1[l];
                l--;
                p--;
            }else{
                nums1[p]=nums2[r];
                r--;
                p--;
            }
        }
        if(r<0){
            while(l>=0){
                nums1[p]=nums1[l];
                l--;
                p--;
            }
        }
        if(l<0){
            while(r>=0){
                nums1[p]=nums2[r];
                r--;
                p--;
            }
            
        }
    
    }
}
