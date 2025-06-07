package DynamicProgramming.stocks;
import static java.lang.Math.*;
public class BuySellStockIV {

	public static void main(String[] args) {
		int prices[]= {2,4,1};
		int k=2;
		System.out.println(f(prices,k));//2
		
		int []prices1= {3,2,6,5,0,3};
		k=2;
		System.out.println(f(prices1,k));//7
		

	}
	static int f(int[]prices,int k)
	{
		 int[][]ahead=new int[2][k+1];
			int curr[][]=new int[2][k+1];
			int n=prices.length;
			for(int ind=n-1;ind>=0;ind--)
			{
				for(int buy=0;buy<=1;buy++)
				{
					for(int tr=1;tr<=k;tr++)
					{
						if(buy==1)
							curr[buy][tr]=max(-prices[ind]+ahead[0][tr],
									0+ahead[1][tr]);
						else
							curr[buy][tr]=max(prices[ind]+ahead[1][tr-1],
									0+ahead[0][tr]);
					}
					ahead=curr;
				}
			}
			
			return ahead[1][k];
	}

}
