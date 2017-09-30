/*
 * [204] Count Primes
 *
 * https://leetcode.com/problems/count-primes
 *
 * algorithms
 * Easy (26.64%)
 * Total Accepted:    127.5K
 * Total Submissions: 478.5K
 * Testcase Example:  '0'
 *
 * Description:
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Credits:Special thanks to @mithmatt for adding this problem and creating all
 * test cases.
 */
// isPrime() to judge
// use array (index, not prime) to judge if it's a prime number
// at beginning, not prime in each index is 0
// when I find one num is a prime number, then I set 1*num, 2*num, 3*num ...(which should be less than n) to be 1
// before calculating isPrime(), check if nums[i] is the initial 0, if it's 1, of course not a prime number.
/*
class Solution {
    Map<Integer, Boolean> cache=new HashMap<>();
    public int countPrimes(int n) {
        int count=0;
        int[] nums=new int[n];// all 0 at initial
        for(int i=2; i<nums.length; i++){
            if(nums[i]==0&&isPrime(i)==true){
                count++;
            }else{
                for(int j=1; j*i<n; j++)    nums[j*i]=1;
            }
        }
        return count;
    }
    private boolean isPrime(int n){
        if(n<=1)    return false;
        for(int i=2; i<n; i++){
            if(n%i==0)  return false;
        }
        return true;
    }
}
*Time Limit Exceeded, I've to find a solution remember all results in an object.
*/
// Notice that when i*i is bigger than Integer.MAX_VALUE, it will become negative, introducing a lot of unnecessary calculation, that's why HashSet will exceed time limit, that is I have not noticed and fixed that.
class Solution {
    public int countPrimes(int n) {
        if(n==0||n==1)  return 0;
        boolean[] notPrime=new boolean[n];// all false at initial
        int count=n-2;// 0 and 1 is not a prime
        // mark off multiples of the prime
        for(int i=2; i*i<n; i++){// use i*i<n because j is set to i*i at initial and jhas to be less than n
            if(notPrime[i]==false){// i is a prime
                // mark the multiples of i as a non prime: i^2, i^2+i, i^2+2*i, ...
                for(int j=i*i; j<n; j+=i){
                    if(notPrime[j]==false){// j is not yet marked off
                        notPrime[j]=true;
                        count--;
                    }
                }
            }else{// i is already marked off
                //do nothing
            }
        }

        return count;
    }
}
