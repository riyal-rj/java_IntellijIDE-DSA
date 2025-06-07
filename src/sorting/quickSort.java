package sorting;

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
        int arr[]={1,0,-6,65,7,100};
        System.out.println("Original Array: "+ Arrays.toString(arr));
        quickSort(arr,0,5);
        System.out.println("Sorted Array: "+ Arrays.toString(arr));
    }
    static void swap(int []nums,int ind1,int ind2)
    {
        int temp=nums[ind1];
        nums[ind1]=nums[ind2];
        nums[ind2]=temp;
    }
    static int LomutoPartition(int []nums,int low,int high)
    {
        int i=low-1;
        //int pivot=nums[high];
        for(int j=low;j<high;j++)
        {
            if(nums[high]>nums[j])
            {
                i=i+1;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,high);
        return i+1;
    }
    static int HoarePartition(int []nums,int low,int high)
    {
        int i=low;
        for(int j=low+1;j<=high;j++)
        {
            if(nums[j]<nums[low])
            {
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,i,low);
        return i;
    }
    static void quickSort(int nums[],int low,int high)
    {
        if(low<high)
        {
            int pi=HoarePartition(nums,low,high);
            quickSort(nums,low,pi-1);
            quickSort(nums,pi+1,high);
        }
    }
}
