/*
 * [535] Encode and Decode TinyURL
 *
 * https://leetcode.com/problems/encode-and-decode-tinyurl/description/
 *
 * algorithms
 * Medium (74.05%)
 * Total Accepted:    47K
 * Total Submissions: 63.4K
 * Testcase Example:  '"https://leetcode.com/problems/design-tinyurl"'
 *
 * Note: This is a companion problem to the System Design problem: Design
 * TinyURL.
 * 
 * TinyURL is a URL shortening service where you enter a URL such as
 * https://leetcode.com/problems/design-tinyurl and it returns a short URL such
 * as http://tinyurl.com/4e9iAk.
 * 
 * Design the encode and decode methods for the TinyURL service. There is no
 * restriction on how your encode/decode algorithm should work. You just need
 * to ensure that a URL can be encoded to a tiny URL and the tiny URL can be
 * decoded to the original URL.
 * 
 */
public class Codec {
    private Map<String, String> map=new HashMap<>();//(Key, originalUrl)
    private int KEYLENGTH=6;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key=generateKey();
        map.put(key, longUrl);
        return key;
    }
    private String generateKey(){
        String list="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random r=new Random();
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<KEYLENGTH; i++){
            sb.append(list.charAt(r.nextInt(62)));
        }
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
