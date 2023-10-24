import java.io.*;
import java.util.*;

public class Main {
	private static final int[] DX = { -1, 1, 0, 0 };
	private static final int[] DY = { 0, 0, -1, 1 };
	
	private static int N, M, P, blankCnt;
	private static int[] S, players;
	private static int[][] map;
	
	private static class Location {
		int x, y, depth;
		
		public Location(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		blankCnt = 0;
		S = new int[P + 1];
		players = new int[P + 1];
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= P; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (tmp[j] == '.') {
					map[i][j] = 0;
				} else if (tmp[j] == '#') {
					map[i][j] = -1;
				} else {
					map[i][j] = tmp[j] - '0';
				}
				if (map[i][j] == 0) {
					blankCnt++;
				} else if (map[i][j] > 0) {
					players[map[i][j]]++;
				}
			}
		}
		
		solve();
		
		StringBuilder answer = new StringBuilder();
		for (int i = 1; i <= P; i++) {
			answer.append(players[i] + " ");
		}
		
		System.out.println(answer.toString());
		br.close();
	}
	
	private static void solve() {
		while (true) {
			for (int player = 1; player <= P; player++) {
				boolean[][] vst = new boolean[N][M];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (!vst[i][j] && map[i][j] == player) {
							bfs(i, j, player, vst);
							if (blankCnt == 0) return;
						}
					}
				}
			}
		}
	}

	private static void bfs(int i, int j, int player, boolean[][] vst) {
		Queue<Location> que = new LinkedList<>();
		que.offer(new Location(i, j, 0));
		vst[i][j] = true;
		
		while (!que.isEmpty()) {
			Location cur = que.poll();
			
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + DX[dir];
				int ny = cur.y + DY[dir];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] != 0) {
					continue;
				}
				
				blankCnt--;
				vst[nx][ny] = true;
				map[nx][ny] = player;
				players[player]++;
				if (cur.depth + 1 == S[player]) continue;
				que.offer(new Location(nx, ny, cur.depth + 1));
			}
		}
	}
}
