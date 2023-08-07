import java.io.*;
import java.util.*;

public class Main {

	private static final int[] DIRECTION_X = { -1, 1, 0, 0 };
	private static final int[] DIRECTION_Y = { 0, 0, -1, 1 };

	private static int N;
	private static Map<Integer, Set<Integer>> map = new LinkedHashMap<>();
	private static int[][] seat;

	private static class Position implements Comparable<Position> {
		int x, y, like, blank;

		public Position(int x, int y, int like, int blank) {
			this.x = x;
			this.y = y;
			this.like = like;
			this.blank = blank;
		}

		@Override
		public int compareTo(Position p) {
			if (this.like == p.like) {
				if (this.blank == p.blank) {
					if (this.x == p.x) {
						return Integer.compare(this.y, p.y);
					}
					return Integer.compare(this.x, p.x);
				}
				return Integer.compare(p.blank, this.blank);
			}
			return Integer.compare(p.like, this.like);
		}
	}

	public static void main(String[] args) throws IOException {

		getInput();

		for (int key : map.keySet()) {
			findSeat(key, map.get(key));
		}

		int answer = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer += calAnswer(i, j);
			}
		}

		System.out.println(answer);
	}

	private static void findSeat(int studentNum, Set<Integer> likeStudentsNum) {

		ArrayList<Position> lst = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (seat[i][j] != 0) continue;

				int blank = 0, like = 0;

				for (int idx = 0; idx < 4; idx++) {
					int nx = i + DIRECTION_X[idx];
					int ny = j + DIRECTION_Y[idx];

					if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
						continue;
					}

					if (likeStudentsNum.contains(seat[nx][ny])) {
						like++;
					}

					if (seat[nx][ny] == 0) {
						blank++;
					}
				}

				lst.add(new Position(i, j, like, blank));

			}
		}

		Collections.sort(lst);

		seat[lst.get(0).x][lst.get(0).y] = studentNum;

	}

	private static int calAnswer(int x, int y) {

		int count = 0;
		int studentNum = seat[x][y];
		Set<Integer> likeStudentsNum = map.get(studentNum);

		for (int idx = 0; idx < 4; idx++) {
			int nx = x + DIRECTION_X[idx];
			int ny = y + DIRECTION_Y[idx];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				continue;
			}

			if (likeStudentsNum.contains(seat[nx][ny])) {
				count++;
			}
		}

		return (count == 0 ? 0 : (int) Math.pow(10, count - 1));

	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		seat = new int[N][N];

		StringTokenizer st;

		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			Set<Integer> set = new HashSet<>(4);
			for (int j = 0; j < 4; j++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			map.put(key, set);
		}
	}

}
