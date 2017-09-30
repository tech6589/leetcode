/*
 * [278] First Bad Version
 *
 * https://leetcode.com/problems/first-bad-version
 *
 * algorithms
 * Easy (25.51%)
 * Total Accepted:    114.3K
 * Total Submissions: 448K
 * Testcase Example:  '1 version\n1 is the first bad version.'
 *
 * 
 * You are a product manager and currently leading a team to develop a new
 * product. Unfortunately, the latest version of your product fails the quality
 * check. Since each version is developed based on the previous version, all
 * the versions after a bad version are also bad. 
 * 
 * 
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the
 * first bad one, which causes all the following ones to be bad.
 * 
 * 
 * 
 * You are given an API bool isBadVersion(version) which will return whether
 * version is bad. Implement a function to find the first bad version. You
 * should minimize the number of calls to the API.
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
/*  Recursive Solution
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return (int)binarySearch(1, n);//the result is between 1 and n, it's int of course 
    }
    private long binarySearch(long l, long r){// l, r inclusive, l+r may exceeds Integer.MAX_VALUE, so use long instead
        if(isBadVersion((int)((l+r)/2))==true){// (l+r)/2 is between l and r, it's int of course
            if(l+1>=r)  return l;// since (l+(l+1))/2 always get k, it would be binarySearch(l, l)
            return binarySearch(l, (l+r)/2);
        }else{
            if(l+1>=r)  return r;// it would be binarySearch(l, r), causing StackOverflowError
            return binarySearch((l+r)/2, r);
        }
    }
}*/
// Adaptation of recursive solution
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long l=1;// l is inclusive
        long r=n;// r is inclusive
        int m=0;// m is between l and r, of course it's a int
        while(l+1<r){
            m=(int)((l+r)/2);
            if(isBadVersion(m)==true){
                r=m;
            }else{
                l=m;
            }                       
        }
        // now l+1>=r
        if(isBadVersion((int)((l+r)/2))==true)  return (int)l;
        else                                    return (int)r;
    }
    
}
