package TwoPointer;
import java.util.Map;
import java.util.HashMap;
public class subArrayWithKDiffIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
    int helper(int []nums,int k)
    {
        Map<Integer,Integer> mpp=new HashMap<>();
        int r=0,l=0,n=nums.length,count=0,sum=0;
        while(r<n)
        {
            mpp.put(nums[r],mpp.getOrDefault(nums[r],0)+1);
            while(mpp.size()>k)
            {
                mpp.put(nums[l],mpp.get(nums[l])-1);
                if(mpp.get(nums[l])==0)
                    mpp.remove(nums[l]);
                l++;
            }
            count=count+(r-l+1);
            r++;
        }
        return count;
    }
}
