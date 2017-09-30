/*
 * [118] Pascal's Triangle
 *
 * https://leetcode.com/problems/pascals-triangle
 *
 * algorithms
 * Easy (38.88%)
 * Total Accepted:    143.8K
 * Total Submissions: 369.9K
 * Testcase Example:  '0'
 *
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * 
 * For example, given numRows = 5,
 * Return
 * 
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 * 
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists=new LinkedList<>();
        for(int i=0; i<numRows; i++){
            List<Integer> l=new LinkedList<>();
            lists.add(l);
            for(int j=0; j<i+1; j++){
                if(j==0||j==i){
                    l.add(1);
                }else{
                    l.add(lists.get(i-1).get(j-1)+lists.get(i-1).get(j));
                }
            }
        }
        return lists;
    }
}
