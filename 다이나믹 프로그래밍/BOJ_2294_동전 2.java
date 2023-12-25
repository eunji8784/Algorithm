import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		final int INF = Integer.MAX_VALUE;
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[k + 1];
		Arrays.fill(dp, INF);
		dp[0] = 0;

		Set<Integer> coins = new HashSet<>();

		for (int i = 0; i < n; i++) {
			coins.add(Integer.parseInt(br.readLine()));
		}

		for (int coin : coins) {
			for (int v = 1; v <= k; v++) {
				if (v >= coin && dp[v - coin] != INF) {
					dp[v] = Math.min(dp[v], 1 + dp[v - coin]);
				}
			}
		}

		System.out.println(dp[k] == INF ? -1 : dp[k]);
		br.close();
	}
}
