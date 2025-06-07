package DynamicProgramming.partitions;

public class partitionArrayForMaxSum {
    public static int maxSumAfterPartitioning(int ind,int[] arr, int k) {
        if(ind==arr.length)
            return 0;
        int maxi=(int)-9e9;
        int maxAns=-(int)9e9;
        int len=0;
        for(int j=ind;j<Math.min(ind+k, arr.length);j++)
        {
            len++;
            maxi=Math.max(maxi,arr[j]);
            int ans=len*maxi + maxSumAfterPartitioning(j+1,arr,k);
            maxAns=Math.max(ans,maxAns);
        }
        return maxAns;
    }
    static int f(int ind,int []arr,int k,int []dp)
    {
        if(ind==arr.length)
            return 0;
        if(dp[ind]!=-1)
            return dp[ind];
        int maxi=(int)-9e9;
        int maxAns=-(int)9e9;
        int len=0;
        for(int j=ind;j<Math.min(ind+k, arr.length);j++)
        {
            len++;
            maxi=Math.max(maxi,arr[j]);
            int ans=len*maxi +f(j+1,arr,k,dp);
            maxAns=Math.max(ans,maxAns);
        }
        return dp[ind]=maxAns;
    }
    int f(int []arr,int k)
    {
        int n=arr.length;
        int []dp=new int[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--)
        {
            int maxi=arr[i], maxAns=-(int)9e9;
            int len=0;
            for(int j=i;j<Math.min(i+k, arr.length);j++)
            {
                len++;
                maxi=Math.max(maxi,arr[j]);
                int ans=len*maxi +dp[j+1];
                maxAns=Math.max(ans,maxAns);
            }
             dp[i]=maxAns;
        }
        return dp[0];
    }
    public static void main(String[] args) {
        System.out.println();
    }
}
