package LeetcodeProblems;

public class LC_1793 {
    //Maximum score of a Good SubArray

    /* GOOD SUB-ARRAY
     nums[i...j] is a sub-array of nums
     k is an element
     nums[i..j] is said to be good when nums[i]<=k<=nums[j]
     */

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 7, 4, 5};
        int k = 3;
        System.out.println(maximumScore(nums, k));
        System.out.println(maximumScoreOptimized(nums, k));
    }

    //brute force approach
        static public int maximumScore(int[] nums, int k) {

            int n = nums.length;
            int maxScore = 0;

            for (int i = 0; i <= k; i++) {
                for (int j = k; j < n; j++) {
                    int minVal = nums[i];
                    for (int m = i + 1; m <= j; m++) {
                        minVal = Math.min(minVal, nums[m]);
                    }
                    int score = minVal * (j - i + 1);
                    maxScore = Math.max(maxScore, score);
                }
            }

            return maxScore;
        }


    //Optimized approach
    public static int maximumScoreOptimized(int[] nums, int k) {
        int i=k;
        int j=k;
        int maxScore=nums[k];
        int mini=nums[k];
        int n=nums.length;
        while(i>0 || j<n-1)
        {
            int leftVal=(i>0)?nums[i-1]:0;
            int rightVal=(j<n-1)?nums[j+1]:0;
            if(leftVal>rightVal)
            {
                i--;
                mini=Math.min(mini,nums[i]);
            }
            else
            {
                j++;
                mini=Math.min(mini,nums[j]);
            }
            maxScore=Math.max(maxScore,mini*(j-i+1));
        }
        return maxScore;
    }
    }
