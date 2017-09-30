/*
 * [252] Meeting Rooms
 *
 * https://leetcode.com/problems/meeting-rooms
 *
 * algorithms
 * Easy (47.77%)
 * Total Accepted:    36.7K
 * Total Submissions: 76.9K
 * Testcase Example:  '[]'
 *
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all
 * meetings.
 * 
 * 
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return false.
 * 
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

// sort by start time
// compare e1 and s2 if they meet e1<=s2
/* beats 92.37%, but it takes a lot of time to write quick sort.
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        quickSort(intervals, 0, intervals.length);
        for(int i=0; i<intervals.length-1; i++){
            if(intervals[i].end>intervals[i+1].start)   return false;
        }
        return true;
        
    }
    private void quickSort(Interval[] intervals, int left, int right){//left inclusive, right exclusive
        if(right-left<=1) return;
        // if(right-left==2&&intervals[right-1].start>=intervals[left].start) return;
        int flag=intervals[right-1].start;
        int i=left;
        int j=left;
        while(j<right-1){
            if(intervals[j].start<=flag){
                swap(intervals, i, j);
                i++;
            }
            j++;
        }
        swap(intervals, i, j);
        int middle=i;
        quickSort(intervals, left, middle);
        quickSort(intervals, middle, right);
    }
    private void swap(Interval[] intervals, int i, int j){
        Interval tmp=new Interval();
        tmp=intervals[i];
        intervals[i]=intervals[j];
        intervals[j]=tmp;
    }
}*/
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
           @Override
            public int compare(Interval a, Interval b){
                return a.start-b.start;//ascending order
            }
        });
        
        //quickSort(intervals, 0, intervals.length);
        for(int i=0; i<intervals.length-1; i++){
            if(intervals[i].end>intervals[i+1].start)   return false;
        }
        return true;
        
    }
}
