/*
 * [447] Number of Boomerangs
 *
 * https://leetcode.com/problems/number-of-boomerangs
 *
 * algorithms
 * Easy (45.44%)
 * Total Accepted:    27.7K
 * Total Submissions: 61K
 * Testcase Example:  '[[0,0],[1,0],[2,0]]'
 *
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is
 * a tuple of points (i, j, k) such that the distance between i and j equals
 * the distance between i and k (the order of the tuple matters).
 * 
 * Find the number of boomerangs. You may assume that n will be at most 500 and
 * coordinates of points are all in the range [-10000, 10000] (inclusive).
 * 
 * Example:
 * 
 * Input:
 * [[0,0],[1,0],[2,0]]
 * 
 * Output:
 * 2
 * 
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 * 
 * 
 */
/*
 * [447] Number of Boomerangs
 *
 * https://leetcode.com/problems/number-of-boomerangs
 *
 * algorithms
 * Easy (45.44%)
 * Total Accepted:    27.7K
 * Total Submissions: 61K
 * Testcase Example:  '[[0,0],[1,0],[2,0]]'
 *
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is
 * a tuple of points (i, j, k) such that the distance between i and j equals
 * the distance between i and k (the order of the tuple matters).
 * 
 * Find the number of boomerangs. You may assume that n will be at most 500 and
 * coordinates of points are all in the range [-10000, 10000] (inclusive).
 * 
 * Example:
 * 
 * Input:
 * [[0,0],[1,0],[2,0]]
 * 
 * Output:
 * 2
 * 
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 * 
 * 
 */
/*
“Distinct” means “different, unequal”.

“Pairwise” means “every pair (satisfies whatever comes after the word ‘pairwise’)”.

So, for example, “let A,B,C be pairwise distinct integers” means that A, B, C are integers and A≠B, A≠C and B≠C.
 */
class Solution {
    public int numberOfBoomerangs(int[][] points) {
    	Map<Integer, Integer> map=new HashMap<>();//(squareOfDistance, occurrences)
        int res=0;
        for(int i=0; i<points.length; i++){
 			map.clear();
        	for(int j=0; j<points.length; j++){
        		if(i==j)	continue;
        		int dis=squareOfDistance(points[i], points[j]);
        		map.put(dis, 1+map.getOrDefault(dis, 0));
        	}
        	for(int occu: map.values()){
        		res+=(occu>=2?occu*(occu-1):0);
        	}
        }
        return res;
    }
    private int squareOfDistance(int[] a, int[] b){
    	int dx=a[0]-b[0];
    	int dy=a[1]-b[1];
    	return dx*dx+dy*dy;
    }
}

