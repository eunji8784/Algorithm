class Solution {
    public long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;
        int n = sequence.length;
        int num = 1;
        long[][] dp = new long[2][n];
        
        for (int i = 0; i < n; i++) {
            int num1 = sequence[i] * num;
            int num2 = sequence[i] * -num;
            num *= -1;
            
            if (i == 0) {
                dp[0][i] = num1;
                dp[1][i] = num2;
            } else {
                dp[0][i] = Math.max(num1, dp[0][i - 1] + num1);
                dp[1][i] = Math.max(num2, dp[1][i - 1] + num2);
            }
            
            answer = Math.max(answer, Math.max(dp[0][i], dp[1][i]));
        }
        
        return answer;
    }
}
