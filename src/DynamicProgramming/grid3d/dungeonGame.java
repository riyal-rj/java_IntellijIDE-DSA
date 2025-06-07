package DynamicProgramming.grid3d;

public class dungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        int n=dungeon[0].length;
        int [][]dp=new int [m][n];
        dp[m-1][n-1]=Math.max(-dungeon[m-1][n-1]+1,1);
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);
        }
        for(int i=m-2;i>=0;i--)
        {
            for(int j=n-2;j>=0;j--)
            {
                int moveRight=dp[i][j+1];
                int moveDown=dp[i+1][j];
                int minHealth=Math.min(moveRight,moveDown);
                dp[i][j]=Math.max(minHealth-dungeon[i][j],1);
            }
        }
        return dp[0][0];
    }
}
