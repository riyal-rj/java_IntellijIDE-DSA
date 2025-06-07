package TwoPointer;

import java.util.ArrayList;
import java.util.List;

public class countCompleteSubstring {
    public int countCompleteSubstrings(String word, int k) {
        int n = word.length();

        // First split the word into valid segments where adjacent diff <= 2
        List<Integer> splitPoints = new ArrayList<>();
        splitPoints.add(0);

        // Find split points
        for (int i = 1; i < n; i++) {
            if (Math.abs(word.charAt(i) - word.charAt(i - 1)) > 2) {
                splitPoints.add(i);
            }
        }
        splitPoints.add(n);

        int totalCount = 0;
        // Process each valid segment
        for (int i = 0; i < splitPoints.size() - 1; i++) {
            int start = splitPoints.get(i);
            int end = splitPoints.get(i + 1);
            totalCount += countInRange(word, start, end, k);
        }

        return totalCount;
    }

    private int countInRange(String word, int start, int end, int k) {
        int count = 0;
        int len = end - start;

        // Try each possible window size (must be multiple of k)
        for (int chars = 1; chars <= 26 && chars * k <= len; chars++) {
            int windowSize = chars * k;
            int[] freq = new int[26];
            int uniqueCharsWithKFreq = 0;
            int totalUniqueChars = 0;

            // Initialize first window
            for (int i = start; i < start + windowSize && i < end; i++) {
                int idx = word.charAt(i) - 'a';
                freq[idx]++;
                if (freq[idx] == 1) totalUniqueChars++;
                if (freq[idx] == k) uniqueCharsWithKFreq++;
                if (freq[idx] == k + 1) uniqueCharsWithKFreq--;
            }

            if (uniqueCharsWithKFreq == totalUniqueChars && totalUniqueChars == chars) {
                count++;
            }

            // Slide window
            for (int i = start + windowSize; i < end; i++) {
                // Remove previous character
                int prevIdx = word.charAt(i - windowSize) - 'a';
                if (freq[prevIdx] == k) uniqueCharsWithKFreq--;
                freq[prevIdx]--;
                if (freq[prevIdx] == 0) totalUniqueChars--;
                if (freq[prevIdx] == k) uniqueCharsWithKFreq++;

                // Add new character
                int newIdx = word.charAt(i) - 'a';
                freq[newIdx]++;
                if (freq[newIdx] == 1) totalUniqueChars++;
                if (freq[newIdx] == k) uniqueCharsWithKFreq++;
                if (freq[newIdx] == k + 1) uniqueCharsWithKFreq--;

                if (uniqueCharsWithKFreq == totalUniqueChars && totalUniqueChars == chars) {
                    count++;
                }
            }
        }

        return count;
    }
}
