/*
 * [246] Strobogrammatic Number
 *
 * https://leetcode.com/problems/strobogrammatic-number
 *
 * algorithms
 * Easy (39.93%)
 * Total Accepted:    28.8K
 * Total Submissions: 72.1K
 * Testcase Example:  '"1"'
 *
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic. The number is
 * represented as a string.
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
// Two pointers: i and num.length()-i-1, one from left to right, one from right to left.
// convert the char pointer num.length()-i-1 points to using map.
// if not exist in the map, showing it's 2, 3, 4, 5 or 7, return false.
class Solution {
    private Map<Character, Character> map;
    public Solution(){
        map=new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
    }
    public boolean isStrobogrammatic(String num) {
        for(int i=0; i<num.length(); i++){
            if(map.containsKey(num.charAt(num.length()-i-1))==false)                return false;
            if(map.get(num.charAt(num.length()-i-1)).equals(num.charAt(i))==false)  return false;
        }
        return true;
    }
}
