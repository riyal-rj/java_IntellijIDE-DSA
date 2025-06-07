package TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class longestsubStringWithAtmostKDiffCharacters {
     static int LongestSubstringKDiff(String s,int k)
    {
        Map<Character,Integer> mpp=new HashMap<>();
        int l=0,r=0,maxLen=0;
        while(r<s.length())
        {
            mpp.put(s.charAt(r),mpp.getOrDefault(s.charAt(r),0)+1);
            if(mpp.size()>k)
            {
                mpp.put(s.charAt(l),mpp.get(s.charAt(l))-1);
                if(mpp.get(s.charAt(l))==0)
                    mpp.remove(s.charAt(l));
                l++;
            }
            if(mpp.size()<=k)
                maxLen=Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(LongestSubstringKDiff("aaabbcccd",2));
    }
}
