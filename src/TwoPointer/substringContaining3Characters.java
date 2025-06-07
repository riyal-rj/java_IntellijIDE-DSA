package TwoPointer;

import java.util.Arrays;

import static java.lang.Math.min;

public class substringContaining3Characters {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int []mpp=new int[3];
        int ans=0;
        Arrays.fill(mpp,-1);
        for(int i=0;i<n;i++)
        {
            mpp[s.charAt(i)-'a']=i;
            ans=ans+1+min(mpp[0],min(mpp[1],mpp[2]));
        }
        return ans;
    }
}
