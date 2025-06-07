package sorting;

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int arr[]={1,0,-6,65,7,100};
        System.out.println("Original Array: "+ Arrays.toString(arr));
        mergeSort(arr,0,5);
        System.out.println("Sorted Array: "+ Arrays.toString(arr));
    }
    static void mergeSort(int []nums,int low,int high)
    {
        if(low==high)
            return;
        int mid=((high-low)/2+low);
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }
    static void merge(int[]nums,int low,int mid,int high)
    {
        int start1=low,start2=mid+1;
        int ind=0;
        int arr[]=new int [high-low+1];
        while(start1<=mid && start2<=high)
            arr[ind++]=(nums[start1]<nums[start2])?nums[start1++]:nums[start2++];
        while(start1<=mid)
           arr[ind++]=nums[start1++];
        while(start2<=high)
            arr[ind++]=nums[start2++];
        for(int i=0;i<high-low+1;i++)
            nums[i+low]=arr[i];
    }
}
