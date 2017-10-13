/*
 * [453] Minimum Moves to Equal Array Elements
 *
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements
 *
 * algorithms
 * Easy (47.49%)
 * Total Accepted:    32.6K
 * Total Submissions: 68.6K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty integer array of size n, find the minimum number of moves
 * required to make all array elements equal, where a move is incrementing n -
 * 1 elements by 1.
 * 
 * Example:
 * 
 * Input:
 * [1,2,3]
 * 
 * Output:
 * 3
 * 
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * 
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 
 * 
 */
// one move for a means adding other elements except a by one, which equals subtracting one from a
// then I subtract x[i] from each element, then the move is sum(x[i])
// To make sum(x[i]) the minimum number:
// Now that all reach the same number by adding, then they could get the same number by subtracting.
// The biggest same number is the minimum number in the array
class Solution {
    public int minMoves(int[] nums) {
        // get the min in the array
        int min=nums[0];
        for(int i=0; i<nums.length; i++){
            if(nums[i]<min) min=nums[i];
        }
        // add up nums[i]-min
        int sum=0;
        for(int i=0; i<nums.length; i++)    sum+=(nums[i]-min);
        return sum;
    }
}
