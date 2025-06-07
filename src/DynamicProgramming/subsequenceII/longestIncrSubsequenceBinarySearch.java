package DynamicProgramming.subsequenceII;
import java.util.ArrayList;
import java.util.Collections;
public class longestIncrSubsequenceBinarySearch {

	public static void main(String[] args) {
		int []nums= {10,9,2,5,3,7,101,18};
		System.out.println("Length of Longest Increasing Subsequence is "+lengthOfLISBinSearch(nums));
	}
	
	static int lengthOfLISBinSearch(int []nums)
	{
		ArrayList<Integer> temp=new ArrayList<>();
		temp.add(nums[0]);
		
		int len=1;
		for(int ind=1;ind<nums.length;ind++)
		{
			if(nums[ind]>temp.get(temp.size()-1))
			{
				temp.add(nums[ind]);
				len++;
			}
			else {
				int index=Collections.binarySearch(temp, nums[ind]);
				if(index<0)
				{
					index=-index-1;
				}
				temp.set(index, nums[ind]);
			}			
			
		}
		return len;
	}

}
