package TwoPointer;

import static java.lang.Math.*;

import java.util.Arrays;
public class longestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(longestSubstring("abcdbcdabc"));
    }
    static int longestSubstring(String s)
    {
        int l=0,r=0;
        int maxi=-(int)9e9;
        int len=s.length();
        int hash[]=new int[256];
        Arrays.fill(hash,-1);
        while(r<len)
        {
            char ch=s.charAt(r);
            if(hash[ch]!=-1)
            {
                if(hash[ch]>=l)
                {
                    l=hash[ch]+1;
                }
            }
            hash[ch]=r;
            maxi=max(maxi,r-l+1);
            r++;
        }
        return  maxi;
    }
}
