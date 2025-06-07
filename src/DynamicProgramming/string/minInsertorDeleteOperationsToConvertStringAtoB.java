package DynamicProgramming.string;
import static java.lang.Math.*;
public class minInsertorDeleteOperationsToConvertStringAtoB {

	public static void main(String[] args) {
		String s1="abdc";
		String s2="anc";
		
		int ans=s1.length()+s2.length()-2*lcs(s1,s2);
		System.out.println(ans);

	}
	static int lcs(String str1,String str2)
	{
		int l1=str1.length();
		int l2=str2.length();
		
		int [][] dp=new int[l1+1][l2+1];
		
		for(int i=0;i<=l1;i++)
			dp[i][0]=0;
		for(int j=0;j<=l2;j++)
			dp[0][j]=0;
		
		
		for(int i=1;i<=l1;i++)
		{
			for(int j=1;j<=l2;j++)
			{
				if(str1.charAt(i-1)==str2.charAt(j-1))
					dp[i][j]=1+dp[i-1][j-1];
				else
					dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
			}
		}
		return dp[l1][l2];
	}
}
