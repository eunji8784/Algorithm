import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static final int[][] DIR = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	private static int r, c, max = -1;
	private static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		boolean[] check = new boolean[26];
		check[map[0][0] - 'A'] = true;
		
		dfs(0, 0, check, 1);

		bw.write(max + "\n");
		bw.close();
		br.close();
	}

	private static void dfs(int x, int y, boolean[] check, int depth) {		
		for (int i = 0; i < 4; i++) {
			int nx = x + DIR[i][0];
			int ny = y + DIR[i][1];
			
			if (nx < 0 || nx >= r || ny < 0 || ny >= c || check[map[nx][ny] - 'A']) {
				continue;
			}
			
			check[map[nx][ny] - 'A'] = true;
			dfs(nx, ny, check, depth + 1);
			check[map[nx][ny] - 'A'] = false;
		}
		
		max = Math.max(max, depth);
	}
}
