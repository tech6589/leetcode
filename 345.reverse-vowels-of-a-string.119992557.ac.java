/*
 * [345] Reverse Vowels of a String
 *
 * https://leetcode.com/problems/reverse-vowels-of-a-string
 *
 * algorithms
 * Easy (38.62%)
 * Total Accepted:    87.1K
 * Total Submissions: 225.6K
 * Testcase Example:  '"hello"'
 *
 * Write a function that takes a string as input and reverse only the vowels of
 * a string.
 * 
 * 
 * Example 1:
 * Given s = "hello", return "holle".
 * 
 * 
 * 
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * 
 * 
 * 
 * Note:
 * The vowels does not include the letter "y".
 * 
 */
/*
class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        for(int i=0, j=arr.length-1; i<j; i++, j--){
            // find vowel arr[i]
            while(isVowel(arr[i])==false){
                i++;
                if(i>=j)    return new String(arr);
            }
            // find vowel arr[j]
            while(isVowel(arr[j])==false){
                j--;
                if(i>=j)    return new String(arr);
            }
            //swap
            char tmp=arr[i];
            arr[i]=arr[j];
            arr[j]=tmp;
        }
        return new String(arr);
    }
    private boolean isVowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U')  return true;
        else                                                                                return false;
    }
}*/
// a clearer solution which shares similiar performance with my original one.
class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        for(int i=0, j=arr.length-1; i<j; ){
            if(isVowel(arr[i])==false){// i is not vowel
                i++;
            }else if(isVowel(arr[j])==false){// i is vowel, j is not
                j--;
            }else{// i and j are vowels, swap
                char tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
                i++;
                j--;
            }            
        }
        return new String(arr);
    }
    private boolean isVowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U')  return true;
        else                                                                                return false;
    }
}
