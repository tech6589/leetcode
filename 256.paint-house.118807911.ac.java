/*
 * [256] Paint House
 *
 * https://leetcode.com/problems/paint-house
 *
 * algorithms
 * Easy (46.18%)
 * Total Accepted:    26.2K
 * Total Submissions: 56.8K
 * Testcase Example:  '[]'
 *
 * 
 * There are a row of n houses, each house can be painted with one of the three
 * colors: red, blue or green. The cost of painting each house with a certain
 * color is different. You have to paint all the houses such that no two
 * adjacent houses have the same color.
 * 
 * 
 * The cost of painting each house with a certain color is represented by a n x
 * 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with
 * color red; costs[1][2] is the cost of painting house 1 with color green, and
 * so on... Find the minimum cost to paint all houses.
 * 
 * 
 * Note:
 * All costs are positive integers.
 */
class Solution {
    public int minCost(int[][] costs) {
        int length=costs.length;
        if(length==0) return 0;
        int[][] minCost=new int[length][3];//(house i, color j)
        for(int i=0; i<3; i++)  minCost[0][i]=costs[0][i];
        for(int i=1; i<length; i++){
            for(int j=0; j<3; j++){
                int color1=(j+1)%3;
                int color2=(j+2)%3;
                int a=minCost[i-1][color1]+costs[i][j];
                int b=minCost[i-1][color2]+costs[i][j];
                minCost[i][j]=Math.min(a, b);
            }
        }
        int result=Math.min(minCost[length-1][0], minCost[length-1][1]);
        result=Math.min(result, minCost[length-1][2]);
        return result;
    }
}
