package DynamicProgramming;

import java.util.Arrays;

public class nonadjacentSum {
    public static void main(String[] args) {
        int []arr={5,2,1,4,3};
        // Recursion Approach
        long start=System.nanoTime();
        int sum=solveRecu(arr,arr.length-1);
        long end=System.nanoTime();
        System.out.println("---------- Recursion Approach ---------------");
        System.out.println("Execution time = "+(end-start)+" ns");
        System.out.println("Maximum sum of the Array "+ Arrays.toString(arr)+" is: "+sum);

        int [] dp=new int[arr.length];
        Arrays.fill(dp,-1);
        //Tabulation Approach
        start=System.nanoTime();
        sum=solveTabu(arr,arr.length-1,dp);
        end=System.nanoTime();
        System.out.println("---------- Tabulation Approach ---------------");
        System.out.println("Execution time = "+(end-start)+" ns");
        System.out.println("Maximum sum of the Array "+ Arrays.toString(arr)+" is: "+sum);

        //Memoization Approach
        Arrays.fill(dp,0);
        start=System.nanoTime();
        sum=solveMemo(arr,dp);
        end=System.nanoTime();
        System.out.println("---------- Memoization Approach ---------------");
        System.out.println("Execu     tion time = "+(end-start)+" ns");
        System.out.println("Maximum sum of the Array "+ Arrays.toString(arr)+" is: "+sum);


        //Space Optimized Memoization Approach
        start=System.nanoTime();
        sum=solveMemoOpti(arr);
        end=System.nanoTime();
        System.out.println("---------- Space Optimized Memoization Approach ---------------");
        System.out.println("Execution time = "+(end-start)+" ns");
        System.out.println("Maximum sum of the Array "+ Arrays.toString(arr)+" is: "+sum);
    }
    private static int solveRecu(int[]arr,int ind)
    {
        if(ind==0)
            return arr[ind];

        if(ind<0)
            return 0;


        int Pick=arr[ind]+solveRecu(arr,ind-2);
        int notPick=0+solveRecu(arr,ind-1);
        return Math.max(Pick,notPick);
    }



    private static int solveTabu(int[]arr,int ind,int[]dp)
    {
        if(ind==0)
            return arr[ind];

        if(ind<0)
            return 0;


        if(dp[ind]!=-1)
            return dp[ind];

        int Pick=arr[ind]+solveTabu(arr,ind-2,dp);
        int notPick=0+solveTabu(arr,ind-1,dp);
        return dp[ind]=Math.max(Pick,notPick);
    }


    private static int solveMemo(int[]arr,int[]dp)
    {
        dp[0]=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            int take=arr[i]+(i>1?dp[i-2]:0);
            int notTake=0+dp[i-1];
            dp[i]=Math.max(take,notTake);
        }
        return dp[arr.length-1];
    }


    private static int solveMemoOpti(int[]arr)
    {
        int prev=arr[0];
        int prevprev=0;
        for (int i=1;i<arr.length;i++)
        {
            int take=arr[i]+(i>1?prevprev:0);
            int notTake=0+prev;
            int curr=Math.max(take,notTake);
            prevprev=prev;
            prev=curr;
        }
        return prev;
    }
}
