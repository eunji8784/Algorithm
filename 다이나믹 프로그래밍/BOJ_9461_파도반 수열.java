import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			long[] dp = new long[N + 1];
			
			if (N <= 5) {
				sb.append(N <= 3 ? 1 : 2).append("\n");
				continue;
			}
			
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			dp[4] = 2;
			dp[5] = 2;
			
			for (int i = 6; i <= N; i++) {
				dp[i] = dp[i - 5] + dp[i - 1];
			}
			
			sb.append(dp[N]).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}

}
