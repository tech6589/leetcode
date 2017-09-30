/*
 * [346] Moving Average from Data Stream
 *
 * https://leetcode.com/problems/moving-average-from-data-stream
 *
 * algorithms
 * Easy (58.93%)
 * Total Accepted:    27.4K
 * Total Submissions: 46.4K
 * Testcase Example:  '["MovingAverage","next","next","next","next"]\n[[3],[1],[10],[3],[5]]'
 *
 * Given a stream of integers and a window size, calculate the moving average
 * of all integers in the sliding window.
 * 
 * For example,
 * 
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * 
 * 
 */
/*Queue Solution
class MovingAverage {
    private Queue<Integer> q=new LinkedList<>();
    private int size;
    private double sum;
    /** Initialize your data structure here. */
/*
    public MovingAverage(int size) {
        this.size=size;
    }
    
    public double next(int val) {
        q.add(val);
        sum+=val;
        if(q.size()>size) sum-=q.poll();
        return sum/q.size();
    }
}*/

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
class MovingAverage {
    private Integer[] arr;
    private double sum;
    private int index;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        arr=new Integer[size];
        index=-1;
    }
    
    public double next(int val) {
        sum+=val;
        index++;
        if(arr[index%arr.length]!=null){
            sum-=arr[index%arr.length];
            arr[index%arr.length]=val;
            return sum/arr.length;
        }else{
            arr[index%arr.length]=val;
            return sum/(index+1);
        }
        
        
        
    }
}
