package StackQueue;
import static java.lang.Math.*;
public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        int [][]prefix=new int[matrix.length][matrix[0].length];
        int sum=0;
        for(int j=0;j<matrix[0].length;j++)
        {
            for(int i=0;i< matrix.length;i++)
            {
                if(matrix[i][j]=='1')
                    sum+=1;
                if(matrix[i][j]=='0')
                    sum=0;
                prefix[i][j]=sum;
            }
        }
        largestRectangleHistogramArea obj=new largestRectangleHistogramArea();
        int maxArea=0;
        for(int arr[]:prefix)
        {
            maxArea=max(maxArea,obj.largestRectangleArea(arr));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalRectangle(matrix));
    }
}
