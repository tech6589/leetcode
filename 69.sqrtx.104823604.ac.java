/*
 * [69] Sqrt(x)
 *
 * https://leetcode.com/problems/sqrtx
 *
 * algorithms
 * Easy (27.98%)
 * Total Accepted:    176.8K
 * Total Submissions: 632.1K
 * Testcase Example:  '0'
 *
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 */
public class Solution {
    private static final int MAX_SQRT=46340;
    public int mySqrt(int x) {
        return bisearch(0, MAX_SQRT+1, x);
    }
    private int bisearch(int low, int high, int sqr){//low is inclusive and high is exclusive
        if(high-low<=1){
            return low;
        }
        int medium=(low+high)/2;
        if(sqr>=medium*medium){//= must be put here because the medium is inclusive
            return bisearch(medium, high, sqr);//medium is inclusive
        }else{
            return bisearch(low, medium, sqr);
        }
        
    }
}
