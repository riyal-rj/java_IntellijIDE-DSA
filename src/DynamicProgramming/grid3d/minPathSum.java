package DynamicProgramming.grid3d;
import java.util.Arrays;

import static java.lang.Math.*;
public class minPathSum {
    public static void main(String[] args) {
        int matrix[][] = {
                {5, 9, 6},
                {11, 5, 2}
        };

        int m = matrix.length;
        int n = matrix[0].length;
        //System.out.println(m+""+n);
        System.out.println("Minimum Cost = "+minSumPathRecu(m-1,n-1,matrix));
        int [][]dp=new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dp[i],-1);
        System.out.println(minSumPathMemo(m-1,n-1,matrix,dp));

        System.out.println(minSumPathTabu(m,n,matrix));

    }
    static int minSumPathRecu(int m, int n, int[][] matrix) {
        if(m==0 && n==0)
            return matrix[0][0];

        if(m<0 || n<0)
            return 99999999;


        int upCost=matrix[m][n]+minSumPathRecu(m,n-1,matrix);
        int leftCost=matrix[m][n]+minSumPathRecu(m-1,n,matrix);
        return min(upCost,leftCost);
    }

    static int minSumPathMemo(int m,int n,int[][]matrix,int[][]dp)
    {
        if(m==0 && n==0)
            return matrix[0][0];

        if(m<0 || n<0)
            return 99999999;

        if(dp[m][n]!=-1)
            return dp[m][n];

        int upCost=matrix[m][n]+minSumPathMemo(m,n-1,matrix,dp);
        int leftCost=matrix[m][n]+minSumPathMemo(m-1,n,matrix,dp);
        return dp[m][n]=min(upCost,leftCost);
    }


    static int minSumPathTabu(int m,int n,int[][]matrix)
    {
        int [][]dp=new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dp[i],0);


        dp[0][0]=matrix[0][0];
        for(int r=0;r<m;r++)
        {
            for(int c=0;c<n;c++)
            {
                if(r==0 && c==0)
                    continue;
                else {
                    int upCost=matrix[r][c];
                    int leftCost=matrix[r][c];
                    if(c>0)upCost+=dp[r][c-1];
                    else upCost+=999999;
                    if(r>0)leftCost+=dp[r-1][c];
                    else leftCost+=999999;
                    dp[r][c]=min(upCost,leftCost);
                }
            }
        }
        return dp[m-1][n-1];
    }
}
