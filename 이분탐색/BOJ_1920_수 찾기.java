import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이분 탐색
public class Main {
	
	static int[] numberList1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
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
		
		Arrays.sort(numberList1);
		
		StringBuilder sb = new StringBuilder();
		
		for (int key : numberList2) {
			if (binarySearch(key) >= 0) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		
		System.out.print(sb.toString());

	}

	private static int binarySearch(int key) {
		int lo = 0;
		int hi = numberList1.length - 1;
		
		while (lo <= hi) {
			int mid = lo + ((hi - lo) / 2);
			if (key < numberList1[mid]) {
				hi = mid - 1;
			} else if (key == numberList1[mid]) {
				return mid;
			} else {
				lo = mid + 1;
			}
		}
		return -1;
	}

}
