package TwoPointer;
import static java.lang.Math.*;
public class slidingWindowMaximum {
    static int[] maximum(int []nums,int k)
    {
        int n=nums.length;
        int []result=new int[n-k+1];
        int []leftMax=new int[n];
        int []rightMax=new int[n];
        for(int i=0;i<n;i++)
        {
            if(i%k==0)
                leftMax[i]=nums[i];
            else
                leftMax[i]=max(leftMax[i-1],nums[i]);

            int j=n-i-1;
            if((j+1)% k==0 || j==n-1)
                rightMax[j]=nums[j];
            else
                rightMax[j]=max(rightMax[j+1],nums[j]);

        }
        for(int i=0;i<n-k+1;i++)
            result[i]=max(rightMax[i],leftMax[i+k-1]);

        return result;
    }
}
