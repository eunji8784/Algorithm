import java.io.*;
import java.util.*;

public class Main {
	
	private static int N;
	private static int[][] W, dp;
	private static final int INF = Integer.MAX_VALUE / 2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		dp = new int[N][(1 << N) - 1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(dp[i], -1);
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(tsp(0, 1)); // 0번 도시에서 시작, visited = 1 (0001) 0번 도시 방문
		br.close();
	}
	
	private static int tsp(int current, int visited) {
		if (visited + 1 == (1 << N)) { // 모든 도시를 다 방문한 경우 
			return (W[current][0] != 0 ? W[current][0] : INF);
		}
		
		if (dp[current][visited] != -1) return dp[current][visited]; // 이미 계산된 값이면 반환  
		
		dp[current][visited] = INF;
		
		for (int next = 0; next < N; next++) {
			if ((visited & (1 << next)) != 0 || W[current][next] == 0) continue; // 이미 방문한 도시거나 갈 수 없는 도시일 경우 
			
			dp[current][visited] = Math.min(dp[current][visited], tsp(next, visited | (1 << next)) + W[current][next]);
		}
		
		return dp[current][visited];
	}

}
