import java.io.*;
import java.util.*;

public class Main {

	private static final int[] DX = { -1, 1, 0, 0 };
	private static final int[] DY = { 0, 0, -1, 1 };

	private static int M, N, K;
	private static int[][] map;
	private static Queue<Position> loc;

	private static class Position {
		int x, y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			getInput(br);
			System.out.println(solve());
		}

		br.close();
	}

	private static int solve() {
		boolean[][] vst = new boolean[M][N];
		int answer = 0;
		
		while (!loc.isEmpty()) {
			Position current = loc.poll();
			if (!vst[current.x][current.y]) {
				answer++;
				bfs(current, vst);
			}
		}
		
		return answer;
	}
	
	private static void bfs(Position p, boolean[][] vst) {
		Queue<Position> que = new LinkedList<>();
		que.offer(p);
		vst[p.x][p.y] = true;
		
		while (!que.isEmpty()) {
			Position current = que.poll();
			int x = current.x;
			int y = current.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + DX[i];
				int ny = y + DY[i];
				
				if (!isInArea(nx, ny) || vst[nx][ny]) {
					continue;
				}
				
				if (map[nx][ny] == 1) {
					que.offer(new Position(nx, ny));
					vst[nx][ny] = true;
				}
			}
		}
	}
	
	private static boolean isInArea(int x, int y) {
		return x >= 0 && x < M && y >= 0 && y < N;
	}

	private static void getInput(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		loc = new LinkedList<>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			map[x][y] = 1;
			loc.offer(new Position(x, y));
		}
	}

}
