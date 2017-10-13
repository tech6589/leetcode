/*
 * [463] Island Perimeter
 *
 * https://leetcode.com/problems/island-perimeter
 *
 * algorithms
 * Easy (57.29%)
 * Total Accepted:    56.5K
 * Total Submissions: 98.5K
 * Testcase Example:  '[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]'
 *
 * You are given a map in form of a two-dimensional integer grid where 1
 * represents land and 0 represents water. Grid cells are connected
 * horizontally/vertically (not diagonally). The grid is completely surrounded
 * by water, and there is exactly one island (i.e., one or more connected land
 * cells). The island doesn't have "lakes" (water inside that isn't connected
 * to the water around the island). One cell is a square with side length 1.
 * The grid is rectangular, width and height don't exceed 100. Determine the
 * perimeter of the island.
 * 
 * Example:
 * 
 * [[0,1,0,0],
 * ⁠[1,1,1,0],
 * ⁠[0,1,0,0],
 * ⁠[1,1,0,0]]
 * 
 * Answer: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 * 
 * 
 * 
 */
class Solution {
    public int islandPerimeter(int[][] grid) {
        int sum=0;
        int width = grid[0].length;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<width; j++){
                if(grid[i][j]==1){
                    sum+=(4-landNum(grid, i, j));
                }
            }
        }
        return sum;
    }
    private int landNum(int[][] grid, int i, int j){
        int height=grid.length;
        int width=grid[0].length;
        int a = i-1 >= 0        ? grid[i-1][j] : 0;
        int b = i+1 < height    ? grid[i+1][j] : 0;
        int c = j+1 < width     ? grid[i][j+1] : 0;
        int d = j-1 >= 0        ? grid[i][j-1] : 0;
        return a+b+c+d;
    }
}
