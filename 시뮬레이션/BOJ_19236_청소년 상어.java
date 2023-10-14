import java.io.*;
import java.util.*;

public class Main {
	private static final int[] DX = { -1, -1, 0, 1, 1, 1, 0, -1 };
	private static final int[] DY = { 0, -1, -1, -1, 0, 1, 1, 1 };
	
	private static int answer;
	
	private static class Location {
		int x, y, dir;
		
		public Location(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] map = new int[4][4];
		Location[] fishes = new Location[17];

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				fishes[num] = new Location(i, j, dir);
				map[i][j] = num;
			}
		}
		
		answer = -1;
		
		int fishNum = map[0][0];
		int dir = fishes[fishNum].dir;
		fishes[fishNum] = null;
		map[0][0] = -1;
		
		move(new Location(0, 0, dir), fishNum, fishes, map);
		
		System.out.println(answer);
		br.close();
	}

	private static void move(Location sharkLoc, int sum, Location[] originLoc, int[][] originMap) {
		Location[] fishes = new Location[17];
		copyLoc(fishes, originLoc);
		
		int[][] map = new int[4][4];
		copyMap(map, originMap);
		
		// fish move
		boolean isFishExist = false;
		
		for (int num = 1; num <= 16; num++) {
			if (fishes[num] == null) continue;
			
			isFishExist = true;
			int x = fishes[num].x;
			int y = fishes[num].y;
			int dir = fishes[num].dir;
			
			for (int i = 0; i < 8; i++) {
				int nx = x + DX[dir];
				int ny = y + DY[dir];
				
				if (!isIn(nx, ny) || map[nx][ny] == -1) {
					dir = (dir + 1) % 8;
					continue;
				}
				
				if (map[nx][ny] == 0) {
					map[x][y] = 0;
					map[nx][ny] = num;
				} else {
					int fishNum = map[nx][ny]; // 바꿀 물고기 번호 
					map[x][y] = fishNum;
					map[nx][ny] = num;
					fishes[fishNum].x = x;
					fishes[fishNum].y = y;
				}
				
				fishes[num].x = nx;
				fishes[num].y = ny;
				fishes[num].dir = dir;
				
				break;
			}
		}
		
		// 모든 물고기를 잡아 먹었다면 재귀 종료 
		if (!isFishExist) {
			answer = Math.max(answer, sum);
			return;
		}
		
		// shark move
		int sharkX = sharkLoc.x;
		int sharkY = sharkLoc.y;
		int sharkDir = sharkLoc.dir;
		map[sharkX][sharkY] = 0; // 상어 이동 후 빈칸 처리	
		
		while (true) {
			sharkX += DX[sharkDir];
			sharkY += DY[sharkDir];
			
			if (!isIn(sharkX, sharkY)) {
				answer = Math.max(answer, sum);
				return;
			}
			
			if (map[sharkX][sharkY] == 0) continue;
			
			int fishNum = map[sharkX][sharkY]; // 잡아먹히는 물고기 번호  
			int fishDir = fishes[fishNum].dir;
			
			fishes[fishNum] = null;
			map[sharkX][sharkY] = -1; // 상어가 이동한 자리 값 변경 
			
			move(new Location(sharkX, sharkY, fishDir), sum + fishNum, fishes, map);
			
			map[sharkX][sharkY] = fishNum;
			fishes[fishNum] = new Location(sharkX, sharkY, fishDir);
		}
	}
	
	private static void copyLoc(Location[] fishes, Location[] originLoc) {
		for (int i = 1; i <= 16; i++) {
			if (originLoc[i] == null) continue;
			Location loc = originLoc[i];
			fishes[i] = new Location(loc.x, loc.y, loc.dir);
		}	
	}
	
	private static void copyMap(int[][] map, int[][] originMap) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				map[i][j] = originMap[i][j];
			}
		}
	}

	private static boolean isIn(int x, int y) {
		return (x >= 0 && x < 4 && y >= 0 && y < 4);
	}
}
