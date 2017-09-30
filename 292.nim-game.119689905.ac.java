/*
 * [292] Nim Game
 *
 * https://leetcode.com/problems/nim-game
 *
 * algorithms
 * Easy (55.24%)
 * Total Accepted:    143.9K
 * Total Submissions: 260.5K
 * Testcase Example:  '1'
 *
 * 
 * You are playing the following Nim Game with your friend: There is a heap of
 * stones on the table, each time one of you take turns to remove 1 to 3
 * stones. The one who removes the last stone will be the winner. You will take
 * the first turn to remove the stones.
 * 
 * 
 * 
 * Both of you are very clever and have optimal strategies for the game. Write
 * a function to determine whether you can win the game given the number of
 * stones in the heap.
 * 
 * 
 * 
 * For example, if there are 4 stones in the heap, then you will never win the
 * game: no matter 1, 2, or 3 stones you remove, the last stone will always be
 * removed by your friend.
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
/*Indirect Solution
class Solution {
    public boolean canWinNim(int n) {
        for(int i=1; i<=3; i++){
            if((n-i)%4==0)  return true;
        }
        return false;
    }
}*/
// if I get 4*x then I lose, otherwise I can always leave 4*x to my opponents by substracting 1-3, making him lose
// In fact, I have the possibility of 3/4 to win because I take the first turn.
// Direct Solution
class Solution {
    public boolean canWinNim(int n) {
        if(n%4==0)  return false;
        else        return true;
    }
}
