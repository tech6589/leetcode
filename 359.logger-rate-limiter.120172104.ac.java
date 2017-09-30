/*
 * [359] Logger Rate Limiter
 *
 * https://leetcode.com/problems/logger-rate-limiter
 *
 * algorithms
 * Easy (59.83%)
 * Total Accepted:    19.3K
 * Total Submissions: 32.3K
 * Testcase Example:  '["Logger","shouldPrintMessage","shouldPrintMessage","shouldPrintMessage","shouldPrintMessage","shouldPrintMessage","shouldPrintMessage"]\n[[],[1,"foo"],[2,"bar"],[3,"foo"],[8,"bar"],[10,"foo"],[11,"foo"]]'
 *
 * Design a logger system that receive stream of messages along with its
 * timestamps, each message should be printed if and only if it is not printed
 * in the last 10 seconds.
 * 
 * Given a message and a timestamp (in seconds granularity), return true if the
 * message should be printed in the given timestamp, otherwise returns false.
 * 
 * It is possible that several messages arrive roughly at the same time.
 * 
 * Example:
 * 
 * Logger logger = new Logger();
 * 
 * // logging string "foo" at timestamp 1
 * logger.shouldPrintMessage(1, "foo"); returns true; 
 * 
 * // logging string "bar" at timestamp 2
 * logger.shouldPrintMessage(2,"bar"); returns true;
 * 
 * // logging string "foo" at timestamp 3
 * logger.shouldPrintMessage(3,"foo"); returns false;
 * 
 * // logging string "bar" at timestamp 8
 * logger.shouldPrintMessage(8,"bar"); returns false;
 * 
 * // logging string "foo" at timestamp 10
 * logger.shouldPrintMessage(10,"foo"); returns false;
 * 
 * // logging string "foo" at timestamp 11
 * logger.shouldPrintMessage(11,"foo"); returns true;
 * 
 * 
 * 
 * Credits:Special thanks to @memoryless for adding this problem and creating
 * all test cases.
 */
// This Solution has bad time complexity while saving space, because it only stores message in the last 10 seconds.
// Array to replace queue to increase performance
/*
class Logger {
    private List[] arr;
    private int lastTimestamp;
    public Logger() {
        arr=new LinkedList[10];
        lastTimestamp=0;
    }
    public boolean shouldPrintMessage(int timestamp, String message) {
        //evict entry from lastTimestamp+1 to timestamp
        for(int i=lastTimestamp+1; i<=timestamp; i++)       arr[i%arr.length]=null;
        // record lastTimestamp
        lastTimestamp=timestamp;
        // check if message printed in the last 10 seconds
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=null && arr[i].contains(message))    return false;
        }
        // record the message to be printed
        if(arr[timestamp%arr.length]==null)                 arr[timestamp%arr.length]=new LinkedList();
        arr[timestamp%arr.length].add(message);
        return true;// true means to print
    }
}*/

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
// Map Solution
class Logger {
    private Map<String, Integer> map=new HashMap<>();// message, lastTimestamp
    /** Initialize your data structure here. */
    public Logger() {
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)==false){
            map.put(message, timestamp);
            return true;
        }
        if(timestamp-map.get(message)>=10){// exceeds 10 seconds
            // update lastTimestamp
            map.put(message, timestamp);
            return true;
        }else{
            return false;
        }
    }
}
