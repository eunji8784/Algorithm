import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int R, C;
	static char[][] lake;
	static int[] swanLocX, swanLocY; // 두 백조의 위치
	static Queue<Point> water, swan;

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		lake = new char[R][C];
		swanLocX = new int[2];
		swanLocY = new int[2];
		water = new LinkedList<>();
		int idx = 0;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			lake[i] = str.toCharArray();
			for (int j = 0; j < C; j++) {
				if (lake[i][j] == 'L') {
					swanLocX[idx] = i;
					swanLocY[idx++] = j;
				}
				if (lake[i][j] != 'X') { // 물과 백조의 위치를 저장한다. (백조가 있는 곳도 물이므로)
					water.offer(new Point(i, j));
				}
			}
		}

		swan = new LinkedList<>();
		boolean[][] swanVst = new boolean[R][C];
		swan.offer(new Point(swanLocX[0], swanLocY[0]));
		swanVst[swanLocX[0]][swanLocY[0]] = true;

		int Ans = 0;
		while (!swanCanMeet(swanVst)) {
			Ans++;
			icebergMelts();
		}
		br.close();
		System.out.println(Ans);

	}

	private static boolean swanCanMeet(boolean[][] swanVst) {

    // 다음 날에 탐색할 위치를 저장할 큐 
		Queue<Point> next = new LinkedList<>();

		while (!swan.isEmpty()) {
			Point current = swan.poll();
			int x = current.x;
			int y = current.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= R || ny < 0 || ny >= C || swanVst[nx][ny]) {
					continue;
				}
        // 두 백조가 만나면 종료 
				if (nx == swanLocX[1] && ny == swanLocY[1]) {
					return true;
				}
				if (lake[nx][ny] == '.') {
					swan.offer(new Point(nx, ny));
				} else if (lake[nx][ny] == 'X') {
					next.offer(new Point(nx, ny));
				}
				swanVst[nx][ny] = true;
			}
		}

		swan = next;

		return false;

	}

	private static void icebergMelts() {

		int size = water.size();

		for (int idx = 0; idx < size; idx++) {
			Point current = water.poll();
			int x = current.x;
			int y = current.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
					continue;
				}

				if (lake[nx][ny] == 'X') {
					lake[nx][ny] = '.';
					water.offer(new Point(nx, ny));
				}
			}

		}

	}

}
