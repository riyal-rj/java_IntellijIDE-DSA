package LeetcodeProblems.DailyProblems;

import java.util.PriorityQueue;

public class LC_3170 {
    public String clearStars(String s) {
        char[] str = s.toCharArray();
        PriorityQueue<int[]> pq = new PriorityQueue<>((it1, it2) -> {
            if (it1[0] == it2[0]) return it2[1] - it1[1];
            return Character.compare((char) it1[0], (char) it2[0]);
        });

        for (int i = 0; i < str.length; i++) {
            if (str[i] != '*') {
                pq.offer(new int[]{str[i], i});
            } else if (!pq.isEmpty()) {
                int index = pq.poll()[1];
                str[index] = '*';
            }
        }

        int ind = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] != '*') {
                str[ind++] = str[i];
            }
        }

        return new String(str, 0, ind);
    }
}
