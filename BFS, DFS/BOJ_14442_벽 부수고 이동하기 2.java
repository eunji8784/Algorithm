import java.io.*;
import java.util.*;

public class Main {
	private static final int[] DX = { -1, 1, 0, 0 };
	private static final int[] DY = { 0, 0, -1, 1 };
	
	private static int N, M, K;
	private static int[][] map;
	
	private static class Location {
		int x, y, k, dist;
		
		public Location(int x, int y, int k, int dist) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j - 1) - '0';
			}
		}
		
		System.out.println(bfs());
		br.close();
	}
	
	private static int bfs() {
		Queue<Location> que = new LinkedList<>();
		boolean[][][] vst = new boolean[N + 1][M + 1][K + 1];
		
		que.offer(new Location(1, 1, 0, 1));
		vst[1][1][0] = true;
		
		while(!que.isEmpty()) {
			Location cur = que.poll();
			int k = cur.k;
			int dist = cur.dist;
			
			if (cur.x == N && cur.y == M) return dist;
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + DX[i];
				int ny = cur.y + DY[i];
				
				if (nx <= 0 || nx > N || ny <= 0 || ny > M) continue;
				
				if (map[nx][ny] == 0 && !vst[nx][ny][k]) {
					vst[nx][ny][k] = true;
					que.offer(new Location(nx, ny, k, dist + 1));
				} else {
					if (k < K && !vst[nx][ny][k + 1]) {
						vst[nx][ny][k + 1] = true;
						que.offer(new Location(nx, ny, k + 1, dist + 1));
					}
				}
			}
		}
		
		return -1;
	}
}
