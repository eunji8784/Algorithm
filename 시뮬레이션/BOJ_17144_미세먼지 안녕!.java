import java.io.*;
import java.util.*;

public class Main {
	private static final int[] DX = {0, -1, 0 ,1};
	private static final int[] DY = {1, 0, -1 ,0};
	
	private static int R, C, T;
	private static int[][] room, airLoc;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		room = new int[R][C];
		airLoc = new int[2][2];
		
		int idx = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if (room[i][j] == -1) {
					airLoc[idx][0] = i;
					airLoc[idx++][1] = j;
				}
			}
		}
		
		for (int i = 0; i < T; i++) {
			dustSpread();
			airSpread();
		}
		
		System.out.println(count());
		br.close();
	}
	
	private static void dustSpread() {
		int[][] backup = copy();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (backup[i][j] > 0) {
					int dustAmount = backup[i][j];
					int spreadAmount = dustAmount / 5;
					if (spreadAmount == 0) continue;
					int count = 0;
					
					for (int dir = 0; dir < 4; dir++) {
						int nx = i + DX[dir];
						int ny = j + DY[dir];
						
						if (!isIn(nx, ny) || room[nx][ny] == -1) continue;
						
						room[nx][ny] += spreadAmount;
						count++;
					}
					
					room[i][j] -= (spreadAmount * count);
				}
			}
		}
	}
	
	private static void airSpread() {
		for (int i = 0; i < 2; i++) {
			int x = airLoc[i][0];
			int y = airLoc[i][1];
			int dir = 0;
			int next = 0;
			
			while (true) {
				int nx = (i == 0 ? x + DX[dir] : x - DX[dir]);
				int ny = y + DY[dir];
					
				if (!isIn(nx, ny)) {
					dir++;
					continue;
				}
				
				if (room[nx][ny] == -1) break;
				
				if (room[nx][ny] > 0 || next > 0) {
					int amount = room[nx][ny];
					room[nx][ny] = next;
					next = amount;
				}
				
				x = nx;
				y = ny;
			}
		}	
	}
	
	private static int count() {
		int answer = 0;	
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] > 0) {
					answer += room[i][j];
				}
			}
		}
		return answer;
	}
	
	private static boolean isIn(int x, int y) {
		return (x >= 0 && x < R && y >= 0 && y < C);
	}
	
	private static int[][] copy() {
		int[][] backup = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				backup[i][j] = room[i][j];
			}
		}
		return backup;
	}
}
