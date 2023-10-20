import java.io.*;
import java.util.*;

public class Main {
	private static final int[][] FishDir = { { 0, 0 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 },
			{ 1, 0 }, { 1, -1 } };
	private static final int[][] SharkDir = { { 0, 0 }, { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	private static int sharkX, sharkY, index = 0;
	private static List<Integer>[][] map;
	private static List<Integer>[][] move;
	private static int[][] smell = new int[4][4];
	private static int[][] sharkMove = new int[64][3];
	
	private static class CopyFish {
		int x, y, dir;
		
		public CopyFish(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		map = new ArrayList[4][4];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[x - 1][y - 1].add(d);
		}
		
		st = new StringTokenizer(br.readLine());
		sharkX = Integer.parseInt(st.nextToken()) - 1;
		sharkY = Integer.parseInt(st.nextToken()) - 1;
		
		// 상어 이동 방법 초기화
		setSharkMove(0, new int[3]);
		
		for (int s = 1; s <= S; s++) {
			// 물고기 복제 리스트 생성
			List<CopyFish> copyList = copy();
			// 물고기 이동
			fishMove(s);
			// 상어 이동
			sharkMove(s);
			// 복제 마법 완료 
			for (CopyFish c : copyList) {
				map[c.x][c.y].add(c.dir);
			}
		}
		
		int answer = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				answer += map[i][j].size();
			}
		}
		
		System.out.println(answer);
		br.close();
	}
	
	private static List<CopyFish> copy() {
		List<CopyFish> copy = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (map[i][j].size() != 0) {
					for (int dir : map[i][j]) {
						copy.add(new CopyFish(i, j, dir));
					}
				}
			}
		}
		return copy;
	}
	
	private static void fishMove(int s) {
		move = new ArrayList[4][4];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				move[i][j] = new ArrayList<>();
			}
		}
		
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				if (map[x][y].size() == 0) continue;
				
				for (int i = 0; i < map[x][y].size(); i++) {
					int dir = map[x][y].get(i);
					int moveX = x, moveY = y;
					
					for (int cnt = 0; cnt < 8; cnt++) {
						int nx = x + FishDir[dir][0];
						int ny = y + FishDir[dir][1];
						
						if (!isIn(nx, ny) || (nx == sharkX && ny == sharkY) || (smell[nx][ny] > 0 && smell[nx][ny] >= s - 2)) {
							dir = (dir == 1 ? 8 : dir - 1);
							continue;
						}
						
						moveX = nx;
						moveY = ny;
						break;
					}
					
					move[moveX][moveY].add(dir);
				}
			}
		}
		
		map = move;
	}
	
	private static void sharkMove(int s) {
		int max = -1;
		int[] selected = new int[3];
		
		// 상어가 이동할 경로 찾기 
		for (int[] move : sharkMove) {
			int fishCnt = 0;
			boolean possible = true;
			int nx = sharkX, ny = sharkY;
			boolean[][] vst = new boolean[4][4];
			
			for (int i = 0; i < 3; i++) {
				nx += SharkDir[move[i]][0];
				ny += SharkDir[move[i]][1];
				
				if (!isIn(nx, ny)) {
					possible = false;
					break;
				}
				
				if (!vst[nx][ny]) {
					fishCnt += map[nx][ny].size();
					vst[nx][ny] = true;
				}
			}
			
			if (possible && (fishCnt > max)) {
				max = fishCnt;
				selected = Arrays.copyOf(move, 3);
			}
		}
		
		// 이동하면서 물고기 잡아먹기
		for (int dir : selected) {
			sharkX += SharkDir[dir][0];
			sharkY += SharkDir[dir][1];
			
			if (map[sharkX][sharkY].size() > 0) {
				smell[sharkX][sharkY] = s;
				map[sharkX][sharkY].clear();
			}
		}
	}

	private static boolean isIn(int x, int y) {
		return (x >= 0 && x < 4 && y >= 0 && y < 4);
	}
	
	private static void setSharkMove(int depth, int[] selected) {
		if (depth == 3) {
			sharkMove[index++] = Arrays.copyOf(selected, 3);
			return;
		}

		for (int i = 1; i <= 4; i++) {
			selected[depth] = i;
			setSharkMove(depth + 1, selected);
		}
	}
}
