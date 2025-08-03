package LeetcodeContest.BiWeekly;

public class LC_3635 {
    public static void main(String[] args) {

    }
    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
       int minTime = Integer.MAX_VALUE;
       int mini= Integer.MAX_VALUE;
       for(int i=0;i<landStartTime.length;i++)
           minTime=Math.min(minTime, landStartTime[i] + landDuration[i]);
       for(int i=0;i<waterStartTime.length;i++)
           mini=Math.min(mini, waterDuration[i]+Math.max(minTime,waterStartTime[i]));

       minTime=Integer.MAX_VALUE;
       for(int i=0;i<waterStartTime.length;i++)
           minTime=Math.min(minTime, waterStartTime[i]+waterDuration[i]);

       for(int i=0;i<landStartTime.length;i++)
           mini=Math.min(mini,landDuration[i]+Math.max(minTime,landStartTime[i]));
       return  mini;
    }
}
