/*
 * [243] Shortest Word Distance
 *
 * https://leetcode.com/problems/shortest-word-distance
 *
 * algorithms
 * Easy (52.60%)
 * Total Accepted:    34.4K
 * Total Submissions: 65.4K
 * Testcase Example:  '["a","b"]\n"a"\n"b"'
 *
 * Given a list of words and two words word1 and word2, return the shortest
 * distance between these two words in the list.
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * 
 * 
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 * 
 * 
 * 
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are
 * both in the list.
 * 
 */
/*Brute force
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int min=Integer.MAX_VALUE;
        for(int i=0; i<words.length; i++){
            if(words[i].equals(word1)){
                for(int j=0; j<words.length; j++){
                    if(words[j].equals(word2))   min=Math.min(min, Math.abs(i-j));
                }
            }
        }
        return min;
    }
}*/
// One pass
// Since word1 and word2 form the shortest distance only when they are adjacent, remember the lastest index of word1 and word2 will and calculate abs(index1-index2) will do the job.
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1=-1;
        int index2=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0; i<words.length; i++){
            if(words[i].equals(word1))  index1=i;
            if(words[i].equals(word2))  index2=i;
            if(index1>=0 && index2>=0)  min=Math.min(min, Math.abs(index1-index2));
        }
        return min;
    }
}
