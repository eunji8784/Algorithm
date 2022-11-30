import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int[] heights = new int[N];
			int[] diffHeights = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int max = 0;
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, heights[i]);
			}
			
			int sum = 0;
			for (int i = 0; i < N; i++) {
				diffHeights[i] = max - heights[i];
				sum += diffHeights[i];
			}
			
			int ans = sum / 3 * 2;
			
			if (sum % 3 == 1) {
				ans++;
			} else if (sum % 3 == 2) {
				ans += 2;
			}
			
			int evenDay = 0;
			for (int h : diffHeights) {
				evenDay += h / 2;
			}
			
			if (sum > evenDay * 3) {
				ans = evenDay * 2;
			}
			
			int remain = sum - evenDay * 3;
			
			if (remain > 0) {
				ans += remain * 2 - 1;
			}
			
			System.out.printf("#%d %d\n", tc, ans);
			
		}

	}

}
