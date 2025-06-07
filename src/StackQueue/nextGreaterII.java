package StackQueue;

import java.util.Stack;

public class nextGreaterII {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int ind=nums.length-1;
        int n=nums.length;
        int []nge=new int[n];
        for(int i=2*nums.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && nums[i%n]>=st.peek())
                st.pop();
            if(i<nums.length)
                nge[ind--]=(st.isEmpty())?-1:st.peek();
            st.push(nums[i%n]);
        }
        return nge;
    }
}
