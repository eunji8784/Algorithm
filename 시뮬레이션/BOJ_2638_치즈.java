import java.io.*;
import java.util.*;

public class Main {

	private static final int[] DX = { -1, 1, 0, 0 };
	private static final int[] DY = { 0, 0, -1, 1 };

	private static int N, M;
	private static int[][] map;
	private static Queue<Position> cheese;

	private static class Position {
		int x, y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		getInput();
		System.out.println(solution());
	}

	private static int solution() {
		int time = 0;
		while (cheese.size() != 0) {
			time++;
			checkOuterAir();
			removeCheese();
		}
		return time;
	}

	private static void removeCheese() {
		int length = cheese.size();

		for (int i = 0; i < length; i++) {
			Position cp = cheese.poll();

			if (map[cp.x][cp.y] >= 3) {
				map[cp.x][cp.y] = 0;
			} else {
				map[cp.x][cp.y] = 1;
				cheese.offer(cp);
			}
		}
	}

	private static void checkOuterAir() {
		boolean[][] outerCheck = new boolean[N][M];
		Queue<Position> que = new LinkedList<>();

		que.offer(new Position(0, 0));
		outerCheck[0][0] = true;

		while (!que.isEmpty()) {
			Position current = que.poll();

			for (int idx = 0; idx < 4; idx++) {
				int nx = current.x + DX[idx];
				int ny = current.y + DY[idx];

				if (!isInArea(nx, ny)) {
					continue;
				}

				if (map[nx][ny] == 0 && !outerCheck[nx][ny]) {
					que.offer(new Position(nx, ny));
					outerCheck[nx][ny] = true;
				}
				
				if (map[nx][ny] >= 1) {
					map[nx][ny]++;
				}
			}
		}
	}

	private static boolean isInArea(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		cheese = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					cheese.offer(new Position(i, j));
				}
			}
		}

		br.close();
	}

}
