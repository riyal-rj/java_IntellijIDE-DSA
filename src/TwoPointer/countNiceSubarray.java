package TwoPointer;

public class countNiceSubarray {
    public int numberOfSubarrays(int[] nums, int k) {
        int count=0;
        int l=0,r=0;
        int c=0;
        while(r<nums.length)
        {
            if(nums[r]%2==1)
                c++;
            if(c>k)
            {
                if(nums[l]%2==1)
                    c--;
                l++;
            }
            if(c==k)
                count++;
            r++;
        }
        return count;
    }
}
