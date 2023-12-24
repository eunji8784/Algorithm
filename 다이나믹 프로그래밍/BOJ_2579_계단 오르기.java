import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int stairsNum = Integer.parseInt(br.readLine());
		int[] stairs = new int[stairsNum];
		int[] dp = new int[stairsNum];

		for (int i = 0; i < stairsNum; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
			dp[i] = stairs[i];
			if (i <= 1) {
				if (i == 1) {
					dp[i] += stairs[i - 1];
				}
			} else if (i == 2) {
				dp[i] += Math.max(stairs[i - 1], stairs[i - 2]);
			} else {
				dp[i] += Math.max(dp[i - 2], stairs[i - 1] + dp[i - 3]);
			}
		}

		System.out.println(dp[stairsNum - 1]);
		br.close();
	}
}
