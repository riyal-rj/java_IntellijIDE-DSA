package DynamicProgramming.partitions;

import java.util.Arrays;

import static java.lang.Math.min;

public class palindromePartitioningII {
     static int mincut(int ind,String s)
    {
        if(ind==s.length())
            return 0;
        int mini=(int)9e9;
        for(int j=ind;j<s.length();j++)
        {
            if(isPalin(s,ind,j))
            {
                int cost=1+mincut(j+1,s);
                mini=min(mini,cost);
            }
        }
        return mini;
    }
    static int mincut(int ind,String s,int []dp)
    {
        if(ind==s.length())
            return 0;
        if(dp[ind]!=-1)
            return dp[ind];
        int mini=(int)9e9;
        for(int j=ind;j<s.length();j++)
        {
            if(isPalin(s,ind,j))
            {
                int cost=1+mincut(j+1,s,dp);
                mini=min(mini,cost);
            }
        }
        return dp[ind]=mini;
    }
    static boolean isPalin(String s,int i,int j)
    {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;}
        return true;
        }
    static int mincut(String s)
    {
        int []dp=new int[s.length()+1];
        dp[s.length()]=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            int mini=(int)9e9;
            for(int j=i;j<s.length();j++) {
                if (isPalin(s, i, j)) {
                    int cost = 1 + dp[j + 1];
                    mini = min(mini, cost);
                }
            }
            dp[i]=mini;
        }
        return dp[0]-1;
    }
    public static void main(String[] args) {
        System.out.println(mincut(0,"bababcbadcede")-1);
        System.out.println(mincut(0,"aab")-1);
        String s="bababcbadcede";
        int []dp=new int[s.length()];
        Arrays.fill(dp,-1);
        System.out.println(mincut(0,s,dp)-1);
        System.out.println(mincut(s));
    }
}
