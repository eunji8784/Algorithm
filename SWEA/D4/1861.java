import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] dx = {-1, 1, 0, 0}; // 상하좌우
	static int[] dy = {0, 0, -1, 1}; // 상하좌우
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			
			StringTokenizer st;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			int res = 0;
			
			for (int i = 0; i < N; i++) {
				
				int startX = i;
				
				for (int j = 0; j < N; j++) {
					
					int startY = j;
					int idx = 0;
					int count = 1;
					boolean bool = true;
					
					while (true) {
						
						if (idx == 4) {
							if (!bool) break;
							idx = 0;
						}
						
						int x = startX + dx[idx];
						int y = startY + dy[idx];
						
						if (x >= 0 && x < N && y >= 0 && y < N && map[x][y] == map[startX][startY] + 1) {
							startX = x;
							startY = y;
							count++;
							idx = 0;
							bool = true;
						} else {
							idx++;
							bool = false;
						}
						
					}
					
					if (count == max && map[i][j] < res) {
						res = map[i][j];
					} else if (count > max) {
						max = count;
						res = map[i][j];
					}
				
				}
			}
			
			System.out.printf("#%d %d %d\n", tc, res, max);
			
		}
		
	}

}
