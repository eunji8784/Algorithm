import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, count;
	static int[][] map;
	static boolean[][] vst;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		vst = new boolean[N][N];
		int total = 0;
		ArrayList<Integer> res = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			char[] tmp = str.toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = Character.getNumericValue(tmp[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!vst[i][j] && map[i][j] == 1) {
					total++;
					count = 0;
					bfs(new Location(i, j));
					res.add(count);
				}
			}
		}
		Collections.sort(res);
		System.out.println(total);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}

	}

	private static void bfs(Location location) {
		Queue<Location> que = new LinkedList<>();
		que.add(location);
		vst[location.x][location.y] = true;
		map[location.x][location.y] = 2;

		while (!que.isEmpty()) {
			Location current = que.poll();
			count++;
			int x = current.x;
			int y = current.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < N && !vst[nx][ny] && map[nx][ny] == 1) {
					vst[nx][ny] = true;
					map[nx][ny] = 2;
					que.add(new Location(nx, ny));
				}
			}
		}

	}

	static class Location {
		int x;
		int y;

		public Location(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
