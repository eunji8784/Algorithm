import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] A, B;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int Ans = 0;
			A = new int[N];
			B = new int[M];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(B);
			Map<Integer, Integer> map = new HashMap<>();
			for (int a : A) {
				if (map.containsKey(a)) {
					Ans += map.get(a);
					continue;
				} else {
					int cnt = binarySearch(a);
					Ans += cnt;
					map.put(a, cnt);
				}
			}

			System.out.println(Ans);
		}

		br.close();

	}

	static int binarySearch(int key) {

		int low = 0;
		int hi = B.length - 1;
		int cnt = 0;

		while (low <= hi) {

			int mid = (low + hi) / 2;

			if (B[mid] < key) {
				low = mid + 1;
				cnt = mid + 1;
			} else {
				hi = mid - 1;
			}

		}

		return cnt;

	}

}
