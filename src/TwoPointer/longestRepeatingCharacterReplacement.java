package TwoPointer;

import static java.lang.Math.max;

public class longestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int r=0,l=0,maxFreq=0,maxLen=0;
        int []hash=new int[26];
        while(r<n)
        {
            char ch=s.charAt(r);
            hash[ch-'A']++;
            maxFreq=max(maxFreq,hash[ch-'A']);
            if(r-l+1-maxFreq>k)
            {
                hash[s.charAt(l)-'A']--;
                maxFreq=0;
                for(int i=0;i<26;i++)
                    maxFreq=max(maxFreq,hash[i]);
                l++;
            }
            if(r-l+1-maxFreq<=k)
                maxLen=max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }
}
