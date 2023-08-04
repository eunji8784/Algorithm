import java.io.*;
import java.util.*;

public class Main {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M, blankCount = 0, min = Integer.MAX_VALUE;
	static int[][] map;
	static ArrayList<Location> candidateVirusLoc = new ArrayList<>();
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
		selectedVirusLoc = new Location[M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = (num == 1 ? -1 : num);
				if (num == 2) {
					candidateVirusLoc.add(new Location(i, j, 0));
				} else if (num == 0) {
					blankCount++;
				}
			}
		}

		combination(0, 0);

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
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

		for (Location loc : selectedVirusLoc) {
			backup[loc.x][loc.y] = -1;
		}

		for (Location loc : candidateVirusLoc) {
			if (backup[loc.x][loc.y] == 2) {
				backup[loc.x][loc.y] = -2;
			}
		}

		Queue<Location> que = new LinkedList<>(Arrays.asList(selectedVirusLoc));
		int blank = blankCount;
		int timeToVirusSpread = 0;

		while (!que.isEmpty()) {
			Location current = que.poll();
			int x = current.x;
			int y = current.y;
			int time = current.time;

			if (time >= min) {
				return time;
			} else {
				timeToVirusSpread = time;
			}
			
			if (blank == 0) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N || backup[nx][ny] > 0 || backup[nx][ny] == -1) {
					continue;
				}

				if (backup[nx][ny] == 0) {
					blank--;
				}

				backup[nx][ny] = time + 1;
				que.offer(new Location(nx, ny, time + 1));
			}
		}

		return (blank == 0 ? timeToVirusSpread : Integer.MAX_VALUE);

	}

}
