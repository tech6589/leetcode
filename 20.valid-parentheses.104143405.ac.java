/*
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses
 *
 * algorithms
 * Easy (33.53%)
 * Total Accepted:    242.3K
 * Total Submissions: 722.6K
 * Testcase Example:  '"["'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all
 * valid but "(]" and "([)]" are not.
 * 
 */
import java.util.Stack;
public class Solution {
    // left case: push
    // right case: pop and compare
    // check empty before pop
    // after loop, check if empty
    
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if((c=='(')||(c=='[')||(c=='{')){
                stack.push(c);
            }else if((c==')')||(c==']')||(c=='}')){
                if(stack.empty()){
                    //System.out.println("exit 1.");
                    return false;
                }else{
                    char poped=stack.pop();
                    if(((c==')')&&(poped=='('))||((c==']')&&(poped=='['))||((c=='}')&&(poped=='{'))){
                        //do nothing
                    }else{
                        //System.out.println("exit 2.");
                        return false;
                    }
                }
            }
        }
        if(stack.empty()){
            //System.out.println("exit 3.");
            return true;
        }else{
            //System.out.println("exit 4.");
            return false;
        }
    }
}
