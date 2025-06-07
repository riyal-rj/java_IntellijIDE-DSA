package StackQueue;

import java.util.Stack;

public class stockSpanner {
    Stack<int []> st;
    int ind;
    stockSpanner()
    {
        st=new Stack<>();
        ind=-1;
    }
    int next(int val)
    {
        ind+=1;
        while(!st.isEmpty() && st.peek()[0]<=val)
            st.pop();

        int ans=ind-(st.isEmpty()?-1:st.peek()[1]);
        st.push(new int[]{val,ind});
        return ans;
    }
}
