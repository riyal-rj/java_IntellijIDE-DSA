package DynamicProgramming.stocks;
import static java.lang.Math.*;

import java.util.Arrays;
public class BuySellStockI {

	public static void main(String[] args) {
		int []prices= {7,1,5,3,6,4};
		System.out.println("Stock Price Array is: "+Arrays.toString(prices));
		System.out.println("Maximum Profit is on byuing and selling the stocks in the best time= "+f(prices));

	}
	
	static int f(int[]prices)
	{
		int mini=prices[0];
		int maxProfit=0;//buy and sell on the same day
		for(int i=1;i<prices.length;i++)
		{
			int cost=prices[i]-mini;
			maxProfit=max(maxProfit,cost);
			mini=min(mini,prices[i]);
		}
		
		return maxProfit;
	}

}
