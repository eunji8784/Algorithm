import java.io.*;
import java.util.*;

public class Main {
	private static final int[] DX = { 0, 1, 0, -1 };
	private static final int[] DY = { 1, 0, -1, 0 };

	private static class SnakeDir {
		int time;
		char dir;

		public SnakeDir(int time, char dir) {
			this.time = time;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		int k = Integer.parseInt(br.readLine());

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x - 1][y - 1] = 1;
		}

		int l = Integer.parseInt(br.readLine());
		SnakeDir[] snakeDir = new SnakeDir[l];

		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			snakeDir[i] = new SnakeDir(time, dir);
		}

		int time = 0, idx = 0, dir = 0;
		Deque<int[]> dq = new LinkedList<>();
		dq.offer(new int[] { 0, 0 });
		board[0][0] = 8;

		while (true) {
			if (idx < l) {
				SnakeDir sd = snakeDir[idx];
				if (time == sd.time) {
					idx++;
					dir = (sd.dir == 'L' ? dir + 3 : dir + 1) % 4;
				}
			}
			
			time++;
			int[] headLoc = dq.peekLast();
			int x = headLoc[0] + DX[dir];
			int y = headLoc[1] + DY[dir];

			if (x < 0 || x >= n || y < 0 || y >= n || board[x][y] == 8) {
				break;
			}

			if (board[x][y] == 0) {
				int[] tailLoc = dq.pollFirst();
				board[tailLoc[0]][tailLoc[1]] = 0;
			}

			board[x][y] = 8;
			dq.offer(new int[] { x, y });
		}

		bw.write(String.valueOf(time));
		bw.flush();
		bw.close();
		br.close();
	}
}
