package TwoPointer;

public class minimumWindowSubstring {
    public static String minWindow(String s, String t) {
        int l=0,r=0;
        int minLen=(int)9e9;
        int count=0;
        int []hash=new int[256];
        for(int i=0;i<t.length();i++)
            hash[t.charAt(i)]++;
        int startIndex=-1;
        while(r<s.length())
        {
            char ch=s.charAt(r);
            if(hash[ch]>0)
                count++;
            hash[ch]--;
            while(count==t.length())
            {
                if(r-l+1<minLen)
                {
                    minLen=r-l+1;
                    startIndex=l;
                }
                hash[s.charAt(l)]++;
                if( hash[s.charAt(l)]>0)
                    count--;
                l++;

            }
            r++;
        }

        return startIndex==-1?"":s.substring(startIndex,startIndex+minLen);
    }

    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
        System.out.println(minWindow(s,t));
    }
}
