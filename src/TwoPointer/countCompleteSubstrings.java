package TwoPointer;

import java.util.HashMap;
import java.util.Map;
import static java.lang.Math.*;
public class countCompleteSubstrings {
    public int countCompleteSubstrings(String word, int k) {
        int n=word.length();
        int l=0,r=0,count=0;
        Map<Character, Integer> mpp = new HashMap<>();
        while(r<n)
        {
            mpp.put(word.charAt(r),mpp.getOrDefault(word.charAt(r),0)+1);
            while(!isAdjacent(word,l,r) || !freqCheck(mpp,k))
            {
                mpp.put(word.charAt(l),mpp.get(word.charAt(l))-1);
                if(mpp.get(word.charAt(l))==0)
                    mpp.remove(word.charAt(l));
                l++;
            }
            if(freqCheck(mpp,k))
                count+=r-l+1;
            r++;
        }
        return count;
    }
    private boolean isAdjacent(String s,int l,int r)
    {
        for(int i=l+1;i<=r;i++)
            if(abs(s.charAt(i)-s.charAt(i-1))>2)
                return false;
        return true;
    }
    private boolean freqCheck(Map<Character,Integer> mpp,int k)
    {
        for(int cnt:mpp.values())
            if(cnt!=k)
                return false;
        return true;
    }

}
