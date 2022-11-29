import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, ans, ansCnt;
	static ArrayList<Point> cores;
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = Integer.MAX_VALUE;
			ansCnt = 0;
			cores = new ArrayList<>();
			int[][] cell = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					cell[i][j] = Integer.parseInt(st.nextToken());
					if (i > 0 && i < N - 1 && j > 0 && j < N - 1 && cell[i][j] == 1) {
						cores.add(new Point(i, j));
					}
				}
			}
			dfs(0, 0, 0, cell);
			System.out.printf("#%d %d\n", tc, ans);
		}

	}

	private static void dfs(int index, int cnt, int length, int[][] map) {
		
		if (index == cores.size()) {
			if (cnt > ansCnt) {
				ansCnt = cnt;
				ans = length;
			}
			else if (cnt == ansCnt) {
				ans = Math.min(ans, length);
			}
			return;
		}
		
		Point p = cores.get(index);
		
		for (int i = 0; i < 4; i++) {
			
			if (!check(p.x, p.y, map, i)) {
				continue;
			}
			
			int nx = p.x;
			int ny = p.y;
			int lTmp = 0;
			
			while (true) {
				nx += dx[i];
				ny += dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					break;
				}
				map[nx][ny] = 2;
				lTmp++;
			}
			
			dfs(index + 1, cnt + 1, length + lTmp, map);
			
			nx = p.x;
			ny = p.y;
			while (true) {
				nx += dx[i];
				ny += dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					break;
				}
				map[nx][ny] = 0;
			}
			
		}
		
		dfs(index + 1, cnt, length, map);
		
	}

	private static boolean check(int x, int y, int[][] map, int dir) {
		while (true) {
			x += dx[dir];
			y += dy[dir];
			if (x < 0 || x >= N || y < 0 || y >= N) {
				break;
			}
			if (map[x][y] != 0) {
				return false;
			}
		}
		return true;
	}

}
