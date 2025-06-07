package DynamicProgramming.string.level2;

import java.util.Arrays;

public class wildCardMatching {
	static String s1="abc";
	static String s2="abc";

	public static void main(String[] args) {
		 int m=s1.length();
		 int n=s2.length();
		 if(f(m-1,n-1))
			 System.out.println("The string s1= "+s1+" and s2= "+s2+ " has matched successfully   :) ");
		 else
			 System.out.println("The string s1= "+s1+" and s2= "+s2+ " has not matched   :< ");
		 
		 
		 int [][]dp=new int[m+1][n+1];
		 for(int []d:dp)
			 Arrays.fill(d, -1);
		 if(f(m-1,n-1,dp)==1)
			 System.out.println("The string s1= "+s1+" and s2= "+s2+ " has matched successfully   :) ");
		 else
			 System.out.println("The string s1= "+s1+" and s2= "+s2+ " has not matched   :< ");
		 
		 
		 if(f())
			 System.out.println("The string s1= "+s1+" and s2= "+s2+ " has matched successfully   :) ");
		 else
			 System.out.println("The string s1= "+s1+" and s2= "+s2+ " has not matched   :< ");
		 
		 
		 
	}
	static int f(int i,int j,int[][]dp)
	{
		if(i==0 && j==0) // if both string gets exhausted then return true
			return 1;
		if(i==0 && j>0)// if s1 string gets exhausted then we can't match hence return false
			return 0;
		if(i>0 && j==0) // if the s2 string gets exhausted then check whether s1 contains any asterisk '*' or not
		{
			for(int ii=1;ii<=i;ii++)
				if(s1.charAt(ii-1)!='*')
					return 0;
			return 1;
		}
		
		if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?')// if the both string matches or s1 has '?' then go for the next check
			return dp[i][j]=f(i-1,j-1,dp);
		
		if(s1.charAt(i-1)=='*')// if s1 contains asterisk '*' then either consider it as empty string(---> not consider '*' and go for the next character i.e. go to next i(decrease i and not j)) or reduce from s2 (---> decrease j not i)
			return dp[i][j]=f(i-1,j,dp)| f(i,j-1,dp);
		
		return 0;
			
	}

	static boolean f(int i,int j)
	{
		if(i<0 && j<0) // if both string gets exhausted then return true
			return true;
		if(i<0 && j>=0)// if s1 string gets exhausted then we can't match hence return false
			return false;
		if(i>=0 && j<0) // if the s2 string gets exhausted then check whether s1 contains any asterisk '*' or not
		{
			for(int ii=1;ii<=i;ii++)
				if(s1.charAt(ii)!='*')
					return false;
			return true;
		}
		
		if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?')// if the both string matches or s1 has '?' then go for the next check
			return f(i-1,j-1);
		
		if(s1.charAt(i)=='*')// if s1 contains asterisk '*' then either consider it as empty string(---> not consider '*' and go for the next character i.e. go to next i(decrease i and not j)) or reduce from s2 (---> decrease j not i)
			return f(i-1,j) || f(i,j-1);
		
		return false;
			
	}

	static boolean f()
	{
		int m=s1.length();
		int n=s2.length();
		boolean [][]dp=new boolean[m+1][n+1];
		
		
		dp[0][0]=true;//base case 1
		

		for(int j=1;j<=n;j++)
			dp[0][j]=false;
		
		for(int i=1;i<=m;i++)
		{
			boolean flag=true;
			for(int ii=1;ii<=i;ii++) {
				if(s1.charAt(ii-1)!='*')
				{
					flag=false;
					break;
				}					
			}
			dp[i][0]=flag;
		}
		
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?')// if the both string matches or s1 has '?' then go for the next check
					 dp[i][j]=dp[i-1][j-1];
				
				else if(s1.charAt(i-1)=='*')// if s1 contains asterisk '*' then either consider it as empty string(---> not consider '*' and go for the next character i.e. go to next i(decrease i and not j)) or reduce from s2 (---> decrease j not i)
					 dp[i][j]=dp[i-1][j]||dp[i][j-1];
				
				else 
					 dp[i][j]=false;
			}
		}
		
		return dp[m][n];
	}
		
}
