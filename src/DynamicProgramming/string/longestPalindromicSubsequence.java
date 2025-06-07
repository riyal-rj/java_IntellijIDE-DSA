package DynamicProgramming.string;

import static java.lang.Math.max;

public class longestPalindromicSubsequence {

	
	public static void main(String[] args) {
		
		StringBuilder sb1=new StringBuilder("bbabcbcab");
		System.out.println("Length of Longest Palindromic Subsequence:  "+lcs(sb1.toString(),sb1.reverse().toString()));
	}
	static int lcs(String str1,String str2)
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
		printLCS(dp,str1,str2);
		return dp[str1.length()][str2.length()];
		
	}
	static void  printLCS(int[][]dp,String str1,String str2)
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
		System.out.println("Longest Palindormic Subsequence is  "+str);
	}
}
