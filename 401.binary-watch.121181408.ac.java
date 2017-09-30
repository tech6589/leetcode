/*
 * [401] Binary Watch
 *
 * https://leetcode.com/problems/binary-watch
 *
 * algorithms
 * Easy (44.85%)
 * Total Accepted:    36.7K
 * Total Submissions: 81.8K
 * Testcase Example:  '0'
 *
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and
 * the 6 LEDs on the bottom represent the minutes (0-59).
 * Each LED represents a zero or one, with the least significant bit on the
 * right.
 * 
 * For example, the above binary watch reads "3:25".
 * 
 * Given a non-negative integer n which represents the number of LEDs that are
 * currently on, return all possible times the watch could represent.
 * 
 * Example:
 * Input: n = 1Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04",
 * "0:08", "0:16", "0:32"]
 * 
 * 
 * Note:
 * 
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid,
 * it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for
 * example "10:2" is not valid, it should be "10:02".
 * 
 * 
 */
// Recursive Solution, this problem works better with recursion than DP because of two reasons:
// 1. List<String> as result performs better as param than return
// 2. intermidiate numbers works better as param than return
// 3. recursive ends the recursion earlier than loop by return conditions
class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res=new LinkedList<>();
        read(num, 0, 0, 10, res);
        return res;
    }
    private void read(int n, int h, int m, int i, List<String> res){
        int nH=h;
        int nM=m;
        if(i>=1&&i<=4){
            nH+=(1<<i-1);
        }else if(i>=5&&i<=10){
            nM+=(1<<i-5);
        }
        if(h>11||m>59){//illegal
            return;//return without adding res  
        }else{//legal
            if(n==0){
                if(m<10&&m>=0){
                    res.add(h+":0"+m);// add leading zero for minutes
                }else{
                    res.add(h+":"+m);
                }
                return;// return with adding
            }else if(i==0){
                return;//return without adding res
            }else{
                read(n-1, nH, nM, i-1, res);
                read(n, h, m, i-1, res);
            }
        }
    }
}
