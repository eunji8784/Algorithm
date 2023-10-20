import java.io.*;
import java.util.*;

public class Main {
	private static final int[][] FishDir = { { 0, 0 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 },
			{ 1, 0 }, { 1, -1 } };
	private static final int[][] SharkDir = { { 0, 0 }, { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	private static int sharkX, sharkY, index;
	private static int[][][] fishMap, fishMove;
	private static int[][] smell;
	private static int[][] sharkMove;
	
	private static class CopyFish {
		int x, y, dir, cnt;
		
		public CopyFish(int x, int y, int dir, int cnt) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		fishMap = new int[4][4][9];
		smell = new int[4][4];
		sharkMove = new int[64][3];
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fishMap[x - 1][y - 1][d]++;
		}
		
		st = new StringTokenizer(br.readLine());
		sharkX = Integer.parseInt(st.nextToken()) - 1;
		sharkY = Integer.parseInt(st.nextToken()) - 1;
		
		// 상어 이동 방법 초기화
		index = 0;
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
				fishMap[c.x][c.y][c.dir] += c.cnt;
			}
		}
		
		int answer = 0;
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				for (int d = 1; d <= 8; d++) {
					answer += fishMap[x][y][d];
				}
			}
		}
		
		System.out.println(answer);
		br.close();
	}
	
	private static List<CopyFish> copy() {
		List<CopyFish> copy = new ArrayList<>();
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				for (int dir = 1; dir <= 8; dir++) {
					int cnt = fishMap[x][y][dir];
					if (cnt > 0) copy.add(new CopyFish(x, y, dir, cnt));
				}
			}
		}
		return copy;
	}
	
	private static void fishMove(int s) {
		fishMove = new int[4][4][9];
		
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				for (int d = 1; d <= 8; d++) {
					if (fishMap[x][y][d] == 0) continue;
					
					int nx = x, ny = y, dir = d;
					boolean possible = false;
					
					for (int cnt = 0; cnt < 8; cnt++) {
						nx = x + FishDir[dir][0];
						ny = y + FishDir[dir][1];
						
						if (!isIn(nx, ny) || (nx == sharkX && ny == sharkY) || (smell[nx][ny] > 0 && smell[nx][ny] >= s - 2)) {
							dir = (dir == 1 ? 8 : dir - 1);
							continue;
						}
						
						possible = true;
						break;
					}
					
					if (possible) {
						fishMove[nx][ny][dir] += fishMap[x][y][d];
					} else {
						fishMove[x][y][d] += fishMap[x][y][d];
					}
				}
			}
		}
		fishMap = fishMove;
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
					for (int d = 1; d <= 8; d++) {
						fishCnt += fishMap[nx][ny][d];
					}
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
			boolean canFishEat = false;
			
			for (int d = 1; d <= 8; d++) {
				if (fishMap[sharkX][sharkY][d] > 0) {
					canFishEat = true;
					fishMap[sharkX][sharkY][d] = 0;
				}
			}
			
			if (canFishEat) smell[sharkX][sharkY] = s;
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
