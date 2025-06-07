package companies.amazon;

import java.util.Arrays;

public class candyProblem_LC135 {

    static int candy(int[]ratings)
    {
        int n=ratings.length;
        int []candies=new int[n];
        Arrays.fill(candies,1); //Initialize all with 1 candies

        //Check for higher ratings....


        //Go from left to right... and check whether the left neighbor is lesser  than the current  then add 1 to current neighbors candies ..
        for(int i=1;i<n;i++)
            if(ratings[i]>ratings[i-1])
                candies[i]=candies[1]+1;


        //From right to left.. Check for the right neighbor i lesser than the curr  then add 1;
        for(int i=n-2;i>=0;i--)
            if(ratings[i]>ratings[i+1])
                candies[i]=candies[i]+1;


        int total=0;
        for(int candy:candies)
            total+=candy;

        return total;




    }

    public static void main(String[] args) {
        int ratings[]={1,0,2};
        System.out.println(candy(ratings));
        int ratings1[]={1,2,2};
        System.out.println(candy(ratings1));

    }
}

