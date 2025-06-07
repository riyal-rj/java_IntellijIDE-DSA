package DynamicProgramming.subsequences;

import java.util.Arrays;

public class countSubsetsTarget {
    static int[]arr={0,0,1};
    public static void main(String[] args) {
        int t=1;
        System.out.println(f(arr.length -1,t));

        int [][] dp=new int[arr.length][t+1];
        for(int []d:dp)
            Arrays.fill(d,-1);

        System.out.println(fdp(arr.length-1,t,dp ));

        System.out.println(f(t));

    }
    static int f(int ind,int target)
    {
        if(ind==0)
            return arr[ind]==target?1:0;

        if(target==0)
            return 1;

        int notPick=f(ind-1,target);
        int pick=0;
        if(arr[ind]<=target)
            pick=f(ind-1,target-arr[ind]);


        return pick+notPick;
    }
    static int fdp(int ind,int target,int[][]dp)
    {
        if(ind==0){

                if(target==0 && arr[0]==0)
                    return 2;
                if(arr[0]==target || target==0)
                    return 1;
                return 0;

        }
            //return arr[ind]==target?1:0;

//        if(target==0)
//            return 1;

        if(dp[ind][target]!=-1)
            return dp[ind][target];

        int notPick=fdp(ind-1,target,dp);
        int pick=0;
        if(arr[ind]<=target)
            pick=fdp(ind-1,target-arr[ind],dp);


        return dp[ind][target]=pick+notPick;
    }

    static int f(int tar)
    {
        int [][]dp=new int[arr.length][tar+1];
        for(int i=0;i<arr.length;i++)
            dp[i][0]=1;

        if(arr[0]<= tar)
            dp[0][arr[0]]=1;


        for(int ind=1;ind< arr.length;ind++)
        {
            for(int target=1;target<=tar;target++)
            {
                int notPick=dp[ind-1][target];
                int pick=0;
                if(arr[ind]<=target)
                    pick=dp[ind-1][target-arr[ind]];
                dp[ind][target]=pick+notPick;
            }
        }

        return dp[arr.length-1][tar];
    }
}
