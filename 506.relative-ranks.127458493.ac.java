/*
 * [506] Relative Ranks
 *
 * https://leetcode.com/problems/relative-ranks/description/
 *
 * algorithms
 * Easy (47.12%)
 * Total Accepted:    33.6K
 * Total Submissions: 71.4K
 * Testcase Example:  '[5,4,3,2,1]'
 *
 * 
 * Given scores of N athletes, find their relative ranks and the people with
 * the top three highest scores, who will be awarded medals: "Gold Medal",
 * "Silver Medal" and "Bronze Medal".
 * 
 * Example 1:
 * 
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so
 * they got "Gold Medal", "Silver Medal" and "Bronze Medal". For the left two
 * athletes, you just need to output their relative ranks according to their
 * scores.
 * 
 * 
 * 
 * Note:
 * 
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 * 
 * 
 * 
 */
//70% HashMap+Array.sort()
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int len=nums.length;
        Map<Integer, Integer> map=new HashMap<>();//(value, index)
        for(int i=0; i<len; i++)    map.put(nums[i], i);
        Arrays.sort(nums);
        String[] res=new String[len];
        if(len>0)                   res[map.get(nums[len-1])]="Gold Medal";
        if(len>1)                   res[map.get(nums[len-2])]="Silver Medal";
        if(len>2)                   res[map.get(nums[len-3])]="Bronze Medal";
        for(int i=3; i<len; i++)    res[map.get(nums[len-1-i])]=i+1+"";
        return res;
    }
}
// 96% quick sort solution
/*class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int len=nums.length;
        Score[] arr=new Score[len];
        for(int i=0; i<len; i++){
            arr[i]=new Score();
            arr[i].val=nums[i];
            arr[i].index=i;
        }
        quickSort(arr, 0, len);
        String[] res=new String[len];
        if(len>0)                   res[arr[0].index]="Gold Medal";
        if(len>1)                   res[arr[1].index]="Silver Medal";
        if(len>2)                   res[arr[2].index]="Bronze Medal";
        for(int i=3; i<len; i++)    res[arr[i].index]=i+1+"";
        return res;
    }
    private void quickSort(Score[] arr, int l, int r){//l inclusive, r exclusive
        if(l+1>=r)    return;
        int flag=arr[r-1].val;
        int i=l, j=l;
        for(; j<r-1; j++){
            if(arr[j].val>flag){
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, j);
        // System.out.println("l:"+l+", i:"+i+", r:"+r);
        quickSort(arr, l, i);
        quickSort(arr, i+1, r);
    }
    private void swap(Score[] arr, int i, int j){
        Score tmp=arr[j];
        arr[j]=arr[i];
        arr[i]=tmp;
    }
}
class Score{
    int val;
    int index;
}*/
// Use Score class, use collections.sort
/* 63% Arrays.sort(arr, new Comparator<Score>()
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int len=nums.length;
        Score[] arr=new Score[len];
        for(int i=0; i<len; i++){
            arr[i]=new Score();
            arr[i].val=nums[i];
            arr[i].index=i;
        }
        Arrays.sort(arr, new Comparator<Score>(){
           @Override
            public int compare(Score s1, Score s2){
                return s2.val-s1.val;
            }
        });
        String[] res=new String[len];
        if(len>0)                   res[arr[0].index]="Gold Medal";
        if(len>1)                   res[arr[1].index]="Silver Medal";
        if(len>2)                   res[arr[2].index]="Bronze Medal";
        for(int i=3; i<len; i++)    res[arr[i].index]=i+1+"";
        return res;
    }
}
class Score{
    int val;
    int index;
}*/

