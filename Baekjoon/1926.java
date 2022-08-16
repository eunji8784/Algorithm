import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0}; // 상하좌우
	static int[] dy = {0, 0, -1, 1}; // 상하좌우
	static int width;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		int count = 0;
		int maxWidth = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}	
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 & visited[i][j] == false) {
					count++;
					width = 1;
					dfs(i, j);
					
					if (width > maxWidth) {
						maxWidth = width;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(count).append("\n").append(maxWidth);
		System.out.println(sb.toString());
		
	}

	private static void dfs(int x, int y) {
		
		visited[x][y] = true;
		
		int idx = 0;
		int nx = x;
		int ny = y;
		
		while (idx < 4) {
			
			nx = x + dx[idx];
			ny = y + dy[idx];
			
			if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1 && visited[nx][ny] == false) {
				width++;
				dfs(nx, ny);
			} else {
				idx++;
			}
			
		}
		
	}

}
