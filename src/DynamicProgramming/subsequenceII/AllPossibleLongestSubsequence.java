package DynamicProgramming.subsequenceII;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AllPossibleLongestSubsequence {
    List<List<Integer>> solve(int []nums)
    {
        int n=nums.length;
        int []dp=new int[n];
        Arrays.fill(dp,1);

        int maxLength=1;
        for(int currInd=0;currInd<n;currInd++)
        {
            for(int prevInd=0;prevInd<currInd;prevInd++)
            {
                if(nums[currInd]>nums[prevInd] && 1+dp[prevInd]>dp[currInd])
                    dp[currInd]=1+dp[prevInd];
            }
            maxLength=Math.max(maxLength,dp[currInd]);
        }


        List<List<Integer>> result=new ArrayList<>();
        List<Integer> path=new LinkedList<>();

        findAllLIS(nums,path,result,Integer.MAX_VALUE,dp,n-1,maxLength);
        return result;

    }
    private void findAllLIS(int []nums,List<Integer>path,List<List<Integer>>result,int prevNum,int []dp,int index,int length)
    {
        if(length==0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i>=0;i--)
        {
            if(dp[i]==length && nums[i]<prevNum) {
                path.addFirst(nums[i]);
                findAllLIS(nums,path,result,nums[i],dp,i-1,length-1);
                path.removeFirst();
            }
        }
    }

    public static void main(String[] args) {
        int []nums= {10,9,2,5,3,7,101,18};
        AllPossibleLongestSubsequence obj=new AllPossibleLongestSubsequence();
        List<List<Integer>> lisSequences=obj.solve(nums);
        for(List<Integer> seq:lisSequences)
            System.out.println(seq);
    }
}
