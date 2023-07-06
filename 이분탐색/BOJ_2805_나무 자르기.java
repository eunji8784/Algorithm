import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] trees;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		trees = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		int max = 0;
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			if (max < trees[i]) {
				max = trees[i];
			}
		}
		upperBound(max + 1, M);

	}

	private static void upperBound(int max, int M) {
		int min = 0;
		
		while (min < max) {
			int mid = min + ((max - min) / 2);
			// 단일 나무의 길이가 최대 10억이므로 합산하는 과정에서 overflow가 발생하지 않도록 
			// sum 변수는 long 타입으로 선언한다.
			long sum = 0;
			for (int tree : trees) {
				if (tree > mid) {
					sum += (tree - mid);
				}
			}
			if (sum < M) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		
		System.out.print(min - 1);
		
	}

}
