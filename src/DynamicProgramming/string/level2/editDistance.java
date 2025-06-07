package DynamicProgramming.string.level2;
import static java.lang.Math.*;

import java.util.Arrays;
public class editDistance {
	
	static String s1="horse";
	static String s2="ros";
	public static void main(String[] args) {
		System.out.println(f(s1.length()-1,s2.length()-1));
		
		int [][]dp=new int[s1.length()+1][s2.length()+1];
		for(int[]d:dp)
			Arrays.fill(d, -1);
		System.out.println(f(s1.length()-1,s2.length()-1,dp));
		
		
		System.out.println(f());
	}
	static int f()
	{
		int [][]dp=new int[s1.length()+1][s2.length()+1];
		for(int[]d:dp)
			Arrays.fill(d, 0);
		
		
		for(int i=0;i<=s1.length();i++)
			dp[i][0]=i;
		for(int i=0;i<=s2.length();i++)
			dp[0][i]=i;
		
		
		for(int i=1;i<=s1.length();i++)
		{
			for(int j=1;j<=s2.length();j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
					dp[i][j]=dp[i-1][j-1];
				else
					dp[i][j]= min(min(1+dp[i-1][j],1+dp[i][j-1]),1+dp[i-1][j-1]);
			}
		}
		return dp[s1.length()][s2.length()];
	}
	static int f(int i,int j,int[][]dp)
	{
		if(i==0)
			return j;
		if(j==0)
			return i;
		if(dp[i][j]!=-1)
			return dp[i][j];
		if(s1.charAt(i-1)==s2.charAt(j-1))
			return dp[i][j]=f(i-1,j-1,dp);
		else
			return dp[i][j]= 1+min(min(f(i-1,j,dp),f(i,j-1,dp)),f(i-1,j-1,dp));
	}
	static int f(int i,int j)
	{
		if(i<0)
			return j+1;
		if(j<0)
			return i+1;
		
		if(s1.charAt(i)==s2.charAt(j))
			return f(i-1,j-1);
		else
			return 1+min(min(f(i-1,j),f(i,j-1)),f(i-1,j-1));
	}
}
