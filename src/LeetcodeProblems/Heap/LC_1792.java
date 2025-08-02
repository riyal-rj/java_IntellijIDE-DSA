package LeetcodeProblems.Heap;

public class LC_1792 {
    //brute force approach
    /*
      try with every possible class in classes and add student one by one
      from "extraStudents" to "classes" and check the max average

      This approach will take exponential time complexity
     */


    // Optimized approach
    /*
    Use a maxDelta property
    on adding every student to a class, calculate the delta in average
    and keep track of the maximum delta.
    This will allow us to find the class with the maximum average after adding all students.

     */

    public static void main(String[] args) {
        int [][] classes = {{1, 2}, {3, 5}, {2,2}};
        int extraStudents = 2;
        System.out.println(maxAverage(classes, extraStudents));
    }

    public static double maxAverage(int [][]classes ,int extraStudents){
        int n= classes.length;

        double passRatio=0.0d;
        double [] ratios = new double[n];
        int ind=0;
        for(int []cls:classes)
        {
            passRatio=(cls[0]/(double)cls[1]);
            ratios[ind++] = passRatio;
        }

        double delta=0.0d;
        int idx=0;
        while(extraStudents-->0)
        {
            double maxDelta=0.0d;
            for(int i=0;i<n;i++)
            {
                int []cls=classes[i];
                double newRatio=(cls[0]+1)/(double)(cls[1]+1);
                double newDelta=newRatio-ratios[i];
                if(newDelta>maxDelta)
                {
                    maxDelta=newDelta;
                    idx=i;
                }
            }
            classes[idx][0]++;
            classes[idx][1]++;
            ratios[idx] = (classes[idx][0] / (double) classes[idx][1]);
        }
        passRatio=0;
        for(int i=0;i<n;i++)
        {
            passRatio+=ratios[i];
        }
        return (passRatio + delta)/n;

    }
}
