import java.io.*;
import java.util.*;

public class Main {
	private static final int[] DX = { 0, 1, 0, -1 };
	private static final int[] DY = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		int k = Integer.parseInt(br.readLine());

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			board[x][y] = 1;
		}

		int l = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int changeTime = Integer.parseInt(st.nextToken());
		char changeDir = st.nextToken().charAt(0);

		int time = 0, dir = 0;
		Deque<int[]> dq = new LinkedList<>();
		dq.offer(new int[] { 0, 0 });
		board[0][0] = 8;

		while (true) {
			if (time == changeTime) {
				dir += (changeDir == 'L' ? 3 : 1);
				dir %= 4;
				if (l > 1) {
					st = new StringTokenizer(br.readLine());
					changeTime = Integer.parseInt(st.nextToken());
					changeDir = st.nextToken().charAt(0);
					l--;
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
