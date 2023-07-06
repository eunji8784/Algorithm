import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이분 탐색 
public class Main {

	static int[] numberList1;

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 1. 정렬 
		 * 2. Lower bound 구하기 
		 * 3. Upper bound 구하기 
		 * 4. (Upper bound - Lower bound) == 중복 값 개수
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		numberList1 = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numberList1[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] numberList2 = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			numberList2[i] = Integer.parseInt(st.nextToken());
		}

		// 1. numberList1 정렬
		Arrays.sort(numberList1);
		
		// StringBuilder 안 쓰면 시간 초과 발생 
		StringBuilder sb = new StringBuilder();

		for (int key : numberList2) {
			sb.append(upperBound(key) - lowerBound(key)).append(" ");
		}
		
		System.out.print(sb.toString());

	}

	private static int lowerBound(int key) {
		int lo = 0;
		int hi = numberList1.length;

		while (lo < hi) {
			int mid = lo + ((hi - lo) / 2);
			if (key <= numberList1[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}

	private static int upperBound(int key) {
		int lo = 0;
		int hi = numberList1.length;

		while (lo < hi) {
			int mid = lo + ((hi - lo) / 2);
			if (key < numberList1[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}

}
