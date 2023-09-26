import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		if (getLength(N) < k) {
			System.out.println(-1);
			return;
		}
		
		int len = 1;
		long cnt = 9;
		while (k > len * cnt) {
			k -= len++ * cnt;
			cnt *= 10;
		}
		
		int num = (int)((k - 1) / len + Math.pow(10, len - 1));
		int idx = (k - 1) % len;
		
		System.out.println(Integer.toString(num).charAt(idx) - '0');
		br.close();
	}

	private static long getLength(int N) {
		long length = 0;
		for (int start = 1, len = 1; start <= N; start *= 10, len++) {
			int end = start * 10 - 1;
			if (end >= N) end = N;
			length += (end - start + 1) * len;
		}
		return length;
	}
}
