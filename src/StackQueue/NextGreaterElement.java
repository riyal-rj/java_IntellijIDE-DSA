package StackQueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement{
    static int []nextGreater(int []nums)
    {
        int []nge=new int[nums.length];
        Stack<Integer> st=new Stack<>();
        int ind= nums.length-1;
        for(int i= nums.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && nums[i]>=st.peek())
                st.pop();
            if(st.isEmpty())
                nge[ind--]=-1;
            else
                nge[ind--]=st.peek();

            st.push(nums[i]);
        }
        return nge;
    }

    public static void main(String[] args) {
        int []nums={4,12,5,3,1,2,5,3,1,2,4,6};
        System.out.println(Arrays.toString(nextGreater(nums)));
    }
}
