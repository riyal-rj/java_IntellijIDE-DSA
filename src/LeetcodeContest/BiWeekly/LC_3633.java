package LeetcodeContest.BiWeekly;

public class LC_3633 {
    public static void main(String[] args) {
        int []landStartTime={2,8};
        int[] waterStartTime={6};
        int []landDuration={4,1};
        int []waterDuration={3};

        System.out.println(earliestFinishTime(landStartTime, waterStartTime, landDuration, waterDuration));
    }

    public static int earliestFinishTime(int[] landStartTime, int[] waterStartTime, int[] landDuration, int[] waterDuration) {
        int mini=Integer.MAX_VALUE;
       for(int i=0;i<landStartTime.length;i++)
       {
          for(int j=0;j<waterStartTime.length;j++)
          {
              // land first then water
              int startLand=landStartTime[i];
              int finishLand=startLand+landDuration[i];
              int startWater=Math.max(finishLand,waterStartTime[j]);
              int finishWater=startWater+waterDuration[j];
              mini=Math.min(mini,finishWater);

                // water first then land
                int startWaterFirst=waterStartTime[j];
                int finishWaterFirst=startWaterFirst+waterDuration[j];
                int startLandAfterWater=Math.max(finishWaterFirst,landStartTime[i]);
                int finishLandAfterWater=startLandAfterWater+landDuration[i];
                mini=Math.min(mini,finishLandAfterWater);
          }
       }
       return mini;
    }
}
