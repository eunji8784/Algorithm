import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int R, C, max;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[26];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}
		
		max = 0;
		dfs(new Location(0, 0, 0));
		
		System.out.println(max + 1);

	}

	private static void dfs(Location location) {
		
		int x = location.x;
		int y = location.y;
		int depth = location.depth;
		
		visited[map[x][y]] = true;
		
		if (depth > max) {
			max = depth;
		}
		
		for (int idx = 0; idx < 4; idx++) {
			int nx = x + dx[idx];
			int ny = y + dy[idx];
			
			if (0 <= nx && nx < R && 0 <= ny && ny < C && !visited[map[nx][ny]]) {
				dfs(new Location(nx, ny, depth + 1));
				visited[map[nx][ny]] = false;
			}
		}
		
	}
	
	static class Location {
		int x, y, depth;

		public Location(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
		
	}

}
