/*
 * [119] Pascal's Triangle II
 *
 * https://leetcode.com/problems/pascals-triangle-ii
 *
 * algorithms
 * Easy (37.15%)
 * Total Accepted:    126.1K
 * Total Submissions: 339.5K
 * Testcase Example:  '0'
 *
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * 
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * 
 * 
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 */
// Do it recursively then I encountered overlapped sub problems, which shows that I should use DP to solve. Then it turns back to the original problem.

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> l=new LinkedList<>();
        for(int i=0; i<rowIndex+1; i++){
            l.add(i, 1);
            for(int j=i-1; j>0; j--){
                l.set(j, l.get(j-1)+l.get(j));
            }
        }
        return l;
    }
}
