import java.io.*;
import java.util.*;

public class Main {

	private static final int[] DX = { -1, 1, 0, 0 };
	private static final int[] DY = { 0, 0, -1, 1 };
	
	private static int N, M;
	private static char[][] map;
	
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
		map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		System.out.println(bfs());
		br.close();
	}
	
	private static int bfs() {
		Queue<Location> que = new LinkedList<>();
		boolean[][] vst = new boolean[N][M];
		
		que.offer(new Location(0, 0, 1));
		vst[0][0] = true;
		
		while (!que.isEmpty()) {
			Location cur = que.poll();
			int x = cur.x;
			int y = cur.y;
			int depth = cur.depth;
			
			if (x == N - 1 && y == M - 1) {
				return depth;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + DX[i];
				int ny = y + DY[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || vst[nx][ny]) {
					continue;
				}
				
				if (map[nx][ny] == '1') {
					que.offer(new Location(nx, ny, depth + 1));
					vst[nx][ny] = true;
				}
			}
		}
		
		return -1;
	}

}
