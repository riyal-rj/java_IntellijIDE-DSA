package DynamicProgramming.subsequences;

import java.util.Arrays;

public class subsetSumTarget {
    static final int arr[]={1,2,3,4};
    public static void main(String[] args) {
        int n= arr.length;
        int target=4;
        System.out.println(fRecu(n-1,target));

        int dp[][]=new int[n][target+1];
        for(int d[]:dp)
        Arrays.fill(d,-1);
        System.out.println(fMemo(n-1,target,dp));

        System.out.println(f(target));

    }

    static boolean fMemo(int ind,int target,int[][]dp)
    {
        if(ind==0)
            return arr[0]==target;

        if(target==0)
            return true;

        if(dp[ind][target]!=-1)
            return dp[ind][target]==0?false:true;

        boolean notPick=fMemo(ind-1,target,dp);
        boolean pick= false;

        if(target>=arr[ind])
            pick=fMemo(ind-1,target-arr[ind],dp);

        dp[ind][target]=(notPick || pick)?1:0;
        return notPick||pick;

    }

    static boolean f(int target)
    {
        boolean [][]dp=new boolean[arr.length][target+1];

        for(int i=0;i<arr.length;i++)
            dp[i][0]=true;


        if(arr[0]<=target)
            dp[0][arr[0]]=true;


        for(int ind=1;ind<arr.length;ind++)
        {
            for(int targ=1;targ<=target;targ++)
            {
                boolean notPick=dp[ind-1][targ];
                boolean pick=false;
                if(arr[ind]<=targ)
                    pick=dp[ind-1][targ-arr[ind]];

                dp[ind][targ]=pick||notPick;
            }
        }
        return dp[arr.length-1][target];

    }

    static boolean fRecu(int ind,int target)
    {
        if(ind==0)
            return arr[0]==target;

        if(target==0)
            return true;

        boolean notPick=fRecu(ind-1,target);
        boolean pick= false;

        if(target>=arr[ind])
            pick=fRecu(ind-1,target-arr[ind]);

        return notPick || pick;
    }

}
