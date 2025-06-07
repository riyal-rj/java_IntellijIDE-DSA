package GoldmanSachs2k25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Transactions {
    private static void generateResult(int N,long[]transactions)
    {
        boolean allPairsHaveCommonDigit=true;
        for (int i=0;i<N-1;i++)
        {
            String currTrans=String.valueOf((long)transactions[i]);
            String nextTrans=String.valueOf((long)transactions[i+1]);

            boolean findCommonDigit=false;
            for(int j=0;j<currTrans.length();j++)
            {
                char digitCurr=currTrans.charAt(j);
                for(int k=0;k<nextTrans.length();k++)
                {
                    char digitNext=nextTrans.charAt(k);
                    if(digitCurr==digitNext)
                    {
                        findCommonDigit=true;
                        break;
                    }
                }
                if(findCommonDigit)
                    break;
            }
            if(!findCommonDigit) {
                allPairsHaveCommonDigit=false;
                break;
            }
        }
        long sum=0;
        for(int i=0;i<N;i++)
            sum+=transactions[i];

        System.out.println(allPairsHaveCommonDigit?"true":"false");
        System.out.println(sum);
    }

    public static void main(String[] args) {
        try (BufferedReader br=new BufferedReader(new InputStreamReader(System.in));) {
            int N = Integer.parseInt(br.readLine());
            long[] transactions = new long[N];
            for (int i = 0; i < N; i++)
                transactions[i] = Long.parseLong(br.readLine());
            generateResult(N,transactions);

            //Test Case 1:-
            //5
            //12 11 15 19 79
            //true


            //Test Case 2:-
            // 6
            // 1 12 123 1224 235 876
            //false
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
