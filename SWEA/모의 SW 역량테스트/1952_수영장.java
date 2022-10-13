import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] price;
	static int[][] plan;
	static int monCnt, res, min;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			price = new int[4];
			plan = new int[12][2];
			monCnt = 0;

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i < 13; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp > 0) {
					plan[monCnt][0] = i;
					plan[monCnt][1] = tmp;
					monCnt++;
				}
			}

			min = Integer.MAX_VALUE;
			res = 0;
			solve(0);

			if (price[3] < min) {
				min = price[3];
			}

			System.out.printf("#%d %d\n", tc, min);

		}

	}

	private static void solve(int cnt) {

		if (cnt == monCnt) {
			if (res < min) {
				min = res;
			}
			return;
		}

		for (int i = 0; i < 3; i++) {

			// 1일 이용권
			if (i == 0) {
				res += price[i] * plan[cnt][1];
				solve(cnt + 1);
				res -= price[i] * plan[cnt][1];
			}

			// 1달 이용권
			if (i == 1) {
				res += price[i];
				solve(cnt + 1);
				res -= price[i];
			}
      
			// 3달 이용권
			if (i == 2) {
				res += price[i];
				if (cnt == monCnt - 2) {
					cnt++;
				} else if (cnt < monCnt - 2) {
					for (int m = 0; m < 2; m++) {
						if (plan[cnt][0] + 1 == plan[cnt + 1][0]) {
							cnt++;
						} else {
							break;
						}
					}
				}
				solve(cnt + 1);
				res -= price[i];
			}

		}

	}

}
