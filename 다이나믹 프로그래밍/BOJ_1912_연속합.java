import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		int answer = Integer.MIN_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (i == 0) {
				dp[i] = arr[i];
				answer = dp[i];
				continue;
			}
			dp[i] = Math.max(arr[i] + dp[i - 1], arr[i]);
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
		br.close();
	}
	
}
