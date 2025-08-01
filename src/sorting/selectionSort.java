package sorting;

import java.util.Arrays;

public class selectionSort {
    public static void main(String[] args) {
        int arr[]={1,0,-6,65,7,100};
        System.out.println("Original Array: "+ Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted Array: "+ Arrays.toString(arr));
    }
    static void sort(int []nums)
    {
        int n=nums.length;
        for(int i=0;i<n;i++) {
            int minInd=i;
            for(int j=i+1;j<n;j++)
            {
                if(nums[minInd]>nums[j])
                    minInd=j;
            }
            swap(nums,minInd,i);
        }
    }
    static void swap(int []nums,int ind1,int ind2)
    {
        int temp=nums[ind1];
        nums[ind1]=nums[ind2];
        nums[ind2]=temp;
    }
}
