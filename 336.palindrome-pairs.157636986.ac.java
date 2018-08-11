/*
 * [336] Palindrome Pairs
 *
 * https://leetcode.com/problems/palindrome-pairs/description/
 *
 * algorithms
 * Hard (27.65%)
 * Total Accepted:    43.4K
 * Total Submissions: 156.8K
 * Testcase Example:  '["abcd","dcba","lls","s","sssll"]'
 *
 * Given a list of unique words, find all pairs of distinct indices (i, j) in
 * the given list, so that the concatenation of the two words, i.e. words[i] +
 * words[j] is a palindrome.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]] 
 * Explanation: The palindromes are
 * ["dcbaabcd","abcddcba","slls","llssssll"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]] 
 * Explanation: The palindromes are ["battab","tabbat"]
 * 
 * 
 * 
 * 
 */
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        TrieNode root = new TrieNode(0);
        for(int i=0; i<words.length; i++){
            insert(root, words[i], words[i].length()-1, i);
        }
        for(int i=0; i<words.length; i++){
            search(root, words[i], i, res, words);
        }
        return res;
    }
    public void addToRes(List<List<Integer>> res, int a, int b){
        if(a != b){
            List<Integer> l = new ArrayList<>();
            l.add(a);
            l.add(b);
            res.add(l);            
        }
    }
    public void search(TrieNode root, String str, Integer arrIndex, List<List<Integer>> res, String[] words){
        
        if(root.strIndex == str.length()){
            searchPalindrome(root, res, words, root.strIndex, arrIndex);
            
            return;
        }
        char c = str.charAt(root.strIndex);
        if(root.endOfWord == true){//two routes, stop here and continue, both work, and I should traverse both routes, no return in this function
            if(isPalindrome(str.substring(root.strIndex))){
                addToRes(res, arrIndex, root.arrIndex);
            }
        }
        if(root.children.containsKey(c)){
            root = root.children.get(c);
        }else{
            return;//not palindrome pair
        }
        search(root, str, arrIndex, res, words);
    }
    public void searchPalindrome(TrieNode root, List<List<Integer>> res, String[] words, int startStrIndex, Integer arrIndex){
        if(root == null){
            return;
        }
        if(root.endOfWord){
            String word = words[root.arrIndex];
            if(isPalindrome(word.substring(0, word.length()-startStrIndex))){
                addToRes(res, arrIndex, root.arrIndex);
            }
        }
        TrieNode[] nodes = root.children.values().toArray(new TrieNode[0]);
        for(int i=0; i<nodes.length; i++){
            searchPalindrome(nodes[i], res, words, startStrIndex, arrIndex);
        }
    }
    public boolean isPalindrome(String str){
        for(int i=0; i<str.length()/2; i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    public void insert(TrieNode root, String str, int strIndex, Integer arrIndex){
        if(strIndex == -1){
            root.endOfWord = true;
            root.arrIndex = arrIndex;
            return;
        }
        char c = str.charAt(strIndex);
        if(root.children.containsKey(c)){
            root = root.children.get(c);
        }else{
            TrieNode newTrieNode = new TrieNode(str.length()-strIndex);
            root.children.put(c, newTrieNode);
            root = newTrieNode;
        }
        insert(root, str, strIndex-1, arrIndex);
    }
}


class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
    Integer arrIndex = null;
    int strIndex = 0;
    public TrieNode(int strIndex){
        this.strIndex = strIndex;
    }
}
