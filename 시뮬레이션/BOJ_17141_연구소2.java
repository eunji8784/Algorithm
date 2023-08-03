import java.io.*;
import java.util.*;

/*
 * 1. 초기 입력에서 0은 빈 칸, 1은 벽, 2는 바이러스를 놓을 수 있는 칸  
 * 2. 실행 후 벽은 -, 바이러스를 놓은 위치는 0, 빈 칸은 바이러스가 퍼지는 시간 
 * 모든 빈 칸에 바이러스를 퍼뜨리는 [최소 시간]을 구하는 문제
 */
public class Main {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M, blankCount = 0, min;
	static int[][] map;
	static ArrayList<Location> candidateVirusLoc;
	static Location[] selectedVirusLoc;

	static class Location {
		int x, y, time;

		public Location(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		candidateVirusLoc = new ArrayList<>();
		selectedVirusLoc = new Location[M];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					candidateVirusLoc.add(new Location(i, j, 0)); // 바이러스를 놓을 수 있는 후보 칸들을 모두 저장한다.
				} else if (map[i][j] == 0) {
					blankCount++; // 빈 칸의 개수를 센다.
				} else if (map[i][j] == 1) {
					map[i][j] = -1; // 벽이 있는 칸은 -1로 바꾼다.
				}
			}
		}

		min = Integer.MAX_VALUE;

		combination(0, 0); // 후보 바이러스 칸들 중에서 M개를 뽑는 조합을 구한다.

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
		br.close();

	}

	private static void combination(int index, int count) {

		if (count == M) {
			min = Math.min(min, bfs(selectedVirusLoc));
			return;
		}

		for (int i = index; i < candidateVirusLoc.size(); i++) {
			selectedVirusLoc[count] = candidateVirusLoc.get(i);
			combination(i + 1, count + 1);
		}

	}

	private static void copyMap(int[][] backup, int[][] map) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				backup[i][j] = map[i][j];
			}
		}

	}

	private static int bfs(Location[] selectedVirusLoc) {

		int[][] backup = new int[N][N];
		copyMap(backup, map);

		// 바이러스 놓일 칸을 -1로 바꾸기 
		for (Location loc : selectedVirusLoc) {
			backup[loc.x][loc.y] = -1;
		}
		
		// 선택되지 않은 나머지 바이러스 칸은 0으로 초기화 
		for (Location loc : candidateVirusLoc) {
			if (backup[loc.x][loc.y] == 2) {
				backup[loc.x][loc.y] = 0;
			}
		}

		int timeToVirusSpread = 0;
		int blank = blankCount + (candidateVirusLoc.size() - M);
		Queue<Location> que = new LinkedList<>(Arrays.asList(selectedVirusLoc));

		while (!que.isEmpty()) {
			Location current = que.poll();
			int x = current.x;
			int y = current.y;
			int time = current.time;

			// 걸린 시간이 이미 최소값을 넘겼다면
			if (time >= min) {
				return time;
			} else {
				timeToVirusSpread = time;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}

				if (backup[nx][ny] == 0) {
					backup[nx][ny] = time + 1;
					blank--;
					que.offer(new Location(nx, ny, time + 1));
				}
			}
		}

		if (blank == 0) { // 바이러스를 모든 칸에 퍼트렸다면
			return timeToVirusSpread;
		} else {
			return Integer.MAX_VALUE;
		}
	}

}
