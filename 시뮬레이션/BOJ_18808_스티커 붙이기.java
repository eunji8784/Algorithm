import java.io.*;
import java.util.*;

public class Main {
	private static int N, M, K, answer;
	private static int[][] map;
	private static List<Location>[] stickers;

	private static class Location {
		int x, y;

		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = 0;
		map = new int[N][M];
		stickers = new ArrayList[K];

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			boolean flag = false;
			stickers[k] = new ArrayList<>();
			int x = 0, y = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					int num = Integer.parseInt(st.nextToken());
					if (num == 1) {
						if (!flag) {
							flag = true;
							stickers[k].add(new Location(0, 0));
							x = i;
							y = j;
						} else {
							stickers[k].add(new Location(i - x, j - y));
						}
					}
				}
			}
		}

		for (int k = 0; k < K; k++) {
			for (int r = 0; r < 4; r++) {
				if (solve(k)) break;
				rotate(k);
			}
		}

		System.out.println(answer);
		br.close();
	}

	private static void rotate(int k) {
		for (Location loc : stickers[k]) {
			int x = loc.x;
			int y = loc.y;
			loc.x = y;
			loc.y = -x;
		}
	}

	private static boolean solve(int k) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) continue;
				if (check(i, j, k)) {
					setSticker(i, j, k);
					return true;
				}
			}
		}
		return false;
	}

	private static boolean check(int x, int y, int k) {
		for (Location loc : stickers[k]) {
			int nx = x + loc.x;
			int ny = y + loc.y;	
			if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1) {
				return false;
			}
		}	
		return true;
	}
	
	private static void setSticker(int x, int y, int k) {
		for (Location loc : stickers[k]) {
			int nx = x + loc.x;
			int ny = y + loc.y;	
			map[nx][ny] = 1;
			answer++;
		}
	}
 }
