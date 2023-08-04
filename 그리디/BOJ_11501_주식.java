import java.io.*;
import java.util.*;

/* 
 * 미래의 최고 가격일 때 해당 주식을 팔고, 
 * 그 전의 모든 날에는 주식을 사는 것이 최적의 전략
 * 
 * 1. 주식 가격 리스트를 뒤에서부터 순회합니다.
 * 2. 현재 가격이 이전에 본 가격들 중 가장 높은 가격보다 높다면, 그 가격을 '현재 가장 높은 가격'으로 갱신합니다.
 * 3. 현재 가격이 '현재 가장 높은 가격'보다 낮다면, 그 차이를 이익에 더해줍니다. 이는 현재 가격에 주식을 사서 '현재 가장 높은 가격'에 팔 때 얻는 이익과 동일합니다.
*/
public class Main {
	
	private static int N;
	private static int[] list;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			list = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			
			System.out.println(Solution());
			
		}
		
		br.close();
	}

	private static long Solution() {
		
		long answer = 0L;
		int bestPrice = Integer.MIN_VALUE;
		
		for (int i = N - 1; i >= 0; i--) {
			int currentPrice = list[i];
			if (currentPrice > bestPrice) {
				bestPrice = currentPrice;
			} else if (currentPrice < bestPrice) {
				answer += bestPrice - currentPrice;
			}
		}
		
		return answer;
		
	}

}
