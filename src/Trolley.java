import java.util.Arrays;
import java.util.Comparator;

public class Trolley {
    static int findMaxProducts(int [][]trollies)
    {
        Arrays.sort(trollies, Comparator.comparingInt(t->t[1]));
        int n=trollies.length;
        //tabular approach
        int []dp=new int[n];
        return tabularApproach(trollies,dp);

    }
    public static void main(String[] args) {
        int n=4;
        int [][]trollys={{0,2,4},{0,4,9},{2,4,6},{5,10,20}};
        System.out.println(findMaxProducts(trollys));
    }

    private static int tabularApproach(int[][]trollies,int[]dp)
    {
        int n=trollies.length;
        dp[0]=trollies[0][2];
        for(int i=1;i<n;i++)
        {
            int take=trollies[i][2];
            int j;
            for(j=i-1;j>=0;j--)
                if(trollies[j][1]<=trollies[i][0])
                    break;

            if(j!=-1)
                take+=dp[j];

            int notTake=dp[i-1];
            dp[i]=Math.max(take,notTake);
        }
        return dp[n-1];
    }
    private static int findMaxProductsRecursion(int[][]trollies,int index,int[]memo)
    {
        if(index<0)
            return 0;

        if(memo[index]!=-1)
            return memo[index];

        int notTake=findMaxProductsRecursion(trollies,index-1,memo);
        int take=trollies[index][2];
        int nextCompatible=findCompatible(trollies,index);
        if(nextCompatible!=-1)
            take+=findMaxProductsRecursion(trollies,nextCompatible,memo);
        memo[index]=Math.max(take,notTake);
        return memo[index];

    }
    private static int findCompatible(int[][]trollies,int index)
    {
        for(int j=index-1;j>=0;j--)
        {
            if(trollies[j][1]<=trollies[index][0])
                return j;
        }
        return -1;
    }


}
