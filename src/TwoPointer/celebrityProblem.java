package TwoPointer;

public class celebrityProblem {
    static int findCelebrity(int [][]matrix)
    {
        int n=matrix.length;
        if(n==1)
            return -1;
        int top=0,down= n-1;
        while(top<down)
        {
            if(matrix[top][down]==1)//if top knows down then top cannot be the celebrity
                top++;
            else if(matrix[down][top]==1)// if down knows top then down cannot be the celebrity
                down--;
            else // if none know none (matrix[][]==0 case)
            {
                top++;
                down--;
            }
        }

        if(top>down)
            return -1;
        for(int i=0;i<n;i++)
        {
            if(i!=top)
            {
                if(matrix[top][i]==1 && matrix[i][top]==0)
                    return -1;
            }
        }
        return top;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] matrix = {
                { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 1, 0 }
        };
        int[][] matrix1 = {
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 0 }
        };
        int [][] mat={{0,0},
                {1,0}};
        System.out.println("The Celebrity is: "+(findCelebrity(mat)));
    }



}
