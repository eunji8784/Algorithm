import java.io.*;
import java.util.*;

public class Main {
	private static final int[] DX = { -1, 1, 0, 0 };
	private static final int[] DY = { 0, 0, -1, 1 };

	private static int N, M, min;
	private static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		board = new char[N][M];
		int[] red = new int[2];
		int[] blue = new int[2];

		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 'R') {
					red[0] = i;
					red[1] = j;
					board[i][j] = '.';
				}
				if (board[i][j] == 'B') {
					blue[0] = i;
					blue[1] = j;
					board[i][j] = '.';
				}
			}
		}
		
		solve(red, blue, 1);

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		br.close();
	}

	private static void solve(int[] red, int[] blue, int count) {
		if (count >= min || count > 10) return;
	
		for (int i = 0; i < 4; i++) {
			int[] nextRed = Arrays.copyOf(red, 2);
			int[] nextBlue = Arrays.copyOf(blue, 2);
			char first = 'B';
			
			switch(i) {
			case 0: // 상 
				if (red[0] < blue[0]) first = 'R';
				break;
			case 1: // 하 
				if (red[0] > blue[0]) first = 'R';
				break;
			case 2: // 좌 
				if (red[1] < blue[1]) first = 'R';
				break;
			case 3: // 우 
				if (red[1] > blue[1]) first = 'R';
			}
			
			if (first == 'R') {
				move(i, nextRed, nextBlue);
				move(i, nextBlue, nextRed);
			} else {
				move(i, nextBlue, nextRed);
				move(i, nextRed, nextBlue);
			}

			if (board[nextBlue[0]][nextBlue[1]] == 'O') continue;
			
			if (board[nextRed[0]][nextRed[1]] == 'O') {
				min = Math.min(min, count);
				return;
			} 
			
			solve(nextRed, nextBlue, count + 1);
		}
	}
	
	private static void move(int dir, int[] next, int[] other) {	
		int x = next[0];
		int y = next[1];
		
		while (true) {
			int nx = x + DX[dir];
			int ny = y + DY[dir];
							
			if (board[nx][ny] == 'O') {
				next[0] = nx;
				next[1] = ny;
				break;
			}
			
			if (board[nx][ny] == '#' || (nx == other[0] && ny == other[1])) break;
			
			x = nx;
			y = ny;
			next[0] = x;
			next[1] = y;
		}
	}
}
