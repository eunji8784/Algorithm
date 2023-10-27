import java.io.*;
import java.util.*;

public class Main {
	private static final int[] DX = { -1, 1, 0, 0 };
	private static final int[] DY = { 0, 0, -1, 1 };

	private static int N, M, k;
	private static int[][] map, copy;
	private static Smell[][] smell;
	private static int[][][] sharkPriority;
	private static int[] sharkDir;
	
	private static class Smell {
		int num, time;
		
		public Smell(int num, int time) {
			this.num = num;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		smell = new Smell[N][N];
		sharkPriority = new int[M + 1][4][4];
		sharkDir = new int[M + 1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if (num > 0) smell[i][j] = new Smell(num, 0);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			sharkDir[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		for (int m = 1; m <= M; m++) {
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					sharkPriority[m][i][j] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
		}
		
		for (int time = 1; time <= 1000; time++) {
			if (move(time)) {
				System.out.println(time);
				return;
			}
			removeSmell(time);
			spreadSmell(time);
		}
		
		System.out.println(-1);
		br.close();
	}
	
	private static void removeSmell(int time) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (smell[i][j] != null && ++smell[i][j].time == k) {
					smell[i][j] = null;
				}
			}
		}
	}
	
	private static void spreadSmell(int time) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					smell[i][j] = new Smell(map[i][j], 0);
				}
			}
		}
	}
	
	private static boolean move(int time) {
		copy = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					int num = map[i][j];
					int dir = sharkDir[num];
					int x = i, y = j;
					boolean isBlankExist = false, sameSmell = false;
					
					for (int d : sharkPriority[num][dir]) {
						int nx = i + DX[d];
						int ny = j + DY[d];
						
						if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						
						if (smell[nx][ny] == null) {
							x = nx;
							y = ny;
							sharkDir[num] = d;
							isBlankExist = true;
							break;
						}
						
						if (!sameSmell && smell[nx][ny].num == num) {
							x = nx;
							y = ny;
							sharkDir[num] = d;
							sameSmell = true;
						}
					}
					
					if (isBlankExist && copy[x][y] != 0) {
						copy[x][y] = Math.min(num, copy[x][y]);
						if (--M == 1) return true;
					} else {
						copy[x][y] = num;
					}
				}
			}
		}
		
		map = copy;
		return false;
	}
}
