package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class kClosest {
    public static void main(String[] args) {
        int []arr1={1,2,3,4,5};
        kClosest obj=new kClosest();
        System.out.println(obj.findClosestElements(arr1,4,3));
        System.out.println(obj.solve(arr1,3,4));
        int []arr2={1,1,2,3,4,5};
        System.out.println(obj.findClosestElements(arr2,4,-1));

    }
    List<Integer> findClosestElements(int[] arr, int k, int x)
    {
        PriorityQueue<Pair> maxHeap=new PriorityQueue<>((p1,p2)-> p2.key!=p1.key?p2.key-p1.key:p2.value-p1.value);
        List<Integer> result=new ArrayList<>();
        for(int i=0;i< arr.length;i++)
        {
            maxHeap.add(new Pair(Math.abs(arr[i]-x),arr[i]));
            if(maxHeap.size()>k)
                maxHeap.poll();
        }
        while(!maxHeap.isEmpty())
        {
            result.add(maxHeap.poll().value);
        }
        Collections.sort(result);
        return result;
    }
    class Pair
    {
        int key;
        int value;
        Pair(int key,int value)
        {
            this.key=key;
            this.value=value;
        }
    }

    List<Integer> solve(int []arr, int x, int k)
    {
        int left=0,right=arr.length-k;
        while(left<right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        List<Integer> res=new ArrayList<>();
        int ind=0;
        for(int i=left;i<left+k;i++)
            res.add(arr[i]);
        return res;
    }
}
