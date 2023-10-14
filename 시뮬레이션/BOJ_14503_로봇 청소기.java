import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] room = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(solve(x, y, d, room));
		br.close();
	}
	
	private static int solve(int x, int y, int d, int[][] room) {
		int[] DX = {-1, 0, 1, 0};
		int[] DY = {0, 1, 0, -1};
		int count = 0;
		
		while (true) {
			if (room[x][y] == 0) {
				count++;
				room[x][y] = 2;
			}
			
			boolean canClean = false;
			int dir = d;
			for (int i = 0; i < 4; i++) {
				int nx = x + DX[dir % 4];
				int ny = y + DY[dir % 4];
				
				if (room[nx][ny] == 0) {
					canClean = true;
					break;
				}
				
				dir++;
			}
			
			if (!canClean) { // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
				int backDir = (d + 2) % 4;
				x += DX[backDir];
				y += DY[backDir];
				if (room[x][y] == 1) break;
			} else { // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우 
				d = (d + 3) % 4;
				int nx = x + DX[d];
				int ny = y + DY[d];
				if (room[nx][ny] == 0) {
					x = nx;
					y = ny;
				}
			}
		}
		
		return count;
	}
}
