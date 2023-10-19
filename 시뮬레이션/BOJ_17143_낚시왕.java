import java.io.*;
import java.util.*;

public class Main {
	private static int R, C, M;
	private static Shark[][] map, copy;

	private static class Shark {
		int speed, dir, size;

		public Shark(int speed, int dir, int size) {
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Shark[R + 1][C + 1];
		int catchTotal = 0;

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[x][y] = new Shark(s, d - 1, z);
		}
		
		for (int i = 1; i <= C; i++) {
			catchTotal += fishingKing(i);
			sharkMove();
		}

		System.out.println(catchTotal);
		br.close();
	}

	private static int fishingKing(int y) {
		for (int x = 1; x <= R; x++) {
			if (map[x][y] != null) {
				int size = map[x][y].size;
				map[x][y] = null;
				return size;
			}
		}
		return 0;
	}

	private static void sharkMove() {
		copy = new Shark[R + 1][C + 1];
		
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] == null) continue;
				
				Shark shark = map[i][j];
				int x = i;
				int y = j;
				int dir = shark.dir;
				int speed = shark.speed;
				
				if (dir <= 1) {
					int move = (dir == 0 ? x - 1 : R - x);
					if (speed <= move) {
						x = (dir == 0 ? x - speed : x + speed); 
					} else {
						speed -= move;
						int quotient = speed / (R - 1);
						int remainder = speed % (R - 1);
						int cycle = (remainder == 0 ? quotient : quotient + 1);
						dir = (cycle % 2 == 0 ? dir : (dir == 0 ? 1 : 0));
						remainder = (remainder == 0 ? (R - 1) : remainder);
						x = (dir == 0 ? (R - remainder) : (1 + remainder));
					}
				}
				
				if (dir > 1) {
					int move = (dir == 2 ? C - y : y - 1);
					if (speed <= move) {
						y = (dir == 2 ? y + speed : y - speed);
					} else {
						speed -= move;
						int quotient = speed / (C - 1);
						int remainder = speed % (C - 1);
						int cycle = (remainder == 0 ? quotient : quotient + 1);
						dir = (cycle % 2 == 0 ? dir : (dir == 2 ? 3 : 2));
						remainder = (remainder == 0 ? (C - 1) : remainder);
						y = (dir == 2 ? (1 + remainder) : (C - remainder));
					}
				}
				
				if (copy[x][y] == null || (copy[x][y] != null && copy[x][y].size < shark.size)) {
					shark.dir = dir;
					copy[x][y] = shark;
				}
			}
		}
    
		map = copy;
	}
}
