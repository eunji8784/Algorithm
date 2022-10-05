import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map = new int[9][9];
	// vst1[i][j] -> i번 행에 j가 들어가 있는가?
	static boolean[][] vst1 = new boolean[9][10];
	// vst2[i][j] -> i번 열에 j가 들어가 있는가?
	static boolean[][] vst2 = new boolean[9][10];
	// vst3[i][j] -> i번 박스에 j가 들어가 있는가?
	static boolean[][] vst3 = new boolean[9][10];

//	vst3[i][j]
//  박스 번호 i
//	0 1 2
//	3 4 5
//	7 8 9
//	박스의 번호: (x / 3 * 3) + (y / 3)

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (map[i][j] != 0) {
					vst1[i][map[i][j]] = true;
					vst2[j][map[i][j]] = true;
					vst3[box(i, j)][map[i][j]] = true;
				}
			}
		}

		sudoku(0, 0);

	}

	private static void sudoku(int x, int y) {

		// 마지막 행까지 모두 돌았으면 맵을 출력하고 종료한다.
		if (x == 9) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j] + " ");
				}
				sb.append("\n");
			}
			System.out.print(sb.toString());
			System.exit(0);
		}

		// 현재 값이 0이 아니면 바로 다음 열의 스도쿠 함수를 실행한다.
		if (map[x][y] != 0) {
			// 열이 마지막(8)을 넘기면 1로 초기화한다.
			sudoku(x + (y + 1) / 9, (y + 1) % 9);
			return;
		}

		/*
		 * 현재 값이 0이면 1~9까지 숫자 중 현재 위치에 들어갈 수 있는 수를 각각 저장하고 다음 열의 스도쿠 함수를 실행시킨 후 다시 0으로 바꾼다.
		 */
		for (int i = 1; i <= 9; i++) {
			if (vst1[x][i] || vst2[y][i] || vst3[box(x, y)][i]) {
				continue;
			}
			map[x][y] = i;
			vst1[x][i] = vst2[y][i] = vst3[box(x, y)][i] = true;
			sudoku(x + (y + 1) / 9, (y + 1) % 9);
			map[x][y] = 0;
			vst1[x][i] = vst2[y][i] = vst3[box(x, y)][i] = false;
		}

	}

	private static int box(int x, int y) {
		return (x / 3 * 3) + (y / 3);
	}
}
