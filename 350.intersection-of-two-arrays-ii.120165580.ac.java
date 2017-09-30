/*
 * [350] Intersection of Two Arrays II
 *
 * https://leetcode.com/problems/intersection-of-two-arrays-ii
 *
 * algorithms
 * Easy (44.75%)
 * Total Accepted:    76.8K
 * Total Submissions: 171.7K
 * Testcase Example:  '[]\n[]'
 *
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * 
 * Note:
 * 
 * Each element in the result should appear as many times as it shows in both
 * arrays.
 * The result can be in any order.
 * 
 * 
 * 
 * Follow up:
 * 
 * What if the given array is already sorted? How would you optimize your
 * algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is
 * better?
 * What if elements of nums2 are stored on disk, and the memory is limited such
 * that you cannot load all elements into the memory at once?
 * 
 * 
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map=new HashMap<>();//(num, occurrences)
        // scan nums1 to add occurrences
        for(int i=0; i<nums1.length; i++){
            if(map.containsKey(nums1[i])==false)    map.put(nums1[i], 1);
            else                                    map.put(nums1[i], 1+map.get(nums1[i]));
        }
        // scan nums2 to substract occurrences
        List<Integer> resList=new LinkedList<>();
        for(int i=0; i<nums2.length; i++){
            if(map.containsKey(nums2[i])&&map.get(nums2[i])>0){
                resList.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }
        int[] res=new int[resList.size()];
        int i=0;
        for(int n: resList){
            res[i]=n;
            i++;
        }
        return res;
    }
}
