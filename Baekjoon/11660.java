import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 1; j <= N; j++) {
				map[i][j] = map[i][j - 1] + Integer.parseInt(st.nextToken());
			}
		}

		int x1, x2, y1, y2;
		int sum;
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			sum = 0;
			
			st = new StringTokenizer(br.readLine(), " ");
			x1 = Integer.parseInt(st.nextToken()); 
			y1 = Integer.parseInt(st.nextToken()); 
			x2 = Integer.parseInt(st.nextToken()); 
			y2 = Integer.parseInt(st.nextToken()); 

			for (int j = x1 - 1; j < x2; j++) { 
				sum += map[j][y2] - map[j][y1 - 1];
			}
			
			sb.append(sum).append('\n');
		}
		
		System.out.print(sb);

	}

}
