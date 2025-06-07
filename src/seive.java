import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class seive {
    public static void main(String[] args) {
        int []prime=new int[1001];
        Arrays.fill(prime,1);
        prime[0]=0;
        prime[1]=0;
        for(int i=2;i*i<=1000;i++)
        {
            if(prime[i]==1)
            {
                for(int j=i*i;j<=1000;j+=i)
                    prime[j]=0;
            }
        }

        List<Integer> res=new ArrayList<Integer>();
        for(int i=2;i<=1000;i++)
        {
            if(prime[i]==1)
                res.add(i);
        }

        System.out.println(res);
        System.out.println(res.get(2)*res.get(4)-1);
    }
}
