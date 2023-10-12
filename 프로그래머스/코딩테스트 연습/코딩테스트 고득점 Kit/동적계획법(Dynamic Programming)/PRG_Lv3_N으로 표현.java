import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] dp = new Set[9];
        int t = N;
        for (int i = 1; i < 9; i++) {
            dp[i] = new HashSet<>();
            dp[i].add(t);
            t = (t * 10) + N;
        }
        
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (Integer num1 : dp[j]) {
                    for (Integer num2 : dp[i - j]) {
                        dp[i].add(num1 + num2);
                        dp[i].add(num1 - num2);
                        dp[i].add(num1 * num2);
                        if (num2 != 0) dp[i].add(num1 / num2);
                    }
                }
            }
            if (dp[i].contains(number)) return i;
        }
        
        return -1;
    }
}

// 테스트 1 〉	통과 (2.13ms, 76.7MB)
// 테스트 2 〉	통과 (0.14ms, 75.6MB)
// 테스트 3 〉	통과 (0.09ms, 73.9MB)
// 테스트 4 〉	통과 (32.32ms, 79.5MB)
// 테스트 5 〉	통과 (25.81ms, 81.7MB)
// 테스트 6 〉	통과 (0.87ms, 77.1MB)
// 테스트 7 〉	통과 (0.70ms, 74.4MB)
// 테스트 8 〉	통과 (25.80ms, 81.6MB)
// 테스트 9 〉	통과 (0.06ms, 73.5MB)
