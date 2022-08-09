import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int[][] map = new int[100][100];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		int res = 0;
		
		for (int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int dx = x; dx < x + 10; dx++) {
				for (int dy = y; dy < y + 10; dy++) {
					if (map[dx][dy] == 0) {
						map[dx][dy] = 1;
						res++;
					}
				}
			}
			
		}
		
		System.out.println(res);
		
	}

}
