package LeetcodeProblems;

import java.util.HashSet;

public class subArray {
    public static void main(String[] args) {
        System.out.println("All sub-arrays of the array:");
        int [] arr={1,1,2};
        allSubArrays(arr);
    }
    private static void allSubArrays(int [] arr)
    {
        HashSet<Integer> uniqueORs=new HashSet<>();
        int alen=arr.length;
        for(int i=0;i<alen;i++)
        {
            for(int j=i;j<alen;j++)
            {
                int currOr=0;
                for(int k=i;k<=j;k++)
                {
                    System.out.print(arr[k]+" ");
                    currOr|=arr[k];
                }
                uniqueORs.add(currOr);
                System.out.print("=> OR: "+currOr);
                System.out.println();
            }
        }
        System.out.println("Unique ORs of all sub-arrays: " + uniqueORs);
        System.out.println("Total unique ORs: " + uniqueORs.size());
    }
}
