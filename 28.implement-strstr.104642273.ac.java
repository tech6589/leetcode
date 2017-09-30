/*
 * [28] Implement strStr()
 *
 * https://leetcode.com/problems/implement-strstr
 *
 * algorithms
 * Easy (28.33%)
 * Total Accepted:    209.6K
 * Total Submissions: 739.9K
 * Testcase Example:  '""\n""'
 *
 * 
 * Implement strStr().
 * 
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 */
public class Solution {
    //return haystack.indexOf(needle);
    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        if((haystack.length()<needle.length())||((haystack.length()==needle.length())&&(haystack.equals(needle)==false))){
            return -1;
        }
        
        int[] array=createArray(needle);
        /*
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("");*/
        return getIndexWithKMP(haystack, needle, array);
   
    }
    private int getIndexWithKMP(String text, String pattern, int[] array){
        int i=0;
        int j=0;
        while((j<pattern.length())&&(i<text.length())){
            if(text.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }else{
                if(j==0){
                    i++;
                }else{
                    j=array[j-1];
                }
            }
        }
        if(j>=pattern.length()){
            return i-j;
        }else{//i>=text.length()
            return -1;
        }
        
    }
    private int[] createArray(String pattern){
        int[] array=new int[pattern.length()];
        array[0]=0;
        int i=0;
        int j=1;
        boolean isInterrupted=false;
        
        while(j<pattern.length()){
            if(pattern.charAt(i)==pattern.charAt(j)){
                if(isInterrupted==true){
                    array[j]=array[i]+1;
                }else{
                    array[j]=array[j-1]+1;
                }
                i++;
                j++;
                isInterrupted=false;
            }else{
                if(i==0){
                    array[j]=0;
                    j++;
                }else{
                    i=array[i-1];
                }
                isInterrupted=true;
            }
        }
        return array;
    }
}
