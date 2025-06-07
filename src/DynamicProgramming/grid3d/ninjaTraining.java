package DynamicProgramming.grid3d;

import java.util.Arrays;

public class ninjaTraining {
    public static void main(String[] args) {
        int [][]points={{10,40,70},{20,50,80},{30,60,90}};
           int n= points.length;
        int ans=solveRecu(points,n-1,3);
        System.out.println(ans);

        int [][]dp=new int[n][4];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        ans=solveMemo(points,n-1,3,dp);
        System.out.println(ans);

        for(int[] row:dp)
            Arrays.fill(row,0);
        ans=solveTabu(points,n,3,dp);
        System.out.println(ans);
    }

    private static int solveTabu(int[][]points,int days,int last,int[][]dp)
    {
         dp[0][0]=Math.max(points[0][1],points[0][2]);
         dp[0][1]=Math.max(points[0][0],points[0][2]);
         dp[0][2]=Math.max(points[0][1],points[0][0]);
         dp[0][3]=Math.max(Math.max(points[0][0],points[0][1]),points[0][2]);


         for(int day=1;day<days;day++)
         {
             for(int las=0;las<4;las++)
             {
                 dp[day][las]=0;
                 for(int task=0;task<3;task++)
                 {
                     if(task!=last)
                     {
                         int point=points[day][task]+dp[day-1][task];
                         dp[day][las]=Math.max(dp[day][las],point);
                     }
                 }
             }
         }
         return dp[days-1][last];
    }
    private static int solveMemo(int[][]points,int day,int last,int[][]dp)
    {
        if(day==0)
        {
            int maxi=0;
            for(int task=0;task<3;task++)
            {
                if(task!=last)
                    maxi=Math.max(maxi,points[day][task]);
            }
            return dp[day][last]=maxi;
        }

        if(dp[day][last]!=-1)
            return dp[day][last];


        int maxi=0;
        for(int task=0;task<3;task++)
        {
            if(task!=last)
            {
                int temp=points[day][task]+solveMemo(points,day-1,task,dp);
                maxi=Math.max(maxi,temp);
            };
        }
        return dp[day][last]=maxi;
    }
    private static int solveRecu(int[][]points,int day,int last)
    {
        if(day==0)
        {
            int maxi=0;
            for(int task=0;task<3;task++)
            {
                if(task!=last)
                    maxi=Math.max(maxi,points[day][task]);
            }
            return maxi;
        }
        int maxi=0;
        for(int task=0;task<3;task++)
        {
            if(task!=last)
            {
                int temp=points[day][task]+solveRecu(points,day-1,task);
                maxi=Math.max(maxi,temp);
            };
        }
        return maxi;
    }
}
