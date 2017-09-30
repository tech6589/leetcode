/*
 * [70] Climbing Stairs
 *
 * https://leetcode.com/problems/climbing-stairs
 *
 * algorithms
 * Easy (40.22%)
 * Total Accepted:    196.4K
 * Total Submissions: 488.2K
 * Testcase Example:  '1'
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * 
 * Note: Given n will be a positive integer.
 * 
 */
public class Solution {
    public int climbStairs(int n) {
        int[] result=new int[n+1];
        result[0]=1;
        result[1]=1;
        for(int i=2; i<=n; i++){
            result[i]=result[i-1]+result[i-2];
        }
        return result[n];
    }
    /*My recursive function
    private int numOfWays(int remainingSteps){
        if(remainingSteps<0){
            return 0;
        }else if(remainingSteps==0){
            return 1;
        }else{//remainingSteps>0
            return numOfWays(remainingSteps-1)+numOfWays(remainingSteps-2);
        }
        
    }*/
}
