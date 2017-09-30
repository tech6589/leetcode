/*
 * [189] Rotate Array
 *
 * https://leetcode.com/problems/rotate-array
 *
 * algorithms
 * Easy (24.78%)
 * Total Accepted:    141.7K
 * Total Submissions: 572K
 * Testcase Example:  '[1]\n0'
 *
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4]. 
 * 
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem.
 * 
 * 
 * [show hint]
 * Hint:
 * Could you do it in-place with O(1) extra space?
 * 
 * 
 * Related problem: Reverse Words in a String II
 * 
 * Credits:Special thanks to @Freezen for adding this problem and creating all
 * test cases.
 */
/* Extra Array
class Solution {
    public void rotate(int[] nums, int k) {
        int length=nums.length;
        int[] numsCopy=new int[length];
        for(int i=0; i<length; i++){
            numsCopy[i]=nums[i];
        }
        for(int i=0; i<length; i++){
            nums[(i+k)%length]=numsCopy[i];
        }
        
    }
}
*/
// Wheel disc method(Cylic Replacement)
// Special case: 123 3, which is that k can be divided by nums.length
class Solution {
    public void rotate(int[] nums, int k) {
        if(k==0)    return;
        int len=nums.length;
        int i=0;
        while(len>0){
            int index=i;
            int n=nums[index];
            do{
                int tmp=nums[(index+k)%nums.length];
                nums[(index+k)%nums.length]=n;
                n=tmp;
                index=(index+k)%nums.length;
                len--;
            }while(index!=i);
            i++;
        }
    }
}
