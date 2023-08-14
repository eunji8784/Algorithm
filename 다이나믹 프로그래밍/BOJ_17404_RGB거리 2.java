import java.io.*;
import java.util.*;

public class Main {

	private static int N;
	private static int[][] homes;

	public static void main(String[] args) throws IOException {
		getInput();
		System.out.println(solve());
	}

	private static int solve() {
		int[][] dp = new int[N][3];
		int min = Integer.MAX_VALUE;

		for (int firstHomeColor = 0; firstHomeColor < 3; firstHomeColor++) {
			min = Math.min(min, getMinCost(firstHomeColor, dp));
		}

		return min;
	}

	private static int getMinCost(int firstHomeColor, int[][] dp) {
		for (int i = 0; i < 3; i++) {
			if (i == firstHomeColor) {
				dp[0][i] = homes[0][i];
			} else {
				dp[0][i] = 2001;
			}
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][j] = homes[i][j] + Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
			}
		}

		return Math.min(dp[N - 1][(firstHomeColor + 1) % 3], dp[N - 1][(firstHomeColor + 2) % 3]);
	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		homes = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			homes[i][0] = Integer.parseInt(st.nextToken());
			homes[i][1] = Integer.parseInt(st.nextToken());
			homes[i][2] = Integer.parseInt(st.nextToken());
		}

		br.close();
	}

}
