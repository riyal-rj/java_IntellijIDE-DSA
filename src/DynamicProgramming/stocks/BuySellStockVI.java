package DynamicProgramming.stocks;
import static java.lang.Math.*;
import java.util.Arrays;

public class BuySellStockVI {
	public static void main(String[] args) {
		int []prices= {1, 3, 2, 8, 4, 9};
		int fee=2;
		System.out.println(maxProfit(prices, fee));
	}
	public static int maxProfit(int[] prices, int fee) {
        int [][]dp=new int[prices.length+1][2];
		for(int[]d:dp)
			Arrays.fill(d, 0);
		
		
		for(int ind=prices.length-1;ind>=0;ind--)
		{
			for(int buy=0;buy<=1;buy++)
			{
				if(buy==1)
					dp[ind][buy]= max(-prices[ind]+dp[ind+1][0],0+dp[ind+1][1]);
				else 
					dp[ind][buy]= max(prices[ind]-fee+dp[ind+1][1],0+dp[ind+1][0]);
			}
		}
		return dp[0][1];
    }
}
