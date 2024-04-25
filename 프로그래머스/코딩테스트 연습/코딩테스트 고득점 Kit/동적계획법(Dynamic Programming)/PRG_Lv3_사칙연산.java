import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int operandsCnt = arr.length / 2 + 1;
        int[][] maxDP = new int[operandsCnt][operandsCnt];
        int[][] minDP = new int[operandsCnt][operandsCnt];
        
        for (int i = 0; i < operandsCnt; i++) {
            Arrays.fill(maxDP[i], Integer.MIN_VALUE);
            Arrays.fill(minDP[i], Integer.MAX_VALUE);
        }
        
        for (int i = 0; i < operandsCnt; i++) {
            int num = Integer.parseInt(arr[i * 2]);
            maxDP[i][i] = num;
            minDP[i][i] = num;
        }
        
        for (int cnt = 1; cnt < operandsCnt; cnt++) {
            for (int i = 0; i < operandsCnt - cnt; i++) {
                int j = i + cnt;
                for (int k = i; k < j; k++) {
                    if (arr[k * 2 + 1].equals("+")) {
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] + maxDP[k + 1][j]);
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] + minDP[k + 1][j]);
                    } else {
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] - minDP[k + 1][j]);
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] - maxDP[k + 1][j]);
                    }
                }
            }
        }
        
        return maxDP[0][operandsCnt - 1];
    }
}
