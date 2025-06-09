package LeetcodeProblems.DailyProblems;

import java.util.ArrayList;
import java.util.List;

public class LC_386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);
        int curr = 1;

        for (int i = 0; i < n; i++) {
            result.add(curr);

            // Try to go deeper (curr * 10)
            if (curr * 10 <= n) {
                curr *= 10;
            } else {
                // Else, try next sibling (curr + 1)
                while (curr % 10 == 9 || curr + 1 > n) {
                    curr /= 10;
                }
                curr++;
            }
        }
        return result;
    }
}
