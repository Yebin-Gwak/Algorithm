import java.util.*;

class Solution {
    public int solution(int N, int number) {
        HashSet<Integer>[] dp = new HashSet[9];
        for (int i = 0; i <= 8; i++)
            dp[i] = new HashSet<>();

        int repeated = 0;
        for (int i = 1; i <= 8; i++) {
            repeated = repeated * 10 + N;
            HashSet<Integer> now = dp[i];
            now.add(repeated);
            if (repeated == number) return i;

            for (int j = 1; j < i; j++) {
                for (int a : dp[j]) {
                    for (int b : dp[i - j]) {
                        now.add(a + b);
                        now.add(a - b);
                        now.add(a * b);
                        if (b != 0) now.add(a / b);
                    }
                }
            }

            if (now.contains(number)) return i;
        }
        return -1;  
    }
}