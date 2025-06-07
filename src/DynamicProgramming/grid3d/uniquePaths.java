package DynamicProgramming.grid3d;

import java.util.Arrays;

public class uniquePaths {
    private static int uniquePathsRecu(int m, int n) {
        if(m==0 && n==0)
            return 1;
        if(m<0 || n<0)
            return 0;
        int up=uniquePathsRecu(m-1,n);
        int left=uniquePathsRecu(m,n-1);
        return up+left;
    }

    private static int uniquePathsMemo(int m, int n,int [][]dp) {
        if(m==0 && n==0)
            return 1;
        if(m<0 || n<0)
            return 0;
        if(dp[m][n]!=-1)
            return dp[m][n];
        int up=uniquePathsRecu(m-1,n);
        int left=uniquePathsRecu(m,n-1);
        return dp[m][n]=up+left;
    }

    private static int uniquePathTabu(int[][]dp)
    {
        dp[0][0]=1;
        int up=0,left=0;
        for(int r=0;r<dp[0].length;r++)
        {
            for(int c=0;c<dp.length;c++)
            {
                if(r==0 && c==0)
                    continue;
                else {
                    up=0;left=0;
                    if(r>0)
                         up=dp[r-1][c];
                    if(c>0)
                        left=dp[r][c-1];
                    dp[r][c]=left+up;
                }
            }
        }
        return dp[dp[0].length-1][dp.length-1];
    }

    public static void main(String[] args) {

        int path[][]={{3,2},{1,6}};
        int m=path[0].length;
        int n=path.length;
        System.out.println("No of Unique Paths:  "+uniquePathsRecu(m-1,n-1));
        int [][]dp=new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dp[i],-1);
        System.out.println(uniquePathsMemo(m-1,n-1,dp));

        for(int i=0;i<m;i++)
            Arrays.fill(dp[i],0);
        System.out.println(uniquePathTabu(dp));
    }
}
