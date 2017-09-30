/*
 * [190] Reverse Bits
 *
 * https://leetcode.com/problems/reverse-bits
 *
 * algorithms
 * Easy (29.52%)
 * Total Accepted:    113.4K
 * Total Submissions: 384.3K
 * Testcase Example:  '           0 (00000000000000000000000000000000)'
 *
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * For example, given input 43261596 (represented in binary as
 * 00000010100101000001111010011100), return 964176192 (represented in binary
 * as 00111001011110000010100101000000).
 * 
 * 
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * 
 * 
 * Related problem: Reverse Integer
 * 
 * Credits:Special thanks to @ts for adding this problem and creating all test
 * cases.
 */
/* 01&1   1   get 1 and push
*  00&1  10   get 0, not push
*
*/
/*
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result=0;
        //get 32 times, and push 31 times
        for(int i=0; i<32; i++){
            result=result|(n&1);
            n=n>>>1;
            if(i<31)    result=result<<1;// when i==31, not push
        }
        return result;       
    }
}*/
/*
* abcdefgh -> efghabcd -> ghefcdab -> hgfedcba
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        n=(n<<16)|(n>>>16);
        n=((n<<8)&0xFF00FF00)|((n>>>8)&0x00FF00FF);
        n=((n<<4)&0xF0F0F0F0)|((n>>>4)&0x0F0F0F0F);
        n=((n<<2)&0xCCCCCCCC)|((n>>>2)&0x33333333);
        n=((n<<1)&0xAAAAAAAA)|((n>>>1)&0x55555555);
        return n;
    }
}*/
import java.util.Map;
import java.util.HashMap;
public class Solution {
    // you need treat n as an unsigned value
    private static Map<Byte, Integer> cache=new HashMap<>();
    public int reverseBits(int n) {
        //cut n into 4 Byte
        Byte[] bytes=new Byte[4];
        for(int i=0; i<4; i++){
            bytes[i]=(byte)((n>>>8*i)&0xFF);
        }
        int result=0;
        for(int i=0; i<4; i++){
            result=result|(reverseByte(bytes[i])<<(8*(3-i)));
        }
        return result;
    }
    private int reverseByte(Byte b){
        if(cache.containsKey(b))    return cache.get(b);
        int n=b;
        n=((n<<4)&0xF0)|((n>>>4)&0x0F);
        n=((n<<2)&0xCC)|((n>>>2)&0x33);
        n=((n<<1)&0xAA)|((n>>>1)&0x55);
        cache.put(b, n);
        return n;
    }
}


