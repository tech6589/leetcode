/*
 * [657] Judge Route Circle
 *
 * https://leetcode.com/problems/judge-route-circle/description/
 *
 * algorithms
 * Easy (68.85%)
 * Total Accepted:    95.3K
 * Total Submissions: 138.4K
 * Testcase Example:  '"UD"'
 *
 * 
 * Initially, there is a Robot at position (0, 0). Given a sequence of its
 * moves, judge if this robot makes a circle, which means it moves back to the
 * original place. 
 * 
 * 
 * 
 * The move sequence is represented by a string. And each move is represent by
 * a character. The valid robot moves are R (Right), L (Left), U (Up) and D
 * (down). The output should be true or false representing whether the robot
 * makes a circle.
 * 
 * 
 * Example 1:
 * 
 * Input: "UD"
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "LL"
 * Output: false
 * 
 * 
 */
class Solution {
    public boolean judgeCircle(String moves) {
        Position p=new Position();
        char[] chars=moves.toCharArray();
        for(int i=0; i<chars.length; i++){
            switch(chars[i]){
                case 'U':   p.y++;
                            break;
                case 'D':   p.y--;
                            break;
                case 'L':   p.x--;
                            break;
                case 'R':   p.x++;
                            break;
            }
        }
        if(p.x==0&&p.y==0){
            return true;
        }else{
            return false;
        }
    }
}
class Position{
    int x;
    int y;
    public Position(){
        x=0;
        y=0;
    }
}
