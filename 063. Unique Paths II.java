class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
    	if(m== 0) return 0;
        int n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];
        if(obstacleGrid[0][0] == 0) memo[0][0] = 1;
        for(int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] != 0) break;
            memo[i][0] = memo[0][0];
            
        }
        for(int j = 1; j < n; j++) {
            if(obstacleGrid[0][j] != 0) break;
            memo[0][j] = memo[0][0];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 0) memo[i][j] = memo[i][j - 1] + memo[i - 1][j];
            }
        }
        return memo[m - 1][n - 1];
    }
}