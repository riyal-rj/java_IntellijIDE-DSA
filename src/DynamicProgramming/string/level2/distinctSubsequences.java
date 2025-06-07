package DynamicProgramming.string.level2;

import java.util.Arrays;

public class distinctSubsequences {

	static String s1="babgbag";
	static String s2="bag";
	public static void main(String[] args) {
		int[][]dp=new int[s1.length()][s2.length()];
		for(int[]d:dp)
			Arrays.fill(d, -1);
		System.out.println(f(s1.length()-1,s2.length()-1));
		System.out.println(f(s1.length()-1,s2.length()-1,dp));
		System.out.println(f());
	}
	static int f(int i,int j)
	{
		
		if(j<0)
			return 1;
		
		if(i<0)
			return 0;
		
		if(s1.charAt(i)==s2.charAt(j))
			return f(i-1,j-1)+f(i-1,j);
		else
			return f(i-1,j);
	}
	static int f(int i,int j,int[][]dp)
	{
		
		if(j<0)
			return 1;
		if(i<0)
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];
		if(s1.charAt(i)==s2.charAt(j))
			return dp[i][j]=f(i-1,j-1,dp)+f(i-1,j,dp);
		else
			return  dp[i][j]=f(i-1,j,dp);
	}
	
	
	static int f()
	{
		int[][]dp=new int[s1.length()+1][s2.length()+1];
		for(int i=0;i<=s1.length();i++)
			dp[i][0]=1;
		
		
		for(int i=1;i<=s1.length();i++)
		{
			for(int j=1;j<=s2.length();j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
					dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
				else
					dp[i][j]=dp[i-1][j];
			}
		}
		return dp[s1.length()][s2.length()];
	}

}
