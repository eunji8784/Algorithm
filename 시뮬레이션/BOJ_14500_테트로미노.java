import java.io.*;
import java.util.*;

public class Main {

	private static final int[][][] BLOCKS = {
		{ { 0, 1 }, { 0, 2 }, { 0, 3 } },
		{ { 1, 0 }, { 2, 0 }, { 3, 0 } },
		{ { 0, 1 }, { 1, 0 }, { 1, 1 } },
		{ { 1, 0 }, { 2, 0 }, { 2, 1 } },
		{ { 1, 0 }, { 2, 0 }, { 2, -1 } },
		{ { 1, 0 }, { 2, 0 }, { 0, 1 } },
		{ { 1, 0 }, { 2, 0 }, { 0, -1 } },
		{ { 1, 0 }, { 0, 1 }, { 0, 2 } },
		{ { 0, 1 }, { 0, 2 }, { 1, 2 } },
		{ { 0, 1 }, { 0, 2 }, { -1, 2 } },
		{ { 1, 0 }, { 1, 1 }, { 1, 2 } },
		{ { 1, 0 }, { 2, 0 }, { 2, -1 } },
		{ { 1, 0 }, { 1, 1 }, { 2, 1 } },
		{ { 1, 0 }, { 1, -1 }, { 2, -1 } },
		{ { 0, -1 }, { 1, -1 }, { 1, -2 } },
		{ { 0, 1 }, { 1, 1 }, { 1, 2 } },
		{ { 0, 1 }, { 1, 1 }, { 0, 2 } },
		{ { 0, 1 }, { -1, 1 }, { 0, 2 } },
		{ { 1, 0 }, { 1, -1 }, { 2, 0 } },
		{ { 1, 0 }, { 1, 1 }, { 2, 0 } },
	};
	
	private static int N, M;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		getInput();
		System.out.println(solution());
	}
	
	private static int solution() {
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				answer = Math.max(answer, checkAllBlocks(i, j));
			}
		}
		return answer;
	}
	
	private static int checkAllBlocks(int x, int y) {
		int max = 0, sum = 0;
		boolean isBlock = true;
		
		for (int[][] blocks : BLOCKS) {
			sum = 0;
			isBlock = true;
			
			for (int[] block : blocks) {
				int nx = x + block[0];
				int ny = y + block[1];
				
				if (!isInArea(nx, ny)) {
					isBlock = false;
					break;
				}
				sum += map[nx][ny];
			}
			
			if (isBlock) {
				max = Math.max(max, sum);
			}
		}
		
		return max + map[x][y];
	}

	private static boolean isInArea(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
	}
}
