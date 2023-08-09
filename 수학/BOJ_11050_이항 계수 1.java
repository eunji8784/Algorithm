import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		System.out.println(solve(N, K));
		
		br.close();
	}

	private static int solve(int n, int k) {
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j || j == 0) {
					dp[i][j] = 1;
					continue;
				}
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		return dp[n][k];
	}
	
}
