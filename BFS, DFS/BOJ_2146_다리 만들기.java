import java.io.*;
import java.util.*;

public class Main {

	private static final int[] DX = { -1, 1, 0, 0 };
	private static final int[] DY = { 0, 0, -1, 1 };
	
	private static int N, min;
	private static int[][] map;
	
	private static class Location {
		int x, y, depth;
		
		public Location(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solution();
		System.out.println(min);
		br.close();
	}

	private static void solution() {
		int count = 2;
		boolean[][] vst = new boolean[N][N];
		Queue<Location> seaLocs = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (vst[i][j] || map[i][j] == 0) continue;	
				seperateBFS(i, j, vst, count, seaLocs);
				while (!seaLocs.isEmpty()) {
					min = Math.min(min, findBridge(seaLocs.poll(), count));
				}
				count++;
			}
		}
		
	}

	private static int findBridge(Location startLoc, int myCount) {
		boolean[][] vst = new boolean[N][N];
		Queue<Location> que = new LinkedList<>();
		que.offer(new Location(startLoc.x, startLoc.y, 1));
		vst[startLoc.x][startLoc.y] = true;
		
		int dist = 0;
		
		while (!que.isEmpty()) {
			Location current = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = current.x + DX[i];
				int ny = current.y + DY[i];
				
				if (current.depth >= min) {
					return current.depth;
				} else {
					dist = current.depth;
				}
				
				if (!isInArea(nx, ny) || map[nx][ny] == myCount || vst[nx][ny]) {
					continue;
				}
				
				if (map[nx][ny] == 0) {
					vst[nx][ny] = true;
					que.offer(new Location(nx, ny, current.depth + 1));
					continue;
				}
				
				if (map[nx][ny] != myCount) {
					return dist;
				}
			}
		}
		
		return dist;
	}

	private static void seperateBFS(int startX, int startY, boolean[][] vst, int count, Queue<Location> seaLocs) {
		Queue<Location> que = new LinkedList<>();
		que.offer(new Location(startX, startY, 0));
    vst[startX][startY] = true;
    map[startX][startY] = count;
		
		while (!que.isEmpty()) {
			Location current = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = current.x + DX[i];
				int ny = current.y + DY[i];
				
				if (!isInArea(nx, ny) || vst[nx][ny]) {
					continue;
				}
				
				vst[nx][ny] = true;
				
				if (map[nx][ny] == 1) {
					que.offer(new Location(nx, ny, 0));
					map[nx][ny] = count;
				}
				
				if (map[nx][ny] == 0) {
					seaLocs.offer(new Location(nx, ny, 1));
				}
			}
		}
	}
	
	private static boolean isInArea(int nx, int ny) {
		return nx >= 0 && nx < N && ny >= 0 && ny < N;
	}

}
