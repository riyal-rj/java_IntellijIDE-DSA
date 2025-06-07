package DynamicProgramming.string;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Math.*;
public class longestCommonSubsequence {

	static String str1;
	static String str2;
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter two Strings:  ");
		str1=br.readLine();//abcde
		str2=br.readLine();//bdgek
		
		int l1=str1.length();
		int l2=str2.length();
		
		System.out.println("Longest Common Subsequence: "+lcSubsequence(l1-1, l2-1));
		
		
		int [][]dp=new int[l1+1][l2+1];
		for(int[]d:dp)
			Arrays.fill(d, -1);
		
		System.out.println("Longest Common Subsequence: "+lcSubsequence(l1, l2,dp));
		printLCS(dp);
		
		System.out.println(lcs());
	}
	static int lcs()
	{
		int[][]dp=new int[str1.length()+1][str2.length()+1];
		for(int i=0;i<str1.length()+1;i++)
			dp[i][0]=0;
		
		for(int j=0;j<str2.length()+1;j++)
			dp[0][j]=0;
		
		
		for(int i=1;i<str1.length()+1;i++)
		{
			for(int j=1;j<str2.length()+1;j++)
			{
				if(str1.charAt(i-1)==str2.charAt(j-1))
					dp[i][j]=1+dp[i-1][ j-1];
				else
					 dp[i][j]= max(dp[i-1][j],dp[i][j-1]);
			}
		}
		printLCS(dp);
		return dp[str1.length()][str2.length()];
		
	}
	static int lcSubsequence(int i,int j,int[][]dp)
	{
		if(i==0 || j==0)
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];
		
		if(str1.charAt(i-1)==str2.charAt(j-1))
			return dp[i][j]=1+lcSubsequence(i-1, j-1,dp);
		else
			return dp[i][j]= max(lcSubsequence(i-1, j,dp),lcSubsequence(i, j-1,dp));

	}
	static int lcSubsequence(int len1,int len2)
	{
		if(len1<0 || len2<0)
			return 0;
		
		
		if(str1.charAt(len1)==str2.charAt(len2))
			return 1+lcSubsequence(len1-1, len2-1);
		else
			return max(lcSubsequence(len1-1, len2),lcSubsequence(len1, len2-1));
		
	}
	
	static void  printLCS(int[][]dp)
	{
		int len=dp[str1.length()-1][str2.length()-1];
		
		String str="";
		int i=str1.length(),j=str2.length();
		
		while(i>0 && j>0)
		{
			if(str1.charAt(i-1)==str2.charAt(j-1))
			{
				str=str1.charAt(i-1)+str;
				i--;
				j--;
			}
			else
			{
				if(dp[i-1][j]>dp[i][j-1])
				{
					i--;
				}
				else
				{
					j--;
				}
			}
		}
		System.out.println("LCS "+str);
	}
	
}
