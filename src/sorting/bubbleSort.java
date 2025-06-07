package sorting;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int arr[]={1,0,-6,65,7,100};
        System.out.println("Original Array: "+ Arrays.toString(arr));
        optimizedSort(arr);
        System.out.println("Sorted Array: "+ Arrays.toString(arr));
    }
    static void sort(int []nums)
    {
        int n=nums.length;
        for(int i=0;i<n;i++) {
            for (int j = i; j < n - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }
    static void swap(int []nums,int ind1,int ind2)
    {
        int temp=nums[ind1];
        nums[ind1]=nums[ind2];
        nums[ind2]=temp;
    }
    static void optimizedSort(int []nums)
    {
        int n=nums.length;
        for(int i=0;i<n;i++) {
            boolean isSwapped=false;
            for (int j = i; j < n - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    swap(nums, j, j + 1);
                    isSwapped=true;
                }
            }
            if(!isSwapped)
                break;
        }
    }
}
