package StackQueue;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;
public class asteroidColision {

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<Integer>();
        for(int asteroid:asteroids)
        {
            boolean destroyed=false;
            while(!stack.isEmpty() && asteroid<0 && stack.peek()>0)
            {
                int top=stack.peek();
                if(Math.abs(asteroid)>top)
                    stack.pop();
                else if(top==Math.abs(asteroid))
                {
                    destroyed=true;
                    stack.pop();
                    break;
                }
                else {
                    destroyed=true;
                    break;
                }
            }

            if(!destroyed)
                stack.push(asteroid);
        }

        if(stack.size()!=0)
        {
            int []res=new int[stack.size()];
            int ind=stack.size()-1;
            while(!stack.isEmpty())
            {
                int last=stack.pop();
                res[ind]=last;
                ind--;
            }
            return res;
        }
        else  return new int[0];




    }

    public static void main(String[] args) {
        // DynamicProgramming.Test case 1: Simple collision and survival
        asteroidColision solution=new asteroidColision();
        int[] test1 = {5, 10, -5};
        System.out.println("DynamicProgramming.Test 1: " + Arrays.toString(solution.asteroidCollision(test1))); // Expected: [5, 10]

        // DynamicProgramming.Test case 2: Exact collision, both asteroids destroyed
        int[] test2 = {8, -8};
        System.out.println("DynamicProgramming.Test 2: " + Arrays.toString(solution.asteroidCollision(test2))); // Expected: []

        // DynamicProgramming.Test case 3: Multiple collisions with larger asteroid
        int[] test3 = {10, 2, -5};
        System.out.println("DynamicProgramming.Test 3: " + Arrays.toString(solution.asteroidCollision(test3))); // Expected: [10]

        // DynamicProgramming.Test case 4: No collision
        int[] test4 = {1, 2, 3, 4, 5};
        System.out.println("DynamicProgramming.Test 4: " + Arrays.toString(solution.asteroidCollision(test4))); // Expected: [1, 2, 3, 4, 5]

        // DynamicProgramming.Test case 5: All asteroids moving in the same direction
        int[] test5 = {3, 8, 4, 10};
        System.out.println("DynamicProgramming.Test 5: " + Arrays.toString(solution.asteroidCollision(test5))); // Expected: [3, 8, 4, 10]

        // DynamicProgramming.Test case 6: Alternating positive and negative without collision
        int[] test6 = {-2, -1, 1, 2};
        System.out.println("DynamicProgramming.Test 6: " + Arrays.toString(solution.asteroidCollision(test6))); // Expected: [-2, -1, 1, 2]

        // DynamicProgramming.Test case 7: Large array with several collisions
        int[] test7 = {5, 10, -5, -10, 20, -20, 30, -40, 50, -50};
        System.out.println("DynamicProgramming.Test 7: " + Arrays.toString(solution.asteroidCollision(test7))); // Expected: [30, -40]

        // DynamicProgramming.Test case 8: Array with only negative asteroids
        int[] test8 = {-3, -5, -10};
        System.out.println("DynamicProgramming.Test 8: " + Arrays.toString(solution.asteroidCollision(test8))); // Expected: [-3, -5, -10]

        // DynamicProgramming.Test case 9: Array with only positive asteroids
        int[] test9 = {5, 15, 20};
        System.out.println("DynamicProgramming.Test 9: " + Arrays.toString(solution.asteroidCollision(test9))); // Expected: [5, 15, 20]

        // DynamicProgramming.Test case 10: Edge case - Empty array
        int[] test10 = {};
        System.out.println("DynamicProgramming.Test 10: " + Arrays.toString(solution.asteroidCollision(test10))); // Expected: []
    }
}
