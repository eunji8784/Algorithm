import java.io.*;
import java.util.*;

public class Main {

	private static final int[] DX = { -1, 1, 0, 0 };
	private static final int[] DY = { 0, 0, -1, 1 };

	private static char[][] seat = new char[5][5];
	private static int[][] seatNum = new int[5][5];
	private static Integer[] selected = new Integer[7];
	private static int answer = 0;

	private static class Position {
		int x, y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			seat[i] = br.readLine().toCharArray();
			for (int j = 0; j < 5; j++) {
				seatNum[i][j] = i * 5 + j + 1;
			}
		}
		
		combination(0, 1);
		System.out.println(answer);
		
		br.close();
	}

	private static void combination(int count, int index) {
		if (count == 7) {
			if(bfs(selected[0], new HashSet<>(Arrays.asList(selected)))) answer++;
			return;
		}

		for (int i = index; i <= 25; i++) {
			selected[count] = i;
			combination(count + 1, i + 1);
		}
	}

	private static boolean bfs(int start, Set<Integer> set) {
		int startX = (start % 5 == 0 ? start / 5 - 1 : start / 5);
		int startY = (start % 5 == 0 ? 4 : start % 5 - 1);

		int count = 1, countS = 0;

		Queue<Position> que = new LinkedList<>();
		boolean[][] vst = new boolean[5][5];

		que.offer(new Position(startX, startY));
		vst[startX][startY] = true;
		if (seat[startX][startY] == 'S') countS++;

		while (!que.isEmpty()) {
			Position current = que.poll();

			for (int i = 0; i < 4; i++) {
				int nx = current.x + DX[i];
				int ny = current.y + DY[i];

				if (!isInArea(nx, ny) || vst[nx][ny]) {
					continue;
				}

				if (set.contains(seatNum[nx][ny])) {
					que.offer(new Position(nx, ny));
					vst[nx][ny] = true;
					count++;
					if (seat[nx][ny] == 'S') countS++;
				}
			}
		}

		if (count == 7 && countS >= 4) {
			return true;
		}
		
		return false;
	}

	private static boolean isInArea(int nx, int ny) {
		return nx >= 0 && nx < 5 && ny >= 0 && ny < 5;
	}

}
