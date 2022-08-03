import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char map[][] = new char[H][W];
			int x, y, dir, k;
			x = y = dir = 0;

			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						x = i;
						y = j;
						
						switch (map[i][j]) {
						case '^':
							dir = 1;
							break;
						case 'v':
							dir = 2;
							break;
						case '<':
							dir = 3;
							break;
						case '>':
							dir = 4;
							break;
						}
					}
				}
			}

			int N = Integer.parseInt(br.readLine());
			char inputs[] = new char[N];
			inputs = br.readLine().toCharArray();

			for (char input : inputs) {
				k = 1;
				switch (input) {
				case 'U':
					map[x][y] = '^';
					dir = 1;
					if (x > 0 && map[x - 1][y] == '.') {
						map[x - 1][y] = map[x][y];
						map[x][y] = '.';
						x--;
					}
					break;
				case 'D':
					map[x][y] = 'v';
					dir = 2;
					if (x + 1 < H && map[x + 1][y] == '.') {
						map[x + 1][y] = map[x][y];
						map[x][y] = '.';
						x++;
					}
					break;
				case 'L':
					map[x][y] = '<';
					dir = 3;
					if (y > 0 && map[x][y - 1] == '.') {
						map[x][y - 1] = map[x][y];
						map[x][y] = '.';
						y--;
					}
					break;
				case 'R':
					map[x][y] = '>';
					dir = 4;
					if (y + 1 < W && map[x][y + 1] == '.') {
						map[x][y + 1] = map[x][y];
						map[x][y] = '.';
						y++;
					}
					break;
				case 'S':
					switch (dir) {
					case 1: // 상
						while (true) {
							if (x - k < 0 || map[x - k][y] == '#')
								break;
							if (map[x - k][y] == '*') {
								map[x - k][y] = '.';
								break;
							}
							k++;
						}
						break;
					case 2: // 하
						while (true) {
							if (x + k >= H || map[x + k][y] == '#')
								break;
							if (map[x + k][y] == '*') {
								map[x + k][y] = '.';
								break;
							}
							k++;
						}
						break;
					case 3: // 좌
						while (true) {
							if (y - k < 0 || map[x][y - k] == '#')
								break;
							if (map[x][y - k] == '*') {
								map[x][y - k] = '.';
								break;
							}
							k++;
						}
						break;
					case 4: // 우
						while (true) {
							if (y + k >= W || map[x][y + k] == '#')
								break;
							if (map[x][y + k] == '*') {
								map[x][y + k] = '.';
								break;
							}
							k++;
						}
						break;
					}
					break;
				}
			}

			System.out.printf("#%d ", tc);
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

}
