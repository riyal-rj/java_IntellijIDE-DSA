package DynamicProgramming.subsequenceII;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class longestDivisiblesubset {

	public static void main(String[] args) {
		int nums1[]= {2,3,1};
		int nums2[]= {8,2,4,1};
		int nums3[]= {1,2,8,16,7};
		
		System.out.println("==================Example 1=============== \n");
		System.out.println("Longest Divisible Subset is : "+longDivisibleSubset(nums1));
		
		System.out.println("==================Example 2=============== \n");
		System.out.println("Longest Divisible Subset is : "+longDivisibleSubset(nums2));
		
		System.out.println("==================Example 3=============== \n");
		System.out.println("Longest Divisible Subset is : "+longDivisibleSubset(nums3));
		
	}
	
	static List<Integer> longDivisibleSubset(int []nums)
	{
		ArrayList<Integer> lds=new ArrayList<>();
		int []dp=new int[nums.length];
		Arrays.fill(dp, 1);
		int hash[]=new int[nums.length];
		Arrays.sort(nums);
		int maxi=(int)-9e9;
		int lastInd=0;
		for(int curr_ind=0;curr_ind<nums.length;curr_ind++)
		{
			hash[curr_ind]=curr_ind;
			for(int prev_ind=0;prev_ind<curr_ind;prev_ind++)
			{
				if(nums[curr_ind]%nums[prev_ind]==0 &&
						1+dp[prev_ind]>dp[curr_ind])
				{
					dp[curr_ind]=1+dp[prev_ind];
					hash[curr_ind]=prev_ind;
				}
			}
			if(maxi<dp[curr_ind])
			{
				maxi=dp[curr_ind];
				lastInd=curr_ind;
			}
		}
		
		
		lds.add(nums[lastInd]);
		while(hash[lastInd]!=lastInd)
		{
			lastInd=hash[lastInd];
			lds.add(nums[lastInd]);
		}
		
		
		System.out.println("Length of the Longest Divisible Subset is "+maxi);
		
		return lds.reversed();
	}
	
	

}
