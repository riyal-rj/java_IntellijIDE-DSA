package LeetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC_1383 {
    // This problem is about finding the maximum performance of a team given the speed and efficiency of engineers.


    //Brute force solution:
    /*
        Try all the combinations of engineers size <=k

        for each engineer combination, calculate the following as:
            i) total speed of the team
            ii) minimum efficiency of the team
            iii) performance = total speed * minimum efficiency
        return the maximum performance found.
     */

    public long maxPerformanceBrute(int n,int k,int eff[],int []speed)
    {
        List<int[]> engineers =new ArrayList<>();
        for(int i=0;i<n;i++)
            engineers.add(new int[]{speed[i], eff[i]});


        List<List<int[]>> combinations = getAllCombinations(engineers, k);
        long maxPerformance = 0;
        for (List<int[]> team : combinations) {
            long totalSpeed = 0;
            int minEfficiency = Integer.MAX_VALUE;
            for (int[] engineer : team) {
                totalSpeed += engineer[0];
                minEfficiency = Math.min(minEfficiency, engineer[1]);
            }
            long performance = totalSpeed * minEfficiency;
            maxPerformance = Math.max(maxPerformance, performance);
        }
        return maxPerformance;
    }

    private List<List<int[]>> getAllCombinations(List<int[]> engineers, int k) {
        List<List<int[]>> combinations = new ArrayList<>();
        getCombinationsHelper(engineers, k, 0, new ArrayList<>(), combinations);
        return combinations;
    }
    private void getCombinationsHelper(List<int[]> engineers, int k, int start, List<int[]> current, List<List<int[]>> combinations) {
        if (current.size() == k) {
            combinations.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < engineers.size(); i++) {
            current.add(engineers.get(i));
            getCombinationsHelper(engineers, k, i + 1, current, combinations);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        LC_1383 solution = new LC_1383();
        int n = 5, k = 3;
        int[] speed = {2, 10, 3, 1, 5};
        int[] efficiency = {5, 4, 3, 9, 2};

        long maxPerformance = solution.maxPerformanceBrute(n, k, efficiency, speed);
        System.out.println("Maximum Performance: " + maxPerformance);

        System.out.println("Using optimized approach:"+maxPerformance(n, speed, efficiency, k));
    }
    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        final int MOD=(int)(1e9+7);
        int [][]engineers=new int[n][2];
        for(int i=0;i<n;i++)
        {
            engineers[i][0]=efficiency[i];
            engineers[i][1]=speed[i];
        }

        Arrays.sort(engineers,(e1, e2)->e2[0]-e1[0]);

        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        long maxPerformance=0,speedSum=0;

        for(int []eng:engineers)
        {
            int currEff=eng[0],currSpeed=eng[1];
            minHeap.add(currSpeed);

            speedSum+=currSpeed;

            if(minHeap.size()>k)
                speedSum-=minHeap.poll();

            maxPerformance=Math.max(maxPerformance,speedSum*currEff);
        }
        return (int)(maxPerformance % MOD);
    }
}
