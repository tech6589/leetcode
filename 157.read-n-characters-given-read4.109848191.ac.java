/*
 * [157] Read N Characters Given Read4
 *
 * https://leetcode.com/problems/read-n-characters-given-read4
 *
 * algorithms
 * Easy (28.99%)
 * Total Accepted:    36.5K
 * Total Submissions: 126K
 * Testcase Example:  '""\n0'
 *
 * 
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * 
 * 
 * 
 * The return value is the actual number of characters read. For example, it
 * returns 3 if there is only 3 characters left in the file.
 * 
 * 
 * 
 * By using the read4 API, implement the function int read(char *buf, int n)
 * that reads n characters from the file.
 * 
 * 
 * 
 * Note:
 * The read function will only be called once for each test case.
 * 
 */
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */



// read4(char[] buf) API read at most 4 characters from a file to buf
// read(char[] buf, int n) is required to read n characters from a file to buf
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buf4=new char[4];
        int total=0;
        for(int i=0; i<Math.ceil(n/4.0); i++){
            int num=read4(buf4);
            for(int j=0; j<num; j++){
                if(i*4+j>n-1){//exceed the n characters limit
                    return total+j;
                }else{
                    buf[i*4+j]=buf4[j];   
                }         
            }
            total+=num;
        }
        return total;
    }
}
