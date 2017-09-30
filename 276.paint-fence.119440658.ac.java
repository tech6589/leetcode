/*
 * [276] Paint Fence
 *
 * https://leetcode.com/problems/paint-fence
 *
 * algorithms
 * Easy (34.49%)
 * Total Accepted:    25.6K
 * Total Submissions: 74.3K
 * Testcase Example:  '0\n0'
 *
 * 
 * There is a fence with n posts, each post can be painted with one of the k
 * colors.
 * You have to paint all the posts such that no more than two adjacent fence
 * posts have the same color. 
 * Return the total number of ways you can paint the fence. 
 * 
 * Note:
 * n and k are non-negative integers. 
 */
/*  sameColorCounts: the counts of cases where the current post shares the same color as the last one
    diffColorCounts: the counts of cases where the current post shares different color as the last one
    3 posts, 2 colors
    initial 2 posts:
    00
    01
    10
    11
    sameColorCounts=2
    diffColorCounts=2
    the next post:
    if the same color:  diffColorCounts, now it's the new sameColorCounts
    011, 100
    if diff color:      (sameColorCounts+diffColorCounts)*(k-1), now it's the new diffColorCounts
    001, 101, 101, 110
*/
class Solution {
    public int numWays(int n, int k) {
        if(n==0)    return 0;
        if(n==1)    return k;
        int sameColorCounts=k;
        int diffColorCounts=k*(k-1);
        for(int i=2; i<n; i++){
            int tmp=diffColorCounts;
            diffColorCounts=(sameColorCounts+diffColorCounts)*(k-1);
            sameColorCounts=tmp;
        }
        return diffColorCounts+sameColorCounts;
    }
}
