import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static int Ms, Ma, N, L, maxBenefit;
	static int[][] data;

	static class Stock {
		int curPrice, nextPrice, diff;

		public Stock(int curPrice, int nextPrice, int diff) {
			this.curPrice = curPrice;
			this.nextPrice = nextPrice;
			this.diff = diff;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Ms = Integer.parseInt(st.nextToken());
			Ma = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			data = new int[N][L + 1];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j <= L; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int money = Ms;
			for (int month = 0; month < L; month++) {
				ArrayList<Stock> stockList = new ArrayList<>();
				for (int i = 0; i < N; i++) {
					if (data[i][month + 1] > data[i][month]) {
						stockList.add(
								new Stock(data[i][month], data[i][month + 1], data[i][month + 1] - data[i][month]));
					}
				}
				maxBenefit = 0;
				dfs(0, money, 0, stockList);
				
				money += maxBenefit;
				money += Ma;
			}
			
			int Ans = money - Ms - (Ma * L);
			System.out.printf("#%d %d\n", tc, Ans);

		}

	}

	private static void dfs(int idx, int money, int benefit, ArrayList<Stock> stockList) {
		
		if (idx == stockList.size()) {
			maxBenefit = Math.max(maxBenefit, benefit);
			return;
		}
		
		Stock stock = stockList.get(idx);
		if (money >= stock.curPrice) {
			dfs(idx, money - stock.curPrice, benefit + stock.diff, stockList);
		}
		
		dfs(idx + 1, money, benefit, stockList);
		
	}

}
