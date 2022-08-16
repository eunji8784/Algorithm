import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 분할 정복, 재귀

public class Main {
	
	static int[][] map;
	static int white = 0;
	static int blue = 0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		division(0, 0, N);
		
		StringBuilder sb = new StringBuilder();
		sb.append(white).append("\n").append(blue);
		System.out.print(sb.toString());

	}

	private static void division(int x, int y, int size) {
		
		if (colorCheck(x, y, size)) {
			
			if (map[x][y] == 0) {
				white++;
			} else {
				blue++;
			}
			
			return;
			
		}
		
		int newSize = size / 2;
		
		division(x, y, newSize); // 2사분면
		division(x, y + newSize, newSize); // 1사분면
		division(x + newSize, y, newSize); // 3사분면
		division(x + newSize, y + newSize, newSize); // 4사분면
		
	}

	private static boolean colorCheck(int x, int y, int size) {
		
		int color = map[x][y];
		
		for (int i = x; i < x + size; i++) {
			
			for (int j = y; j < y + size; j++) {
				
				if (map[i][j] != color) {
					return false;
				}
				
			}
			
		}
		
		return true;
		
	}

}
