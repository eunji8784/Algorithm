import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, C;
	static int[] houses;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		houses = new int[N];
		for (int i = 0; i < N; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(houses);

		binarySearch();

	}

	private static void binarySearch() {

		// 인접한 두 공유기 사이의 최소, 최대 거리
		int min = 1;
		int max = houses[N - 1] - houses[0] + 1;

		while (min < max) {
			int mid = min + ((max - min) / 2);
			if (checkCnt(mid) < C) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}

		System.out.println(min - 1);

	}

	private static int checkCnt(int mid) {
		
		int recentIdx = 0;
		int cnt = 1;
		for (int i = 1; i < N; i++) {
			if (houses[i] - houses[recentIdx] >= mid) {
				recentIdx = i;
				cnt++;
			}
		}
		return cnt;
		
	}

}
