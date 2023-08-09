import java.io.*;
import java.util.*;

public class Main {
	
	private static final int MOD = 10007;

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		System.out.println(solve(n, k));
		
		br.close();
	}
	
	private static long solve(int n, int k) {
		long[][] dp = new long[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j || j == 0) {
					dp[i][j] = 1;
					continue;
				}
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
			}
		}
		return dp[n][k];
	}

}
