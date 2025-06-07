package DynamicProgramming.grid3d;

import java.util.ArrayList;
import java.util.Arrays;

public class mazeObstacles {
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}
        };

        int n = maze.length;
        int m = maze[0].length;
        System.out.println(mazeObstaclesRecu(n-1,m-1,maze));
        int [][]dp=new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        System.out.println(mazeObstaclesMemo(n-1,m-1,maze,dp));
        System.out.println(mazeObstaclesTabu(n,m,maze));

    }
    private static int mazeObstaclesRecu(int n, int m, int [][] mat) {
        if(m==0 && n==0)
            return 1;
        if(m<0 || n<0)
            return 0;
        if(m>=0 && n>=0 && mat[m][n]==-1)
            return 0;

        int up=mazeObstaclesRecu(n-1,m,mat);
        int left=mazeObstaclesRecu(n,m-1,mat);
        return left+up;
    }

    private static int mazeObstaclesMemo(int n, int m, int [][] mat, int[][]dp) {
        if(m==0 && n==0)
            return 1;
        if(m<0 || n<0)
            return 0;
        if(m>=0 && n>=0 && mat[n][m]==-1)
            return 0;
        if(dp[n][m]!=-1)
            return dp[n][m];
        int up=mazeObstaclesMemo(n-1,m,mat,dp);
        int left=mazeObstaclesMemo(n,m-1,mat,dp);
        return dp[n][m]=left+up;
    }
    private static int mazeObstaclesTabu(int n,int m,int[][]mat)
    {
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],0);
        dp[0][0]=1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0 && j==0)
                    continue;
                else if(i>=0 && j>=0 && mat[i][j]==-1)
                    dp[i][j]=0;
                else {
                    int up=0,left=0;
                    if(i>0)
                        up=dp[i-1][j];
                    if(j>0)
                        left=dp[i][j-1];
                    dp[i][j]=left+up;
                }
            }
        }
        return dp[n-1][m-1];
    }
}
