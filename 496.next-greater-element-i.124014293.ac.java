/*
 * [496] Next Greater Element I
 *
 * https://leetcode.com/problems/next-greater-element-i
 *
 * algorithms
 * Easy (56.72%)
 * Total Accepted:    39.4K
 * Total Submissions: 69.4K
 * Testcase Example:  '[4,1,2]\n[1,3,4,2]'
 *
 * 
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s
 * elements are subset of nums2. Find all the next greater numbers for nums1's
 * elements in the corresponding places of nums2. 
 * 
 * 
 * 
 * The Next Greater Number of a number x in nums1 is the first greater number
 * to its right in nums2. If it does not exist, output -1 for this number.
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 * ⁠   For number 4 in the first array, you cannot find the next greater number
 * for it in the second array, so output -1.
 * ⁠   For number 1 in the first array, the next greater number for it in the
 * second array is 3.
 * ⁠   For number 2 in the first array, there is no next greater number for it
 * in the second array, so output -1.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * ⁠   For number 2 in the first array, the next greater number for it in the
 * second array is 3.
 * ⁠   For number 4 in the first array, there is no next greater number for it
 * in the second array, so output -1.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 * 
 * 
 */
/*
 * [496] Next Greater Element I
 *
 * https://leetcode.com/problems/next-greater-element-i
 *
 * algorithms
 * Easy (56.72%)
 * Total Accepted:    39.4K
 * Total Submissions: 69.4K
 * Testcase Example:  '[4,1,2]\n[1,3,4,2]'
 *
 * 
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s
 * elements are subset of nums2. Find all the next greater numbers for nums1's
 * elements in the corresponding places of nums2. 
 * 
 * 
 * 
 * The Next Greater Number of a number x in nums1 is the first greater number
 * to its right in nums2. If it does not exist, output -1 for this number.
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 * ⁠   For number 4 in the first array, you cannot find the next greater number
 * for it in the second array, so output -1.
 * ⁠   For number 1 in the first array, the next greater number for it in the
 * second array is 3.
 * ⁠   For number 2 in the first array, there is no next greater number for it
 * in the second array, so output -1.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * ⁠   For number 2 in the first array, the next greater number for it in the
 * second array is 3.
 * ⁠   For number 4 in the first array, there is no next greater number for it
 * in the second array, so output -1.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 * 
 * 
 */
/*Better Brute Force Solution, O(m*n)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	int[] res=new int[nums1.length];
    	for(int i=0; i<res.length; i++)	res[i]=-1;
    	int max=Integer.MIN_VALUE;
    	int min=Integer.MAX_VALUE;
    	for(int num: nums2){
    		if(num>max)	max=num;
    		if(num<min)	min=num;
    	}
    	int range=max-min;
        int[] index=new int[range+1];//(num-min, index)
        for(int i=0; i<nums2.length; i++)	index[nums2[i]-min]=i;
        for(int i=0; i<nums1.length; i++){
        	for(int j=index[nums1[i]-min]+1; j<nums2.length; j++){
        		if(nums2[j]>nums1[i]){
        			res[i]=nums2[j];
        			break;
        		}
        	}
        }
        return res;
    }
}*/
// Stack Solution
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	int[] res=new int[nums1.length];
    	Stack<Integer> stack=new Stack<>();
    	int max=Integer.MIN_VALUE;
    	int min=Integer.MAX_VALUE;
    	for(int num: nums2){
    		if(num>max)	max=num;
    		if(num<min)	min=num;
    	}
    	int range=max-min;
    	int[] index=new int[range+1];// use max-min+1 to save space and deal with negative number
    	for(int i=0; i<nums2.length; i++){
    		// while the top element is bigger than nums2[i], pop and put (popNum-min, nums2[i])
			while(stack.empty()==false&&stack.peek()<nums2[i])	index[stack.pop()-min]=nums2[i];
    		stack.push(nums2[i]);
    	}
    	while(stack.empty()==false)			index[stack.pop()-min]=-1;//put (stack.pop()-min, -1)
    	for(int i=0; i<nums1.length; i++)	res[i] = index[nums1[i]-min];
    	return res;
    }
}


