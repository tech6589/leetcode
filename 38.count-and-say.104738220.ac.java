/*
 * [38] Count and Say
 *
 * https://leetcode.com/problems/count-and-say
 *
 * algorithms
 * Easy (35.11%)
 * Total Accepted:    153K
 * Total Submissions: 435.7K
 * Testcase Example:  '1'
 *
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * 
 * 
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * 
 * 
 * 
 * Note: Each term of the sequence of integers will be represented as a
 * string.
 * 
 * 
 * Example 1:
 * 
 * Input: 1
 * Output: "1"
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 4
 * Output: "1211"
 * 
 * 
 */
public class Solution {
    // run length encoding
    public String countAndSay(int n) {
        String result="1";
        for(int i=1; i<n; i++){
            result=next(result);
        }
        return result;
        
    }
    private String next(String numStr){
        StringBuilder result=new StringBuilder();
        int i=0;
        int j=1;
        while(j<numStr.length()){
            if(numStr.charAt(j)==numStr.charAt(i)){
                j++;
            }else{
                result.append(j-i).append(numStr.charAt(i));
                i=j;
                j++;
            }
        }
        result.append(j-i).append(numStr.charAt(i));
        return result.toString();
    }
}
