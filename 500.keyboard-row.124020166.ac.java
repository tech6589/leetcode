/*
 * [500] Keyboard Row
 *
 * https://leetcode.com/problems/keyboard-row
 *
 * algorithms
 * Easy (59.71%)
 * Total Accepted:    44.6K
 * Total Submissions: 74.7K
 * Testcase Example:  '["Hello","Alaska","Dad","Peace"]'
 *
 * Given a List of words, return the words that can be typed using letters of
 * alphabet on only one row's of American keyboard like the image
 * below. 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * 
 * 
 * 
 * Note:
 * 
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 * 
 * 
 */
//Array as Map Solution
class Solution {
    private int[] arr;//(LowerCaseletter-'a', level)
    public Solution(){
        // write level of each lowercase letter directly
        //          a b c d e f g h i j k l m n o p q r s t u v w x y z
        arr=new int[] {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
        // arr['q'-'a']=1;arr['w'-'a']=1;arr['e'-'a']=1;arr['r'-'a']=1;arr['t'-'a']=1;arr['y'-'a']=1;arr['u'-'a']=1;arr['i'-'a']=1;arr['o'-'a']=1;arr['p'-'a']=1;//level==1
        // arr['a'-'a']=2;arr['s'-'a']=2;arr['d'-'a']=2;arr['f'-'a']=2;arr['g'-'a']=2;arr['h'-'a']=2;arr['j'-'a']=2;arr['k'-'a']=2;arr['l'-'a']=2;//level==2
        // arr['z'-'a']=3;arr['x'-'a']=3;arr['c'-'a']=3;arr['v'-'a']=3;arr['b'-'a']=3;arr['n'-'a']=3;arr['m'-'a']=3;//level==3
    }
    public String[] findWords(String[] words) {
        int count=0;
        for(int i=0; i<words.length; i++){
            char[] word=words[i].toCharArray();
            int level=arr[Character.toLowerCase(word[0])-'a'];// first level
            int j=1;
            for(; j<word.length; j++){
                if(level!=arr[Character.toLowerCase(word[j])-'a']) break;// compare first level with cur level
            }
            if(j!=word.length)  words[i]="";// if break out, set it to ""
            else                count++;
        }
        String[] res=new String[count];
        for(int i=0, j=0; i<words.length&&j<res.length; i++){
            if(words[i].equals("")==false){// if not set to "", add it to res
                res[j]=words[i];
                j++;
            }
        }
        return res;
    }
}

