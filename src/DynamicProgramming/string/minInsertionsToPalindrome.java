package DynamicProgramming.string;

import static java.lang.Math.max;

public class minInsertionsToPalindrome {

	public static void main(String[] args) {
		StringBuilder sb1=new StringBuilder("abcaa");
		System.out.println("Minimum Insertions to Make Palindrome:   "+(sb1.length()-lcs(sb1.toString(),sb1.reverse().toString())));

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
		return dp[str1.length()][str2.length()];
		
	}
}
