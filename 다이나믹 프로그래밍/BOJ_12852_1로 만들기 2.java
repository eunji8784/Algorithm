import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];

		dp[1] = 0;
		if (n > 1) dp[2] = 1;
		if (n > 2) dp[3] = 1;

		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
		}

		bw.write(dp[n] + "\n" + n + " ");

		int minVal = 0, nextNum = 0;
		while (n > 1) {
			minVal = dp[n - 1];
			nextNum = n - 1;
			if (n % 3 == 0 && dp[n / 3] <= minVal) {
				minVal = dp[n / 3];
				nextNum = n / 3;
			}
			if (n % 2 == 0 && dp[n / 2] <= minVal) {
				nextNum = n / 2;
			}
			n = nextNum;
			bw.write(n + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
