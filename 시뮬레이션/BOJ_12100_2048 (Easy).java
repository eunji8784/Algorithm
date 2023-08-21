import java.io.*;
import java.util.*;

public class Main {

	private static final int[] DX = { -1, 1, 0, 0 };
	private static final int[] DY = { 0, 0, -1, 1 };

	private static int N, max = -1;
	private static int[][] board;
	private static int[] selected = new int[5];
	private static Queue<Position> blocks = new LinkedList<>();

	private static class Position implements Comparable<Position> {
		int x, y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Position p) {
			if (this.x == p.x) {
				return Integer.compare(this.y, p.y);
			}
			return Integer.compare(this.x, p.x);
		}
	}

	public static void main(String[] args) throws IOException {
		getInput();
		permutation(0);
		System.out.println(max);
	}

	private static void permutation(int depth) {
		if (depth == 5) {
			max = Math.max(max, solution(selected));
			return;
		}

		for (int i = 0; i < 4; i++) {
			selected[depth] = i;
			permutation(depth + 1);
		}
	}

	private static int solution(int[] selected) {
		Queue<Position> backupQue = new LinkedList<>(blocks);
		int[][] backup = new int[N][N];
		copyMap(backup, board);

		for (int direction : selected) {
			move(direction, backupQue, backup);
		}

		int semiMax = -1;
		
		while (!backupQue.isEmpty()) {
			Position p = backupQue.poll();
			semiMax = Math.max(semiMax, backup[p.x][p.y]);
		}
		
		return semiMax;
	}

	private static void move(int direction, Queue<Position> backupQue, int[][] backup) {
		PriorityQueue<Position> pq = sortQueue(direction);
		pq.addAll(backupQue);
		backupQue.clear();

		boolean[][] isAlreadyAdd = new boolean[N][N];

		int length = pq.size();

		for (int l = 0; l < length; l++) {
			Position current = pq.poll();
			int x = current.x;
			int y = current.y;

			while (true) {
				int nx = x + DX[direction];
				int ny = y + DY[direction];

				if (!isInArea(nx, ny) || isAlreadyAdd[nx][ny]
						|| backup[nx][ny] != 0 && backup[nx][ny] != backup[x][y]) {
					backupQue.offer(new Position(x, y));
					break;
				}

				if (backup[nx][ny] == backup[x][y] && !isAlreadyAdd[nx][ny]) {
					backup[nx][ny] *= 2;
					backup[x][y] = 0;
					isAlreadyAdd[nx][ny] = true;
					break;
				}

				if (backup[nx][ny] == 0) {
					backup[nx][ny] = backup[x][y];
					backup[x][y] = 0;
					x = nx;
					y = ny;
				}
			}
		}
	}

	private static boolean isInArea(int nx, int ny) {
		return nx >= 0 && nx < N && ny >= 0 && ny < N;
	}

	private static PriorityQueue<Position> sortQueue(int direction) {
		switch (direction) {
		case 1: // 하
			return new PriorityQueue<>((p1, p2) -> Integer.compare(p2.x, p1.x));
		case 3: // 우
			return new PriorityQueue<>((p1, p2) -> Integer.compare(p2.y, p1.y));
		default:
			return new PriorityQueue<>();
		}
	}

	private static void copyMap(int[][] backup, int[][] board) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				backup[i][j] = board[i][j];
			}
		}
	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] != 0) {
					blocks.offer(new Position(i, j));
				}
			}
		}

		br.close();
	}

}
