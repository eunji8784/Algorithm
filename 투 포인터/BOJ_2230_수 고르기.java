import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		int lo = 0, hi = 0, answer = Integer.MAX_VALUE;
		
		while (hi < N) {
			int key = arr[hi] - arr[lo];
			if (key < M) {
				hi++;
			} else if (key > M) {
				lo++;
				answer = Math.min(answer, key);
			} else {
				answer = M;
				break;
			}
		}
		
		bw.write(String.valueOf(answer));
		bw.close();
		br.close();
	}

}
