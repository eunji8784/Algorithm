import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
	
	static int N, L;
	static int[][] ingredient;
	static int[] selectedIdx;
	static int maxScore;

	public static void main(String[] args) throws IOException {
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			ingredient = new int[N][2];
			selectedIdx = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				ingredient[i][0] = Integer.parseInt(st.nextToken());
				ingredient[i][1] = Integer.parseInt(st.nextToken());
			}
			maxScore = 0;
			subset(0, 0);
			
			System.out.printf("#%d %d\n", tc, maxScore);
		}

	}

	private static void subset(int index, int count) {
		
		if (index == N) {
			
			int calories = 0;
			int score = 0;
			
			for (int i = 0; i < count; i++) {
				calories += ingredient[selectedIdx[i]][1];
				score += ingredient[selectedIdx[i]][0];
			}
			
			if (calories <= L && score > maxScore) {
				maxScore = score;
			}
			
			return;
			
		}
		
		subset(index + 1, count);
		selectedIdx[count] = index;
		subset(index + 1, count + 1);
		
	}

}
