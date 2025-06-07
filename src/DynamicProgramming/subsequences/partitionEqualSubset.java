package DynamicProgramming.subsequences;

public class partitionEqualSubset {
    static int[]arr={1,2,3,6};

    public static void main(String[] args) {
        int totalSum=0;
        for(int e:arr)
            totalSum+=e;

        if(totalSum%2==1)
            System.out.println(false);
        else
            System.out.println(f(totalSum/2));
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
}
