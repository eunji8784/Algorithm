import java.io.*;
import java.util.*;

public class Main {

	private static final int[] DX = { -1, 1, 0, 0, 0, 0 };
	private static final int[] DY = { 0, 0, -1, 1, 0, 0 };
	private static final int[] DZ = { 0, 0, 0, 0, -1, 1 };
	
	private static int L, R, C, endX, endY, endZ;
	private static char[][][] map;
	
	private static class Location {
		int z, x, y, time;
		
		public Location(int z, int x, int y, int time) {
			this.z = z;
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if (L == 0 && R == 0 && C == 0) break;
			map = new char[L][R][C];
			Location start = null, end = null;
			
			for (int l = 0; l < L; l++) {
				for (int r = 0; r < R; r++) {
					map[l][r] = br.readLine().toCharArray();
					for  (int c = 0; c < C; c++) {
						if (map[l][r][c] == 'S') {
							start = new Location(l, r, c, 0);
						} else if (map[l][r][c] == 'E') {
							end = new Location(l, r, c, 0);
						}
					}
				}
				br.readLine();
			}
			
			int result = bfs(start, end);
			
			if (result != -1) {
				sb.append("Escaped in ").append(result).append(" minute(s).\n");
			} else {
				sb.append("Trapped!\n");
			}
			
		}
		
		System.out.print(sb.toString());
		br.close();
	}

	private static int bfs(Location start, Location end) {
		Queue<Location> que = new LinkedList<>();
		boolean[][][] vst = new boolean[L][R][C];
		
		que.offer(start);
		vst[start.z][start.x][start.y] = true;
		
		while (!que.isEmpty()) {
			Location current = que.poll();
			
			for (int i = 0; i < 6; i++) {
				int nz = current.z + DZ[i];
				int nx = current.x + DX[i];
				int ny = current.y + DY[i];
				
				if (nx < 0 || nx >= R || ny < 0 || ny >= C || nz < 0 || nz >= L || vst[nz][nx][ny]) {
					continue;
				}
				
				if (nz == end.z && nx == end.x && ny == end.y) {
					return current.time + 1;
				}
				
				if (map[nz][nx][ny] == '.') {
					vst[nz][nx][ny] = true;
					que.offer(new Location(nz, nx, ny, current.time + 1));
				}
			}
		}
		
		return -1;
	}

}
