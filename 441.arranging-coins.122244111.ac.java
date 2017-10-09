/*
 * [441] Arranging Coins
 *
 * https://leetcode.com/problems/arranging-coins
 *
 * algorithms
 * Easy (36.24%)
 * Total Accepted:    34.7K
 * Total Submissions: 95.8K
 * Testcase Example:  '5'
 *
 * You have a total of n coins that you want to form in a staircase shape,
 * where every k-th row must have exactly k coins.
 * ⁠
 * Given n, find the total number of full staircase rows that can be formed.
 * 
 * n is a non-negative integer and fits within the range of a 32-bit signed
 * integer.
 * 
 * Example 1:
 * 
 * n = 5
 * 
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * 
 * Because the 3rd row is incomplete, we return 2.
 * 
 * 
 * 
 * Example 2:
 * 
 * n = 8
 * 
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * 
 * Because the 4th row is incomplete, we return 3.
 * 
 * 
 */
//Math Solution
// condition1: (1+x)*x/2-n<=x
// condition2: n-(1+x-1)*(x-1)/2<x
// if it satisfies condition 1 and 2, then return x-1
// simplify condition 1 and 2: (-1+sqrt(1+8*n))/2<x<=(1+sqrt(1+8*n))/2 => x==(int)((-1+sqrt(1+8*n))/2)+1
// therefore return (int)((-1+sqrt(1+8*n))/2)
class Solution {
    public int arrangeCoins(int n) {
        double sqrt=Math.sqrt(1.0+8.0*n);
        return (int)((-1.0+sqrt)/2.0);
    }
}
//binary solution
/*
class Solution {
    public int arrangeCoins(int n) {
        if(n==0)    return 0;
        long l=1;
        long r=n;
        while(l<r){
            long m=l+(r-l)/2;
            long sum=(1+m)*m/2;//sum may exceeds 2^31-1
            if(sum==n){
                l=m;
                break;
            }else if(sum>n){
                r=m-1;
            }else{//(sum<n)
                l=m+1;
            }
        }
        if(((1+l)*l/2)<=n)  return (int)l;
        else                return (int)(l-1);
    }
}*/
