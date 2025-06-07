package StackQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class nextGreaterI {
    static int []nextGreater(int []nums1,int []nums2)
    {
        Map<Integer,Integer> mpp=new HashMap<>();
        Stack<Integer> st=new Stack<>();
        int []nge=new int[nums1.length];
        int ind= 0;
        for(int i= nums2.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && nums2[i]>=st.peek())
                st.pop();
            mpp.put(nums2[i], (st.isEmpty())?-1:st.peek());
            st.push(nums2[i]);
        }

        for(int n:nums1)
            if(mpp.containsKey(n))
                nge[ind++]=mpp.get(n);

        return nge;
    }

    public static void main(String[] args) {
        int []nums1 = {4,1,2}; int []nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreater(nums1,nums2)));
    }
}
