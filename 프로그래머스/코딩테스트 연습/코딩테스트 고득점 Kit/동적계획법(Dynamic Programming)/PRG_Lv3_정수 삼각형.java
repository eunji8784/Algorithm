import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        if (n == 1) return triangle[0][0];
        int answer = 0;
        int[][] dp = new int[n][n];
      
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < n; i++) {
            dp[i][0] = triangle[i][0] + dp[i - 1][0];
            for (int j = 1; j < i; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            }
            dp[i][i] = triangle[i][i] + dp[i - 1][i - 1];
        }
        
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }
        
        return answer;
    }
}

// 테스트 1 〉	통과 (0.03ms, 73.2MB)
// 테스트 2 〉	통과 (0.05ms, 73.9MB)
// 테스트 3 〉	통과 (0.04ms, 69.1MB)
// 테스트 4 〉	통과 (0.09ms, 85.4MB)
// 테스트 5 〉	통과 (0.35ms, 89MB)
// 테스트 6 〉	통과 (0.09ms, 80MB)
// 테스트 7 〉	통과 (0.23ms, 68.6MB)
// 테스트 8 〉	통과 (0.11ms, 78.4MB)
// 테스트 9 〉	통과 (0.03ms, 71.3MB)
// 테스트 10 〉	통과 (0.07ms, 73.9MB)
// 효율성  테스트
// 테스트 1 〉	통과 (9.11ms, 61.2MB)
// 테스트 2 〉	통과 (6.35ms, 57.4MB)
// 테스트 3 〉	통과 (8.31ms, 61.4MB)
// 테스트 4 〉	통과 (7.15ms, 60.6MB)
// 테스트 5 〉	통과 (6.19ms, 59.8MB)
// 테스트 6 〉	통과 (8.18ms, 78.3MB)
// 테스트 7 〉	통과 (9.15ms, 62.4MB)
// 테스트 8 〉	통과 (7.93ms, 59.1MB)
// 테스트 9 〉	통과 (8.37ms, 61.1MB)
// 테스트 10 〉	통과 (7.25ms, 61.6MB)
