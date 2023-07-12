import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, Ans1Idx, Ans2Idx, Ans3Idx;
	static long[] lst;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		lst = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			lst[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(lst);
		binarySearch();
		StringBuilder sb = new StringBuilder();
		System.out.println(
				sb.append(lst[Ans1Idx]).append(" ").append(lst[Ans2Idx]).append(" ").append(lst[Ans3Idx]).toString());
		br.close();

	}

	private static void binarySearch() {

		long min = Long.MAX_VALUE;

		for (int i = 0; i < N - 2; i++) {

			int firstIdx = i;
			int lowIdx = i + 1;
			int highIdx = N - 1;

			while (lowIdx < highIdx) {
				long sum = lst[firstIdx] + lst[lowIdx] + lst[highIdx];

				if (Math.abs(sum) <= min) {
					min = Math.abs(sum);
					Ans1Idx = firstIdx;
					Ans2Idx = lowIdx;
					Ans3Idx = highIdx;
					if (min == 0) {
						return;
					}
				}

				if (sum < 0) {
					lowIdx++;
				} else {
					highIdx--;
				}
			}

		}

	}

}
