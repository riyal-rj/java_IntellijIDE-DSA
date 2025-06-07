package DynamicProgramming.subsequenceII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
public class longestStringChainSubset {

	public static void main(String[] args) {
		String words1[] = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
		String []words2 = {"abcd","dbqca"};
		String words3[]= {"a","b","ba","bca","bda","bdca"};
		
		System.out.println("\n ==================Example 1===============");
		System.out.println("Longest String Chain Subset Length : "+solve(words1));
		
		System.out.println("\n ==================Example 2=============== ");
		System.out.println("Longest String Chain Subset Length : "+solve(words2));
		
		System.out.println("\n ==================Example 3===============");
		System.out.println("Longest String Chain Subset Length : "+solve(words3));

	}
	
	static int solve(String[]strarr)
	{
		int []dp=new int[strarr.length];
		int []hash=new int[strarr.length];
		Arrays.sort(strarr,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		
		});
		
		System.out.println("Sorted String array is "+Arrays.toString(strarr));
		int maxi=-(int)9e9;
		int lastInd=0;
		Arrays.fill(dp, 1);
		for(int curr_ind=0;curr_ind<strarr.length;curr_ind++)
		{
			hash[curr_ind]=curr_ind;
			for(int prev_ind=0;prev_ind<curr_ind;prev_ind++)
			{
				if(check(strarr[curr_ind],strarr[prev_ind])
						&& 1+dp[prev_ind]>dp[curr_ind])
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
		
		List<String> lonStrChain=new ArrayList<>();
		lonStrChain.add(strarr[lastInd]);
		while(hash[lastInd]!=lastInd)
		{
			lastInd=hash[lastInd];
			lonStrChain.add(strarr[lastInd]);
		}
		
		System.out.println("Longest String Chain Subset is : "+lonStrChain.reversed());
		
		return maxi;
		
	}
	
	static boolean check(String s1,String s2) {
        if (s1.length() != s2.length() + 1) {
            return false;
        }

        int first = 0;
        int second = 0;

        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }

        return first == s1.length() && second == s2.length();

	}

}
