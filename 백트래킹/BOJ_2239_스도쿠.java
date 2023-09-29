import java.io.*;

public class Main {
	
	private static int[][] map;
	private static boolean[][] col, row, box;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[9][9];
		col = new boolean[9][10];
		row = new boolean[9][10];
		box = new boolean[9][10];
		
		for (int i = 0; i < 9; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				int num = tmp[j] - '0';
				map[i][j] = num;
				if (num != 0) {
					col[i][num] = true;
					row[j][num] = true;
					box[(3 * (i / 3)) + (j / 3)][num] = true;
				}
			}
		}
		
		solve(0, 0);
		
		br.close();
	}
	
	private static void solve(int x, int y) {
		if (y == 9) {
			solve(x + 1, 0);
			return;
		}
		
		if (x == 9) {
			printMap();
			System.exit(0);
		}
		
		if (map[x][y] == 0) {
			for (int num = 1; num <= 9; num++) {
				if (isPossible(x, y, num)) {
					map[x][y] = num;
					col[x][num] = true;
					row[y][num] = true;
					box[(3 * (x / 3)) + (y / 3)][num] = true;
					solve(x, y + 1);
					map[x][y] = 0;
					col[x][num] = false;
					row[y][num] = false;
					box[(3 * (x / 3)) + (y / 3)][num] = false;
				}
			}
		} else {
			solve(x, y + 1);
		}
	}

	private static boolean isPossible(int x, int y, int num) {
		if (col[x][num] || row[y][num]) return false;	
		if (box[(3 * (x / 3)) + (y / 3)][num]) return false;
		return true;
	}
	
	private static void printMap() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}

/*  x       y
 * 0 ~ 2, 0 ~ 2 = 0, 0 0
 * 0 ~ 2, 3 ~ 5 = 1, 0 1
 * 0 ~ 2, 6 ~ 8 = 2, 0 2
 * 3 ~ 5, 0 ~ 2 = 3, 1 0
 * 3 ~ 5, 3 ~ 5 = 4, 1 1
 * 3 ~ 5, 6 ~ 8 = 5, 1 2
 * 6 ~ 8, 0 ~ 2 = 6, 2 0
 * 6 ~ 8, 3 ~ 5 = 7, 2 1
 * 6 ~ 8, 6 ~ 8 = 8, 2 2
 */
