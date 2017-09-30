/*
 * [13] Roman to Integer
 *
 * https://leetcode.com/problems/roman-to-integer
 *
 * algorithms
 * Easy (46.21%)
 * Total Accepted:    175.2K
 * Total Submissions: 379.3K
 * Testcase Example:  '"DCXXI"'
 *
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Solution {
    // Basic rule: if current one is smaller than or equal to(<=) the previous one, then add the current one. Otherwise(>), minus the current one.
    
    // First treat all as addition
    // Then if cur > prev, subtract 2*prev as compensation, leading to +prev-2*prev=-prev
    public int romanToInt(String s) {
        int cur=0;
        int prev=1000;//assumes prev is the biggerst roman numeral
        int result=0;
        for(int i=0; i<s.length(); i++){
            switch(s.charAt(i)){
                case 'I':cur=1;
                    result+=cur;
                    break;
                case 'V':cur=5;
                    result+=cur;
                    break;
                case 'X':cur=10;
                    result+=cur;
                    break;
                case 'L':cur=50;
                    result+=cur;
                    break;
                case 'C':cur=100;
                    result+=cur;
                    break;
                case 'D':cur=500;
                    result+=cur;
                    break;
                case 'M':cur=1000;
                    result+=cur;
                    break;
            }
            if(cur>prev){
                result-=2*prev;
            }
            prev=cur;
        }
        return result;
    }
}
