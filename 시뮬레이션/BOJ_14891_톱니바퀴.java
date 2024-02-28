import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int[][] map = new int[4][8];
	public static int[] rotationDir = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		for (int i = 0; i < 4; i++) {
			String input = br.readLine();
			for (int j = 0; j < 8; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		int k = Integer.parseInt(br.readLine());

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());

			checkDir(num, dir);
			rotateMap();
			Arrays.fill(rotationDir, 0);
		}

		int answer = 0;
		for (int i = 0; i < 4; i++) {
			if (map[i][0] == 1) {
				answer += Math.pow(2, i);
			}
		}

		bw.write(answer + "\n");
		bw.close();
		br.close();
	}

	private static void checkDir(int num, int dir) {
		rotationDir[num] = dir;
		
		for (int i = num; i > 0; i--) {
			if (map[i][6] != map[i - 1][2] && rotationDir[i] != 0) {
				rotationDir[i - 1] = rotationDir[i] * -1;
			}
		}

		for (int i = num; i < 3; i++) {
			if (map[i][2] != map[i + 1][6] && rotationDir[i] != 0) {
				rotationDir[i + 1] = rotationDir[i] * -1;
			}
		}
	}

	private static void rotateMap() {
		int val = 0, dir = 0;

		for (int i = 0; i < 4; i++) {
			dir = rotationDir[i];

			if (dir == 1) {
				val = map[i][7];
				for (int j = 7; j > 0; j--) {
					map[i][j] = map[i][j - 1];
				}
				map[i][0] = val;
			}

			if (dir == -1) {
				val = map[i][0];
				for (int j = 0; j < 7; j++) {
					map[i][j] = map[i][j + 1];
				}
				map[i][7] = val;
			}
		}
	}
}
