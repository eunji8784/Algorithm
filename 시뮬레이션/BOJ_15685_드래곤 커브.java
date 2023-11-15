import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[101][101];
		
		final int[] DX = {1, 0, -1, 0};
		final int[] DY = {0, -1, 0, 1};
		
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			List<Integer> directions = new ArrayList<>();
			
			map[x][y] = true;
			x += DX[d];
			y += DY[d];
			map[x][y] = true;
			directions.add(d);
			
			for (int i = 0; i < g; i++) {
				for (int j = directions.size() - 1; j >= 0; j--) {
					int dir = (directions.get(j) + 1) % 4;
					x += DX[dir];
					y += DY[dir];
					map[x][y] = true;
					directions.add(dir);
				}
			}
		}
		
		int answer = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
					answer++;
				}
			}
		}
		
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		br.close();
	}
}
