import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 2];
		int[] pay = new int[n + 1];
		int[] needTime = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			needTime[i] = t;
			pay[i] = p;
		}
		
		for (int i = n; i > 0; i--) {
			int end = i + needTime[i];
			if (end <= n + 1) {
				dp[i] = Math.max(dp[i + 1], dp[end] + pay[i]);
			} else {
				dp[i] = dp[i + 1];
			}
		}
		
		bw.write(String.valueOf(dp[1]));
		bw.flush();
		bw.close();
		br.close();
	}
}
