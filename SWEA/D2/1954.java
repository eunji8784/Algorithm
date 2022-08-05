import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	// 방향: 오른쪽 -> 아래 -> 왼쪽 -> 위
	static int[] dx = { 0, 1, 0, -1 }; 
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int x, y, num;
			x = y = 0;
			num = 1;
			map[x][y] = num;

			while (num < N * N) {
				
				for (int i = 0; i < 4; i++) {
					
					if (num == N * N) break;
					
					while (true) {
						
						if (x + dx[i] < N && x + dx[i] >= 0 && y + dy[i] < N && y + dy[i] >= 0 && map[x + dx[i]][y + dy[i]] == 0) {
							num++;
							x += dx[i];
							y += dy[i];
							map[x][y] = num;
						} else {
							break;
						}
						
					}
					
				}
				
			}
			
			StringBuilder sb = new StringBuilder();
			
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.print(sb);

		}
	}

}
