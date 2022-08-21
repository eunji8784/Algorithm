import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[] home = new int[2];
	static int[] company = new int[2];
	static int[][] customers;
	static int[] selected;
	static boolean[] visited;
	static int distance;
	static int minDistance;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			customers = new int[N][2];
			selected = new int[N];
			visited = new boolean[N];
			minDistance = Integer.MAX_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			company[0] = x;
			company[1] = y;

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			home[0] = x;
			home[1] = y;

			for (int i = 0; i < N; i++) {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				customers[i][0] = x;
				customers[i][1] = y;
			}
			
			permutation(0);
			
			System.out.printf("#%d %d\n", tc, minDistance);
			
		}

	}

	private static void permutation(int depth) {

		if (depth == N) {
			findBestPath(selected);
			if (distance < minDistance) {
				minDistance = distance;
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i] != true) {
				visited[i] = true;
				selected[depth] = i;
				permutation(depth + 1);
				visited[i] = false;
			}
		}

	}

	private static void findBestPath(int[] selected) {
		
		distance = 0;
		int x1, y1, x2, y2;
		
		x1 = company[0];
		y1 = company[1];
		x2 = customers[selected[0]][0];
		y2 = customers[selected[0]][1];
		distance += calDistance(x1, y1, x2, y2);
		
		for (int i = 0; i < N - 1; i++) {
			x1 = customers[selected[i]][0];
			y1 = customers[selected[i]][1];
			x2 = customers[selected[i + 1]][0];
			y2 = customers[selected[i + 1]][1];
			distance += calDistance(x1, y1, x2, y2);
		}
		
		x1 = customers[selected[N - 1]][0];
		y1 = customers[selected[N - 1]][1];
		x2 = home[0];
		y2 = home[1];
		distance += calDistance(x1, y1, x2, y2);
		
	}

	private static int calDistance(int x1, int y1, int x2, int y2) {

		return Math.abs(x1 - x2) + Math.abs(y1 - y2);

	}

}
