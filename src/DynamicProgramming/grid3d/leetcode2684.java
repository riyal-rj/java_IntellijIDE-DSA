package DynamicProgramming.grid3d;
import static java.lang.Math.*;

import java.util.Arrays;
public class leetcode2684 {

	public static void main(String[] args) {
		int [][]ex1= {{2,4,3,5},
					{5,4,9,3},
					{3,4,2,11},
					{10,9,13,15}};
		
		
		int [][]ex2= {{3,2,4},{2,1,9},{1,1,7}};
		
		System.out.println(solve(ex1));
		System.out.println(solve(ex2));
		
		
		System.out.println(maxMoves(ex1));
		System.out.println(maxMoves(ex2));
		
		}
	static int solve(int [][]grid)
	{
		int maxMoves=-(int)9e9;
		for(int j=0;j<grid.length;j++)
			maxMoves=max(maxMoves,f(j,0,grid));
		System.out.println("Output thorugh recursion logic: "+maxMoves);
		int [][]dp=new int [grid.length][grid[0].length];
		for(int []d:dp)
			Arrays.fill(d,-1);
		for(int j=0;j<grid.length;j++)
			maxMoves=max(maxMoves,f(j,0,grid,dp));
		System.out.println("Output thorugh memoization logic: "+maxMoves);
		return maxMoves;
	}
	static int f(int i,int j,int [][]grid)
	{
		int r=grid.length,c=grid[0].length;
		if(j==c-1)//col_index reaches the last column 
			return 0;
		int maxi=0;
		if(j+1<c && grid[i][j]<grid[i][j+1])
			maxi=max(maxi,1+f(i,j+1,grid));
		
		if(i>0 && j+1<c && grid[i][j]<grid[i-1][j+1])
			maxi=max(maxi,1+f(i-1,j+1,grid));
		
		if(i+1<r && j+1<c && grid[i][j]<grid[i+1][j+1])
			maxi=max(maxi,1+f(i+1,j+1,grid));
		
		
		return maxi;
	}
	
	static int f(int i,int j,int[][]grid,int[][]dp)
	{
		int r=grid.length,c=grid[0].length;
		if(j==c-1)//col_index reaches the last column 
			return 0;
		
		if(dp[i][j]!=-1)
			return dp[i][j];
		int maxi=0;
		if(j+1<c && grid[i][j]<grid[i][j+1])
			maxi=max(maxi,1+f(i,j+1,grid,dp));
		
		if(i>0 && j+1<c && grid[i][j]<grid[i-1][j+1])
			maxi=max(maxi,1+f(i-1,j+1,grid,dp));
		
		if(i+1<r && j+1<c && grid[i][j]<grid[i+1][j+1])
			maxi=max(maxi,1+f(i+1,j+1,grid,dp));
		
		
		return dp[i][j]=maxi;
	}
	
	static int maxMoves(int [][]grid)
	{
		int r=grid.length;
		int c=grid[0].length;
		
		int [][]dp=new int[r][c];
		
		
		for(int j=c-2;j>=0;j--)
		{
			for(int i=0;i<r;i++)
			{
				if(j+1<c && grid[i][j]<grid[i][j+1])
					dp[i][j]=max(dp[i][j],1+dp[i][j+1]);
				
				if(i>0 && j+1<c && grid[i][j]<grid[i-1][j+1])
					dp[i][j]=max(dp[i][j],1+dp[i-1][j+1]);
				
				if(i+1<r && j+1<c && grid[i][j]<grid[i+1][j+1])
					dp[i][j]=max(dp[i][j],1+dp[i+1][j+1]);
				
			}
		}
		int maxmoves=-(int)9e9;
		for(int j=0;j<r;j++)
			maxmoves=max(maxmoves,dp[j][0]);
		
		return maxmoves;
	}
}