import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MOD = 1000000000;
		final int LAST_NUM = 9;
		
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n + 1][LAST_NUM + 1];

		for (int i = 1; i <= LAST_NUM; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= LAST_NUM; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j + 1];
				} else if (j == LAST_NUM) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
				}
				dp[i][j] %= MOD;
			}
		}
		
		int answer = 0;
		for (int i = 0; i <= LAST_NUM; i++) {
			answer = (answer + dp[n][i]) % MOD;
		}
		
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		br.close();
	}
}
