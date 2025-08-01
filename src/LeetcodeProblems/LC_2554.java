package LeetcodeProblems;

public class LC_2554 {
    //Maximum Number of Integers to Choose From a Range I
    //BRUTE FORCE
    public static void main(String[] args) {
        int[] banned = {1, 6, 5};
        int n = 5;
        int maxSum = 6;

    }
    //Brute force approach
    static  int bruteForce(int []banned,int n,int maxSum)
    {
        int count=0;
        int sum=0;
        for(int i=1;i<=n;i++)
        {
            boolean isBanned=false;
            for(int j=0;j<banned.length;j++)
            {
                if(banned[j]==i)
                {
                    isBanned=true;
                    break;
                }
            }
            if(!isBanned)
            {
                sum+=i;
                if(sum>maxSum)
                    break;
                count++;
            }
        }
        return count;
    }


    //Optimized approach
    static int optimizedApproach(int []banned,int n,int maxSum)
    {
        boolean[] isBanned = new boolean[100001];
        //1 <= banned[i] <= 104
        for (int ban : banned) {
            if (ban <= n) {
                isBanned[ban] = true;
            }
        }

        int count = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (!isBanned[i]) {
                sum += i;
                if (sum > maxSum) {
                    break;
                }
                count++;
            }
        }
        return count;
    }


    //most optimized approach
    static int mostOptimizedApproach(int []banned,int n,int maxSum)
    {
        boolean[] isBanned = new boolean[100001];
        for (int ban : banned) {
            if (ban <= n) {
                isBanned[ban] = true;
            }
        }

        int count = 0;
        int sum = 0;
        for (int i = 1; i <= n && sum + i <= maxSum; i++) {
            if (!isBanned[i]) {
                sum += i;
                count++;
            }
        }
        return count;
    }
}
