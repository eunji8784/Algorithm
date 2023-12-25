import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] dp = new int[k + 1];
		dp[0] = 1;

		while (n-- > 0) {
			int coin = Integer.parseInt(br.readLine());
			for (int i = 1; i <= k; i++) {
				if (i >= coin) {
					dp[i] += dp[i - coin];
				}
			}
		}

		System.out.println(dp[k]);
		br.close();
	}
}
