import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		final String VALID = "valid";
		final String INVALID = "invalid";

		while (true) {
			String str = br.readLine();

			if (str.equals("end")) {
				break;
			}

			char[][] map = new char[3][3];
			int idx = 0, countX = 0, countO = 0;

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					char chr = str.charAt(idx++);
					map[i][j] = chr;
					if (chr == 'X') {
						countX++;
					} else if (chr == 'O') {
						countO++;
					}
				}
			}

			if (countO > countX || countX - countO > 1) {
				bw.write(INVALID + "\n");
				continue;
			}

			boolean isBingoX = bingo('X', map);
			boolean isBingoO = bingo('O', map);

			if (isBingoX && isBingoO) {
				bw.write(INVALID + "\n");
			} else if ((isBingoX && countX == countO) || (isBingoO && countX != countO)) {
				bw.write(INVALID + "\n");
			} else if (!isBingoX && !isBingoO && countX + countO < 9) {
				bw.write(INVALID + "\n");
			} else {
				bw.write(VALID + "\n");
			}

		}

		bw.close();
		br.close();
	}

	private static boolean bingo(char type, char[][] map) {
		for (int i = 0; i < 3; i++) {
			if (map[i][0] == type && map[i][1] == type && map[i][2] == type) {
				return true;
			}
		}

		for (int i = 0; i < 3; i++) {
			if (map[0][i] == type && map[1][i] == type && map[2][i] == type) {
				return true;
			}
		}

		if (map[0][0] == type && map[1][1] == type && map[2][2] == type) {
			return true;
		}

		if (map[0][2] == type && map[1][1] == type && map[2][0] == type) {
			return true;
		}

		return false;
	}

}
