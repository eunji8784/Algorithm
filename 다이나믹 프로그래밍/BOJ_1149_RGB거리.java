import java.io.*;
import java.util.*;

/*
 * 각 집을 R, G, B로 칠하는 경우의 비용을 따로 계산하면서 진행.
 * i번 집을 R로 칠할 경우의 최소 비용은 i-1번 집을 G, B로 칠했을 때의 최소 비용 + i번 집을 R로 칠하는 비용
 * i번 집을 G로 칠할 경우의 최소 비용은 i-1번 집을 R, B로 칠했을 때의 최소 비용 + i번 집을 G로 칠하는 비용
 * i번 집을 B로 칠할 경우의 최소 비용은 i-1번 집을 R, G로 칠했을 때의 최소 비용 + i번 집을 B로 칠하는 비용
 * */

public class Main {
	
	private static int N;
	private static int[][] homes;

	public static void main(String[] args) throws IOException {
		getInput();
		System.out.println(dp());
	}
	
	private static int dp() {
		int[][] costs = new int[N][3];
		
		for (int i = 0; i < 3; i++) {
			costs[0][i] = homes[0][i];
		}
		
		for (int i = 1; i < N; i++) {
			costs[i][0] = homes[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);
			costs[i][1] = homes[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
			costs[i][2] = homes[i][2] + Math.min(costs[i - 1][0], costs[i - 1][1]);
		}
		
		return Math.min(Math.min(costs[N - 1][0], costs[N - 1][1]), costs[N - 1][2]);
	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		homes = new int[N][3];
		
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			homes[i][0] = Integer.parseInt(st.nextToken());
			homes[i][1] = Integer.parseInt(st.nextToken());
			homes[i][2] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
}
