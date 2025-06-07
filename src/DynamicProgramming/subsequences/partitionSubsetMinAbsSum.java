package DynamicProgramming.subsequences;
import static java.lang.Math.*;
public class partitionSubsetMinAbsSum {
    static int []arr={1,2,3,4};
    public static void main(String[] args) {
        int target=7;


        int totalSum=0;
        for(int e:arr)
            totalSum+=e;
        int mini=(int)1e9;
        boolean [][]dp=new boolean[arr.length][totalSum+1];
        f(totalSum,dp);
        for(int subset1Sum=0;subset1Sum<=totalSum/2;subset1Sum++)
            mini=min(abs((totalSum-subset1Sum)-subset1Sum),mini);


        if(dp[arr.length-1][mini])
            System.out.println(mini);
        else
            System.out.println("Not Possible");

    }
    static boolean f(int target, boolean[][]dp)
    {


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
}
