import java.io.*;
import java.util.*;

public class Main {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M, max, blankCnt;
	static int[][] map;
	static Location[] selectedLoc; // 벽을 세울 칸의 위치
	static ArrayList<Location> blankLoc; // 빈 칸(0)의 위치
	static Queue<Location> virusLoc; // 바이러스가 존재하는 칸(2)의 위치

	static class Location {
		int x, y;

		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		selectedLoc = new Location[3];
		blankLoc = new ArrayList<>();
		virusLoc = new LinkedList<>();
		max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					blankCnt++; // 빈 칸의 수를 센다.
					blankLoc.add(new Location(i, j));
				}
				if (map[i][j] == 2) {
					virusLoc.offer(new Location(i, j));
				}
			}
		}

		combination(0, 0);

		System.out.println(max);
		br.close();
	}

	private static void combination(int index, int count) {

		if (count == 3) {
			max = Math.max(max, bfs(selectedLoc));
			return;
		}

		for (int i = index; i < blankLoc.size(); i++) {
			selectedLoc[count] = blankLoc.get(i);
			combination(i + 1, count + 1);
		}

	}

	private static void copyMap(int[][] backup, int[][] map) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				backup[i][j] = map[i][j];
			}
		}

	}

	private static int bfs(Location[] selected) {

		int[][] backup = new int[N][M];
		copyMap(backup, map); // map의 복사본 생성

		int safeZone = blankCnt; // 안전 영역 크기

		// 선택된 3개의 위치에 벽 세우기
		for (Location loc : selected) {
			backup[loc.x][loc.y] = 1;
			safeZone--; // 벽을 세웠으므로 안전 영역의 크기를 1 줄인다.
		}

		Queue<Location> que = new LinkedList<>(virusLoc); // 바이러스 위치 복사

		while (!que.isEmpty()) {

			Location virus = que.poll();
			int x = virus.x;
			int y = virus.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}

				if (backup[nx][ny] == 0) {
					safeZone--;
					backup[nx][ny] = 2;
					que.offer(new Location(nx, ny));
				}
			}

		}

		return safeZone;

	}

}
