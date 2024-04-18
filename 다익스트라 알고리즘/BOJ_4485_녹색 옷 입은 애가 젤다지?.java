import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static final int[][] DIR = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	private static int n;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int caseNum = 1;

		while (true) {
			n = Integer.parseInt(br.readLine());

			if (n == 0) {
				break;
			}

			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bw.write("Problem " + caseNum++ + ": " + dijkstra() + "\n");
		}

		bw.close();
		br.close();
	}

	private static class Location implements Comparable<Location> {
		int x, y, cost;

		public Location(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Location loc) {
			return this.cost - loc.cost;
		}
	}

	private static int dijkstra() {
		PriorityQueue<Location> pq = new PriorityQueue<>();
		int[][] dist = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		pq.offer(new Location(0, 0, map[0][0]));
		dist[0][0] = map[0][0];

		while (!pq.isEmpty()) {
			Location loc = pq.poll();

			if (loc.x == n - 1 && loc.y == n - 1) {
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = loc.x + DIR[i][0];
				int ny = loc.y + DIR[i][1];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
					continue;
				}

				if (loc.cost + map[nx][ny] >= dist[nx][ny]) {
					continue;
				}

				dist[nx][ny] = loc.cost + map[nx][ny];
				pq.offer(new Location(nx, ny, dist[nx][ny]));
			}
		}

		return dist[n - 1][n - 1];
	}

}
