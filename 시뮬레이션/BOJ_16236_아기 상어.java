import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int[] DX = { -1, 1, 0, 0 };
	private static final int[] DY = { 0, 0, -1, 1 };

	private static int n;
	private static int[][] map;
	private static Location babySharkLoc;
	private static SharkGrow babyShark;

	private static class Location {
		int x, y, time;

		public Location(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	private static class SharkGrow {
		int size, fishCount;

		public SharkGrow(int size, int fishCount) {
			this.size = size;
			this.fishCount = fishCount;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		babySharkLoc = null;
		babyShark = new SharkGrow(2, 0);
		int answer = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 9) {
					babySharkLoc = new Location(i, j, 0);
					num = 0;
				}
				map[i][j] = num;
			}
		}

		while (true) {
			int time = sharkMove();
			if (time == -1) {
				break;
			} else {
				answer += time;
			}
		}

		bw.write(String.valueOf(answer));
		bw.close();
		br.close();
	}

	private static int sharkMove() {
		Queue<Location> que = new LinkedList<>();
		PriorityQueue<Location> pq = new PriorityQueue<>(new Comparator<Location>() {
			@Override
			public int compare(Location o1, Location o2) {
				if (o1.x == o2.x) {
					return o1.y - o2.y;
				}
				return o1.x - o2.x;
			}
		});
		boolean[][] vst = new boolean[n][n];

		que.offer(babySharkLoc);
		vst[babySharkLoc.x][babySharkLoc.y] = true;

		int babySharkSize = babyShark.size;

		while (!que.isEmpty()) {
			int length = que.size();

			while (length-- > 0) {
				pq.offer(que.poll());
			}

			while (!pq.isEmpty()) {
				Location cur = pq.poll();
				int x = cur.x;
				int y = cur.y;
				int time = cur.time;

				// 물고기를 먹는 경우
				if (0 < map[x][y] && map[x][y] < babySharkSize) {
					if (babyShark.fishCount + 1 == babySharkSize) {
						babyShark.size++;
						babyShark.fishCount = 0;
					} else {
						babyShark.fishCount++;
					}
					map[x][y] = 0;
					babySharkLoc.x = x;
					babySharkLoc.y = y;
					return time;
				}

				for (int i = 0; i < 4; i++) {
					int nx = x + DX[i];
					int ny = y + DY[i];

					if (nx < 0 || nx >= n || ny < 0 || ny >= n || vst[nx][ny] || map[nx][ny] > babySharkSize) {
						continue;
					}

					if (map[nx][ny] <= babySharkSize) {
						que.offer(new Location(nx, ny, time + 1));
						vst[nx][ny] = true;
					}
				}
			}
		}

		return -1;
	}
}
