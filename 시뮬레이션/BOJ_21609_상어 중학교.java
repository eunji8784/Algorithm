import java.io.*;
import java.util.*;

public class Main {
	private static final int[] DX = { -1, 1, 0, 0 };
	private static final int[] DY = { 0, 0, -1, 1 };

	private static int N, score;
	private static int[][] map;
	private static Queue<int[]> que = new LinkedList<>();
	private static boolean[][] vst = new boolean[N][N];
	
	private static class BlockGroup {
		int x, y, size, rainbowCount;
		
		public BlockGroup(int x, int y, int size, int rainbowCount) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.rainbowCount = rainbowCount;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Integer.parseInt(st.nextToken());
		map = new int[N][N];
		score = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (true) {
			if (!findAndRemoveLargeGroup()) {
				break;
			}
			applyGravity();
			rotateMap();
			applyGravity();
		}
		
		bw.write(String.valueOf(score));
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void rotateMap() {
		int[][] copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[N - 1 - j][i] = map[i][j];
			}
		}
		map = copy;
	}

	private static void applyGravity() {
		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] < 0) continue;
				int x = i;
				boolean flag = false;
				while (x < N - 1 && map[x + 1][j] == -4) {
					flag = true;
					x++;
				}
				if (flag) {
					map[x][j] = map[i][j];
					map[i][j] = -4;
				}
			}
		}	
	}

	private static boolean findAndRemoveLargeGroup() {
		BlockGroup largeGroup = null;
		vst = new boolean[N][N];

		for (int i = 0; i < N; i++) { // 가장 큰 블록 그룹 찾기
			for (int j = 0; j < N; j++) {
				if (map[i][j] <= 0 || vst[i][j]) continue;
				
				BlockGroup group = findBfs(i, j, map[i][j]);

				if (group.size >= 2) { // 그룹에 속한 블록의 개수는 2보다 크거나 같아야 한다.
					if (largeGroup == null || (group.size >= largeGroup.size && (group.size > largeGroup.size || group.rainbowCount >= largeGroup.rainbowCount))) {
						largeGroup = group;
					} 
				}
			}
		}
		
		if (largeGroup != null) { // 블록 그룹 제거
			score += (largeGroup.size * largeGroup.size);
			removeBfs(largeGroup.x, largeGroup.y, map[largeGroup.x][largeGroup.y]);
			return true;
		}

		return false;
	}

	private static void removeBfs(int x, int y, int num) {
		que = new LinkedList<>();
		vst = new boolean[N][N];
		que.offer(new int[] {x, y});
		vst[x][y] = true;
		map[x][y] = -4;
		
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + DX[d];
				int ny = cur[1] + DY[d];

				if (isIn(nx, ny) && !vst[nx][ny] && (map[nx][ny] == num || map[nx][ny] == 0)) {
					map[nx][ny] = -4;
					que.offer(new int[] {nx, ny});
					vst[nx][ny] = true;
				}
			}
		}
	}

	private static BlockGroup findBfs(int i, int j, int num) {
		que = new LinkedList<>();
		vst[i][j] = true;
		que.offer(new int[] {i, j});
		int total = 1, rainbowCount = 0;
		List<int[]> rainbows = new ArrayList<>();

		while (!que.isEmpty()) {
			int[] cur = que.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + DX[d];
				int ny = cur[1] + DY[d];

				if (isIn(nx, ny) && !vst[nx][ny] && (map[nx][ny] == num || map[nx][ny] == 0)) {
					if (map[nx][ny] == 0) {
						rainbowCount++;
						rainbows.add(new int[] {nx, ny});
					}
					total++;
					vst[nx][ny] = true;
					que.offer(new int[] {nx, ny});
				}
			}
		}
		
		for (int[] loc : rainbows) {
			vst[loc[0]][loc[1]] = false;
		}

		return new BlockGroup(i, j, total, rainbowCount);
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
