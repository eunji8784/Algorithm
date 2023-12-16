import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		int max = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (i == 0) {
				dp[i] = arr[i];
			} else if (i == 1) {
				dp[i] = arr[i] + arr[i - 1];
			} else if (i == 2) {
				dp[i] = arr[i] + Math.max(arr[i - 1], arr[i - 2]);
			} else {
				dp[i] = arr[i]
						+ Math.max(Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]), (i > 3 ? dp[i - 4] + arr[i - 1] : -1));
			}
			max = Math.max(max, dp[i]);
		}

		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
		br.close();
	}
}
