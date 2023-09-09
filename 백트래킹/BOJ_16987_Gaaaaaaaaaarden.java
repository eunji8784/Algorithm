import java.io.*;
import java.util.*;

public class Main {

	private static final int[] DX = { -1, 1, 0, 0 };
	private static final int[] DY = { 0, 0, -1, 1 };

	private static int N, M, G, R, max = -1;
	private static int[][] garden;
	private static ArrayList<Location> possible = new ArrayList<>();

	private static class Location {
		int x, y, time, type;

		public Location(int x, int y, int time, int type) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.type = type;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		garden = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				garden[i][j] = Integer.parseInt(st.nextToken());
				if (garden[i][j] == 2) {
					possible.add(new Location(i, j, 0, 0));
				}
			}
		}

		comb(0, 0, 0);

		System.out.println(max);
		br.close();
	}

	private static void comb(int index, int green, int red) {
		if (green == G && red == R) {
			max = Math.max(max, bfs());
			return;
		}

		if (index == possible.size()) return;

		Location cur = possible.get(index);

		// 초록 물약 부어보기
		if (green < G) {
			garden[cur.x][cur.y] = 3;
			comb(index + 1, green + 1, red);
			garden[cur.x][cur.y] = 2; // 복원 
		}

		// 빨간 물약 부어보기
		if (red < R) {
			garden[cur.x][cur.y] = 4;
			comb(index + 1, green, red + 1);
			garden[cur.x][cur.y] = 2; // 복원 
		}

		// 물약 안부어보기
		comb(index + 1, green, red);
	}

	private static int bfs() {
		Queue<Location> que = new LinkedList<>();
		int[][] typeCheck = new int[N][M];
		int[][] timeCheck = new int[N][M];
		int flowers = 0;
		
		for (Location loc : possible) {
			if (garden[loc.x][loc.y] == 3 || garden[loc.x][loc.y] == 4) {
				typeCheck[loc.x][loc.y] = garden[loc.x][loc.y];
				que.offer(new Location(loc.x, loc.y, 0, garden[loc.x][loc.y]));
			}
		}

		while (!que.isEmpty()) {
			Location cur = que.poll();
			
			if (typeCheck[cur.x][cur.y] == 8) continue;
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + DX[i];
				int ny = cur.y + DY[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				
				// 인접한 칸이 호수거나 꽃일 경우 
				if (garden[nx][ny] == 0 || typeCheck[nx][ny] == 8) {
					continue;
				}
				
				// 인접한 칸이 비어있는 땅일 경우 
				if (typeCheck[nx][ny] == 0) {
					typeCheck[nx][ny] = cur.type;
					timeCheck[nx][ny] = cur.time + 1;
					que.offer(new Location(nx, ny, cur.time + 1, cur.type));
					continue;
				}
				
				// 다른 색의 배양액을 만났을 경우 
				if (typeCheck[nx][ny] != cur.type && cur.time + 1 == timeCheck[nx][ny]) {
					flowers++;
					typeCheck[nx][ny] = 8;
				}
			}
		}

		return flowers;
	}

}
