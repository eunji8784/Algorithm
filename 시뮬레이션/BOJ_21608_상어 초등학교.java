import java.io.*;
import java.util.*;

public class Main {

	private static final int[] DIRECTION_X = { -1, 1, 0, 0 };
	private static final int[] DIRECTION_Y = { 0, 0, -1, 1 };

	private static int N;
	private static Map<Integer, Set<Integer>> preferenceMap = new LinkedHashMap<>();
	private static int[][] seat;

	private static class Position implements Comparable<Position> {
		int x, y, likedCount, emptyCount;

		public Position(int x, int y, int likedCount, int emptyCount) {
			this.x = x;
			this.y = y;
			this.likedCount = likedCount;
			this.emptyCount = emptyCount;
		}

		@Override
		public int compareTo(Position p) {
			if (this.likedCount == p.likedCount) {
				if (this.emptyCount == p.emptyCount) {
					if (this.x == p.x) {
						return Integer.compare(this.y, p.y);
					}
					return Integer.compare(this.x, p.x);
				}
				return Integer.compare(p.emptyCount, this.emptyCount);
			}
			return Integer.compare(p.likedCount, this.likedCount);
		}
	}

	public static void main(String[] args) throws IOException {
		getInput();
		assignSeats();
		System.out.println(calculateSatisfaction());
	}

	private static void assignSeats() {
		for (int key : preferenceMap.keySet()) {
			findBestSeat(key, preferenceMap.get(key));
		}
	}

	private static void findBestSeat(int studentNum, Set<Integer> likeStudentsNum) {
		ArrayList<Position> lst = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (isAlreadySeat(i, j)) {
					continue;
				}

				int emptyCount = 0, likedCount = 0;

				for (int idx = 0; idx < 4; idx++) {
					int nx = i + DIRECTION_X[idx];
					int ny = j + DIRECTION_Y[idx];

					if (!isInArea(nx, ny)) {
						continue;
					}

					if (isLikeStudentExist(likeStudentsNum, nx, ny)) {
						likedCount++;
					}

					if (isSeatEmpty(nx, ny)) {
						emptyCount++;
					}
				}

				lst.add(new Position(i, j, likedCount, emptyCount));

			}
		}

		Collections.sort(lst);
		Position position = lst.get(0);
		seat[position.x][position.y] = studentNum;
	}

	private static int calculateSatisfaction() {
		int totalSatisfaction = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				totalSatisfaction += getStudentSatisfaction(i, j);
			}
		}

		return totalSatisfaction;
	}

	private static int getStudentSatisfaction(int x, int y) {
		int count = 0;
		int studentNum = seat[x][y];
		Set<Integer> likeStudentsNum = preferenceMap.get(studentNum);

		for (int idx = 0; idx < 4; idx++) {
			int nx = x + DIRECTION_X[idx];
			int ny = y + DIRECTION_Y[idx];

			if (!isInArea(nx, ny)) {
				continue;
			}

			if (isLikeStudentExist(likeStudentsNum, nx, ny)) {
				count++;
			}
		}

		return (count == 0 ? 0 : (int) Math.pow(10, count - 1));
	}

	private static boolean isAlreadySeat(int x, int y) {
		return (seat[x][y] != 0);
	}

	private static boolean isLikeStudentExist(Set<Integer> set, int x, int y) {
		return set.contains(seat[x][y]);
	}

	private static boolean isSeatEmpty(int x, int y) {
		return (seat[x][y] == 0);
	}

	private static boolean isInArea(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N);
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
			preferenceMap.put(key, set);
		}

		br.close();
	}

}
