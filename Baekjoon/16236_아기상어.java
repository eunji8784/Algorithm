import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	// 상 좌 우 하
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static int N, sharkSize, time, eat;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		sharkSize = 2;
		time = 0;
		eat = 0;
		Location sharkLoc = null;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					sharkLoc = new Location(i, j, 0);
				}
			}
		}
		bfs(sharkLoc);
		System.out.println(time);
	}

	private static void bfs(Location sharkLoc) {

		boolean[][] vst = new boolean[N][N];
		ArrayList<Integer> fishX = new ArrayList<>();
		ArrayList<Integer> fishY = new ArrayList<>();
		Queue<Location> que = new LinkedList<>();
		que.add(sharkLoc);
		vst[sharkLoc.x][sharkLoc.y] = true;

		while (true) {
			int length = que.size();
			for (int l = 0; l < length; l++) {
				Location current = que.poll();
				int x = current.x;
				int y = current.y;
				int depth = current.depth;
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (0 <= nx && nx < N && 0 <= ny && ny < N && !vst[nx][ny]) {
						if (map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
							fishX.add(nx);
							fishY.add(ny);
						}
						if (map[nx][ny] <= sharkSize) {
							que.add(new Location(nx, ny, depth + 1));
							vst[nx][ny] = true;
						}
					}
				}
			}
			if (que.isEmpty()) {
				return;
			}
			int size = fishX.size();
			if (size > 0) {
				int[][] arr = new int[size][2];
				for (int i = 0; i < size; i++) {
					arr[i][0] = fishX.get(i);
					arr[i][1] = fishY.get(i);
				}
				Arrays.sort(arr, new Comparator<int[]>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						if (o1[0] == o2[0]) {
							return o1[1] - o2[1];
						} else {
							return o1[0] - o2[0];
						}
					}
				});
				int sharkX = arr[0][0];
				int sharkY = arr[0][1];

				map[sharkLoc.x][sharkLoc.y] = 0;
				map[sharkX][sharkY] = 9;
				time += que.peek().depth;
				sharkGrow();
				bfs(new Location(sharkX, sharkY, 0));
				return;
			}
		}

	}

	private static void sharkGrow() {

		eat++;
		if (eat == sharkSize) {
			sharkSize++;
			eat = 0;
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
