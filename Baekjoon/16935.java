import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int r = 0; r < R; r++) {
			
			int type = Integer.parseInt(st.nextToken());

			switch (type) {
			case 1:
				Type1();
				break;
			case 2:
				Type2();
				break;
			case 3:
				Type3();
				break;
			case 4:
				Type4();
				break;
			case 5:
				Type5();
				break;
			case 6:
				Type6();
				break;
			}

		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

	private static void Type1() {

		int value;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N / 2; j++) {
				value = map[j][i];
				map[j][i] = map[N - j - 1][i];
				map[N - j - 1][i] = value;
			}
		}

	}

	private static void Type2() {

		int value;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				value = map[i][j];
				map[i][j] = map[i][M - j - 1];
				map[i][M - j - 1] = value;
			}
		}

	}

	private static void Type3() {

		int value = N;
		N = M;
		M = value;

		int[] tmp;
		int[][] tmpR90 = new int[N][M];

		for (int i = 0; i < N; i++) {

			tmp = new int[M];

			for (int j = 0; j < M; j++) {
				tmp[j] = map[M - j - 1][i];
			}

			tmpR90[i] = tmp;
		}

		map = tmpR90;

	}

	private static void Type4() {

		int value = N;
		N = M;
		M = value;

		int tmp[];
		int[][] tmpL90 = new int[N][M];

		for (int i = 0; i < N; i++) {

			tmp = new int[M];

			for (int j = 0; j < M; j++) {
				tmp[j] = map[j][N - i - 1];
			}

			tmpL90[i] = tmp;
		}

		map = tmpL90;

	}

	private static void Type5() {

		int[][] tmp = new int[N][M];
		int n = N / 2;
		int m = M / 2;

		// 1 -> 2
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tmp[i][m + j] = map[i][j];
			}
		}

		// 2 -> 3
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tmp[n + i][m + j] = map[i][m + j];
			}
		}

		// 3 -> 4
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tmp[n + i][j] = map[n + i][m + j];
			}
		}

		// 4 -> 1
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tmp[i][j] = map[n + i][j];
			}
		}

		map = tmp;

	}

	private static void Type6() {

		int[][] tmp = new int[N][M];
		int n = N / 2;
		int m = M / 2;

		// 1 -> 4
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tmp[n + i][j] = map[i][j];
			}
		}

		// 4 -> 3
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tmp[n + i][m + j] = map[n + i][j];
			}
		}

		// 3 -> 2
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tmp[i][m + j] = map[n + i][m + j];
			}
		}

		// 2 -> 1
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tmp[i][j] = map[i][m + j];
			}
		}

		map = tmp;

	}

}
