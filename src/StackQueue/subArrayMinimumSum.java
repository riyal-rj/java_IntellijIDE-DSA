package StackQueue;

import java.util.Stack;

public class subArrayMinimumSum {

    static final int mod=(int)(1e9+7);
    static int [] nextSmaller(int []nums)
    {
        int []nse=new int[nums.length];
        int ind= nums.length-1;
        Stack<Integer> st=new Stack<>();
        for(int i= nums.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && nums[i]<nums[st.peek()])
                st.pop();

            nse[i]=st.isEmpty()? nums.length:st.peek();
            st.push(i);
        }
        return nse;
    }
    static int [] prevSmaller(int []nums)
    {
        int []pse=new int[nums.length];
        int ind=0;
        Stack<Integer> st=new Stack<>();
        for(int i= 0;i< nums.length;i++)
        {
            while(!st.isEmpty() && nums[i]<=nums[st.peek()])
                st.pop();

            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pse;
    }
    static public int sumSubarrayMins(int[] arr) {
        int []pse=prevSmaller(arr);
        int []nse=nextSmaller(arr);
        int total=0;
        for(int i=0;i<arr.length;i++)
        {
            int left=i-pse[i];
            int right=nse[i]-i;
            total+=(long)(left*right*arr[i])%mod;
        }
        return total;
    }

    public static void main(String[] args) {
        int arr1[]={3,1,2,4};
        int arr2[]={11,81,94,43,3};
        System.out.println(sumSubarrayMins(arr1));
        System.out.println(sumSubarrayMins(arr2));
    }
}
