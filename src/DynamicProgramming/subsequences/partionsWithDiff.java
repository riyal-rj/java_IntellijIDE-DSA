package DynamicProgramming.subsequences;

public class partionsWithDiff {
    static int []arr={0,0,1};
    public static void main(String[] args) {
        int totalSum=0;
        for(int it:arr)
            totalSum+=it;
        int diff=3;
        if((totalSum-diff)<0 )
        System.out.println(false);
        if(totalSum-diff%2==0)
            System.out.println(false);
    }
}
