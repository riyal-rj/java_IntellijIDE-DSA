package DynamicProgramming.grid3d;
import java.util.Arrays;

import static java.lang.Math.*;
public class triangleGrids {
    public static void main(String[] args) {
        int triangle[][] = {{1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}};

        int n = triangle.length;
        System.out.println(solveMinPathTriangle(triangle,0,0));
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);

        System.out.println(solveMemo(triangle,0,0,dp));

        System.out.println(solveTabulation(triangle));
    }

    static int solveMinPathTriangle(int[][]triangle,int m,int n)
    {
        if(m==triangle.length-1)
            return triangle[m][n];



        int downCost=triangle[m][n]+solveMinPathTriangle(triangle,m+1,n);
        int diagonalCost=triangle[m][n]+solveMinPathTriangle(triangle,m+1,n+1);

        return min(downCost,diagonalCost);
    }


    static int solveMemo(int[][] triangle ,int i,int j,int [][]dp)
    {
        if (i==triangle.length-1)
            return triangle[i][j];


        if(dp[i][j]!=-1)
            return dp[i][j];

        int downCost=triangle[i][j]+solveMemo(triangle,i+1,j,dp);
        int diagonalCost=triangle[i][j]+solveMemo(triangle,i+1,j+1,dp);

        return dp[i][j]=min(diagonalCost,downCost);

    }

    static int solveTabulation(int[][]triangle)
    {
        int dp[][]=new int[triangle.length][triangle.length];
        for(int j=0;j<triangle.length;j++)
            dp[triangle.length-1][j]=triangle[triangle.length-1][j];

        for(int i=triangle.length-2;i>=0;i--)
        {
            for(int j=i;j>=0;j--)
            {
                int down=triangle[i][j]+dp[i+1][j];
                int diag=triangle[i][j]+dp[i+1][j+1];
                dp[i][j]=min(diag,down);
            }
        }
        return dp[0][0];
    }

}
