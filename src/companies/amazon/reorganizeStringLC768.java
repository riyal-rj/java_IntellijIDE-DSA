package companies.amazon;
import static java.lang.Math.*;
public class reorganizeStringLC768 {
    public  static String reorganizeString(String s) {

        int n=s.length();
        int []freq=new int[26];


        for(char ch:s.toCharArray())
            freq[ch-'a']++;

        int maxi=Integer.MIN_VALUE;
        for(int f:freq)
            maxi=max(maxi,f);

        if(maxi>(n+1)/2)// Return the empty string if maxLength is grater than (n+1)/2
            //coz it is possible ot rearrange without consecutive  duplicates
            return "";

        char output[]=new char[n];
        int evenIndex=0;
        int oddIndex=1;
        for(int i=0;i<26;i++)
        {
            while(freq[i]>0 && freq[i]<=n/2  && oddIndex<n)
            {
                output[oddIndex]=(char)(i+'a');
                freq[i]--;
                oddIndex+=2;
            }

            while(freq[i]>0)
            {
                output[evenIndex]=(char)(i+'a');
                freq[i]--;
                evenIndex+=2;
            }
        }

        return new String(output);
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aaab"));
        System.out.println(reorganizeString("aab"));
    }
}
