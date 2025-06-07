package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class circular_nonAdjacentSum {
    public static void main(String[] args) {

        int []nums={1,3,2,1};



        solveUtil(nums);
       int []nums1={190};
       solveUtil(nums1);
    }


    private static void solveUtil(int[]nums)
    {
        if(nums.length==1){
            System.out.println("Maximum Sum of Circular Array "+ Arrays.toString(nums)+" is "+nums[0]);
            return;
        }
        ArrayList<Integer> temp1=new ArrayList<>();
        ArrayList<Integer> temp2=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(i!=0)
                temp1.add(nums[i]);
            if(i!=nums.length-1)
                temp2.add(nums[i]);
        }
        System.out.println("Maximum Sum of Circular Array "+ Arrays.toString(nums)+" is "+Math.max(solveMemoOpti(temp1),solveMemoOpti(temp2)));
    }
    private static int solveMemoOpti(ArrayList<Integer>arr)
    {
        int prev=arr.get(0);
        int prevprev=0;
        for (int i=1;i<arr.size();i++)
        {
            int take=arr.get(i)+(i>1?prevprev:0);
            int notTake=0+prev;
            int curr=Math.max(take,notTake);
            prevprev=prev;
            prev=curr;
        }
        return prev;
    }
}
