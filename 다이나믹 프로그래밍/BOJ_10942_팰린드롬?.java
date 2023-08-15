import java.io.*;
import java.util.*;

public class Main {
	
	private static int N;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] result = dp();
		
		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			sb.append(result[S][E]).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
	
	private static int[][] dp() {
		int[][] dp = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			dp[i][i] = 1;
		}
		
		for (int i = 1; i < N; i++) {
			dp[i][i + 1] = arr[i] == arr[i + 1] ? 1 : 0;
		}
		
		for (int length = 3; length <= N; length++) {
			for (int i = 1; i <= N - length + 1; i++) {
				int j = i + length - 1;
				dp[i][j] = (arr[i] == arr[j] && dp[i + 1][j - 1] == 1 ? 1 : 0);
			}
		}
		
		return dp;
	}

}
