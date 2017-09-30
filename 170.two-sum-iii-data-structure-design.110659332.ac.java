/*
 * [170] Two Sum III - Data structure design
 *
 * https://leetcode.com/problems/two-sum-iii-data-structure-design
 *
 * algorithms
 * Easy (24.86%)
 * Total Accepted:    30K
 * Total Submissions: 120.5K
 * Testcase Example:  '["TwoSum","add","add","add","find","find"]\n[[],[1],[3],[5],[4],[7]]'
 *
 * Design and implement a TwoSum class. It should support the following
 * operations: add and find.
 * 
 * 
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the
 * value.
 * 
 * 
 * 
 * For example,
 * 
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * 
 * 
 */
// Last one uses 2 pointers for find method because this way is of O(1) space complexity while hashmap will bring O(n) space complexity.
// However, this one will lead to a O(n) space complexity even using 2 pointers. At the same time, hashmap has a O(1) time complexity for add while 2 pointers find will lead to O(n) time complexity for add.


// special case: [0, -1, 1]     value: 0

public class TwoSum {// space complexity O(n)
    private Map<Integer, Integer> map;//num, count
    /** Initialize your data structure here. */
    public TwoSum() {
        map=new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {// time complexity O(1)
        Integer value=map.get(number);
        if(value==null) map.put(number, 1);
        else            map.put(number, value+1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {// time complexity O(n)
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            if(map.containsKey(value-e.getKey())){
                if(value-e.getKey()!=e.getKey()){// this pair contains two different values
                    return true;
                }else{// this pair contains two values which are the same
                    if(e.getValue()>1) return true;// if the value appears twice, then it's true; otherwise, continue to see if there is another pair that counts to target.
                }
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
