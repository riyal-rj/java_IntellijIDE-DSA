package StackQueue;

import java.util.Stack;

import static java.lang.Math.*;

public class largestRectangleHistogramArea {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<heights.length;i++)
        {
            while(!st.isEmpty() && heights[st.peek()]>heights[i])
            {
             int ind=st.pop();
             int nse=i;
             int pse=st.isEmpty()?-1:st.peek();
             maxArea=max(heights[ind]*(nse-pse-1),maxArea);
            }
            st.push(i);
        }
        while (!st.isEmpty())
        {
            int ind=st.pop();
            int nse= heights.length;
            int pse=st.isEmpty()?-1:st.peek();
            maxArea=max(heights[ind]*(nse-pse-1),maxArea);
        }
        return maxArea;
    }

    int bruteforce(int []heights)
    {
        int []nse=subArrayMinimumSum.nextSmaller(heights);
        int []pse=subArrayMinimumSum.prevSmaller(heights);
        int maxArea=0;
        for(int i=0;i<heights.length;i++)
        {
            maxArea=max(maxArea,heights[i]*(nse[i]-pse[i]-1));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        largestRectangleHistogramArea obj=new largestRectangleHistogramArea();
        int []arr={2,1,5,6,2,3};
        System.out.println(obj.largestRectangleArea(arr));
        System.out.println(obj.bruteforce(arr));
    }
}
