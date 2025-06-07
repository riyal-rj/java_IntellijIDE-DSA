package DynamicProgramming.subsequences;
import static java.lang.Math.*;

import java.util.Arrays;
public class rodCutting {
	
	static int orglengthOfRod=5;
	static int[]price= {2,5,7,8,10};
	public static void main(String[] args) {
		int n=price.length-1;
		long start=System.nanoTime();
		System.out.println(rodCut(n,orglengthOfRod));
		
		long end=System.nanoTime();
		
		System.out.println("Execution time: "+(end-start));
		
		
		int[][]dp=new int[orglengthOfRod][orglengthOfRod+1];
		start=System.nanoTime();
		for(int[]d:dp)
			Arrays.fill(d, -1);
		System.out.println(rodCut(n,orglengthOfRod,dp));
		end=System.nanoTime();
		System.out.println("Execution time: "+(end-start));
		
		start=System.nanoTime();
		System.out.println(rodCut());
		end=System.nanoTime();
		System.out.println("Execution time: "+(end-start));
		
	}
	
	static int rodCut()
	{
		int[][]dp=new int[price.length][orglengthOfRod+1];
		
		for(int l=0;l<orglengthOfRod;l++)
			dp[0][l]=l*price[0];
		
		for(int ind=1;ind< price.length;ind++)
		{
			for(int len=0;len<orglengthOfRod+1;len++)
			{
				int notTake=dp[ind-1][len];
				int currRodLength=ind+1;
				int Take=Integer.MIN_VALUE;
				if(currRodLength<=len)
					Take=price[ind]+dp[ind][len-currRodLength];
				
				dp[ind][len]= max(Take,notTake);
			}
		}
		return dp[price.length-1][orglengthOfRod];
		
	}
	static int rodCut(int ind,int N)
	{
		if(ind==0)
		{
			return N*price[0];
		}
		
		int notTake=rodCut(ind-1,N);
		int currRodLength=ind+1;
		int Take=Integer.MIN_VALUE;
		if(currRodLength<=N)
			Take=price[ind]+rodCut(ind,N-currRodLength);
		
		return max(Take,notTake);
	}
	static int rodCut(int ind,int N,int[][]dp)
	{
		if(ind==0)
		{
			return N*price[0];
		}
		if(dp[ind][N]!=-1)
			return dp[ind][N];
		int notTake=rodCut(ind-1,N,dp);
		int currRodLength=ind+1;
		int Take=Integer.MIN_VALUE;
		if(currRodLength<=N)
			Take=price[ind]+rodCut(ind,N-currRodLength,dp);
		
		return dp[ind][N]= max(Take,notTake);
	}
	
	
	

}
