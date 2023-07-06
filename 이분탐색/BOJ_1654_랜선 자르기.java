import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long[] lanList;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		lanList = new long[K];
		// 가능한 랜선 길이의 범위가 int형의 최댓값이기 때문에 모든 변수들은 long으로 선언해야 한다.
		long max = 0;
		for (int i = 0; i < K; i++) {
			lanList[i] = Integer.parseInt(br.readLine());
			if (max < lanList[i]) {
				max = lanList[i];
			}
		}
		
		upperBound(N, max + 1);

	}

	private static void upperBound(int key, long max) {
		long min = 0;
		
		while (min < max) {
			long mid = (max + min) / 2;
			long count = 0;
			for (long length : lanList) {
				count += (length / mid);
			}
			if (key > count) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		
		System.out.print(min - 1);
		
	}

}
