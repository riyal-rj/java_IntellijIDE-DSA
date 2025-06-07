package DynamicProgramming.grid3d;
import static java.lang.Math.*;
import java.util.Arrays;

public class maxFallPathSum {

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}};

        System.out.println(getMaxPathSum(matrix));
        System.out.println(getMaxUtilTabu(matrix));
    }

    static int getMaxUtilRecu(int i,int j,int [][]matrix)
    {
        if(j<0 || j>=matrix[0].length)
            return (int)-1e9;

        if(i==0)
            return matrix[0][j];

        int up=matrix[i][j]+getMaxUtilRecu(i-1,j,matrix);
        int ld=matrix[i][j]+getMaxUtilRecu(i-1,j-1,matrix);
        int rd=matrix[i][j]+getMaxUtilRecu(i-1,j+1,matrix);

        return max(up,max(ld,rd));
    }


    static int getMaxUtilMemo(int i,int j,int [][]matrix,int[][]dp)
    {
        if(j<0 || j>=matrix[0].length)
            return (int)-1e9;

        if(i==0)
            return matrix[0][j];

        if(dp[i][j]!=-1)
            return dp[i][j];
        int up=matrix[i][j]+getMaxUtilMemo(i-1,j,matrix,dp);
        int ld=matrix[i][j]+getMaxUtilMemo(i-1,j-1,matrix,dp);
        int rd=matrix[i][j]+getMaxUtilMemo(i-1,j+1,matrix,dp);

        return dp[i][j]=max(up,max(ld,rd));
    }


    static int getMaxUtilTabu(int[][]matrix)
    {
        int m=matrix.length;
        int n=matrix[0].length;
        int [][]dp=new int[m][n];
        for(int row[]:dp)
            Arrays.fill(row,0);
        for(int j=0;j<n;j++)
            dp[0][j]=matrix[0][j];


        for(int i=1;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int up=matrix[i][j]+dp[i-1][j];

                int ld=matrix[i][j];
                int rd=matrix[i][j];
                if(j-1>=0)
                    ld+=dp[i-1][j-1];
                else ld+=(int)-1e9;
                if(j+1<m)
                    rd+=dp[i-1][j+1];
                else rd+=(int)-1e9;

                dp[i][j]=max(max(ld,rd),up);
            }
        }

        int maxi=(int)-1e9;
        for(int j=0;j<n;j++)
            maxi=max(maxi,dp[m-1][j]);

        return maxi;
    }
    static int getMaxPathSum(int[][]matrix)
    {

        int m=matrix.length;
        int n=matrix[0].length;


        int dp[][]=new int[m][n];
        for(int row[]:dp)
            Arrays.fill(row,-1);

        int maxi=(int)-1e9*9;

        for(int j=0;j<n;j++){
            int  ans= getMaxUtilMemo(m-1,j,matrix,dp);
            maxi=Math.max(maxi,ans);
        }


        return maxi;
    }



}
