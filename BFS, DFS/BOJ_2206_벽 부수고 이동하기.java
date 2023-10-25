import java.io.*;
import java.util.*;

public class Main {

	private static final int[] DIRECTION_X = { -1, 1, 0, 0 };
	private static final int[] DIRECTION_Y = { 0, 0, -1, 1 };

	private static int N, M, answer = 0;
	private static int[][] map;

	private static class Position {
		int x, y, depth, isWallBroken;

		public Position(int x, int y, int depth, int isWallBroken) {
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.isWallBroken = isWallBroken;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = Character.getNumericValue(tmp[j]);
			}
		}

		bfs();
		System.out.println(answer == 0 ? -1 : answer);
		br.close();

	}

	private static void bfs() {

		Queue<Position> que = new LinkedList<>();
		boolean[][][] visited = new boolean[N][M][2];

		que.offer(new Position(0, 0, 1, 0));
		visited[0][0][0] = true;

		while (!que.isEmpty()) {
			Position current = que.poll();

			if (isEnd(current.x, current.y)) {
				answer = current.depth;
				return;
			}

			moveToAllDirections(current, que, visited);
		}
	}

	private static boolean isEnd(int x, int y) {
		return x == N - 1 && y == M - 1;
	}

	private static void moveToAllDirections(Position current, Queue<Position> queue, boolean[][][] visited) {
		for (int i = 0; i < 4; i++) {
			int nextX = current.x + DIRECTION_X[i];
			int nextY = current.y + DIRECTION_Y[i];

			if (!isInArea(nextX, nextY)) {
				continue;
			}

			// 벽을 부수지 않고 이동
			if (isEmptySpace(nextX, nextY) && !visited[nextX][nextY][current.isWallBroken]) {
				queue.offer(new Position(nextX, nextY, current.depth + 1, current.isWallBroken));
				visited[nextX][nextY][current.isWallBroken] = true;
			}
			// 벽을 부수고 이동
			if (isWall(nextX, nextY) && current.isWallBroken == 0 && !visited[nextX][nextY][current.isWallBroken + 1]) {
				queue.offer(new Position(nextX, nextY, current.depth + 1, current.isWallBroken + 1));
				visited[nextX][nextY][current.isWallBroken + 1] = true;
			}
		}
	}

	private static boolean isInArea(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	private static boolean isEmptySpace(int x, int y) {
		return map[x][y] == 0;
	}

	private static boolean isWall(int x, int y) {
		return map[x][y] == 1;
	}

}
