/*
 * [122] Best Time to Buy and Sell Stock II
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
 *
 * algorithms
 * Easy (47.25%)
 * Total Accepted:    160K
 * Total Submissions: 338.6K
 * Testcase Example:  '[]'
 *
 * Say you have an array for which the ith element is the price of a given
 * stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 */
//Single one pass
//consecutive sum
public class Solution {
    public int maxProfit(int[] prices) {
        int sum=0;
        for(int i=0; i<prices.length-1; i++){
            if(prices[i+1]>prices[i])   sum+=prices[i+1]-prices[i];
        }
        return sum;
    }
}
