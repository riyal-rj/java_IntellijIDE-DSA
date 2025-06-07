package DynamicProgramming.string;

import static java.lang.Math.max;

public class longestCommonSubstring {

	static String str1="abcopexyzm";
	static String str2="abcopfghxyzm";
	public static void main(String[] args) {
		System.out.println("Longest Common Substring Length is: "+lcs());
	}
	static int lcs()
	{
		int ans=0;
		int[][]dp=new int[str1.length()+1][str2.length()+1];
		for(int i=0;i<str1.length()+1;i++)
			dp[i][0]=0;
		
		for(int j=0;j<str2.length()+1;j++)
			dp[0][j]=0;
		
		int indI=0,indJ=0;
		
		for(int i=1;i<str1.length()+1;i++)
		{
			for(int j=1;j<str2.length()+1;j++)
			{
				if(str1.charAt(i-1)==str2.charAt(j-1))
				{
					dp[i][j]=1+dp[i-1][ j-1];
					if(dp[i][j]>ans)
					{
						indI=i;
						indJ=j;
						ans=dp[i][j];
					}
					
				}
				else
					 dp[i][j]=0;
			}
		}
		System.out.println("Longest Common Substring is:   "+print(indI,indJ));
		return ans;
		
	}
	
	static String print(int i,int j)
	{
		String str="";
		while(i>0 && j>0 && str1.charAt(i-1)==str2.charAt(j-1) )
		{	
			
			str=str1.charAt(i-1)+str;
			i--;
			j--;
		}
		return str;
	}


}
