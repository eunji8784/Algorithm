import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		solve(n, k);

		br.close();
	}

	private static void solve(int n, int k) {
		int count = 0;
		boolean[] isNotPrime = new boolean[n + 1];

		for (int i = 2; i <= n; i++) {
			if (isNotPrime[i]) {
				continue;
			}

			for (int j = i; j <= n; j += i) {
				if (isNotPrime[j]) {
					continue;
				}

				isNotPrime[j] = true;
				count++;

				if (count == k) {
					System.out.println(j);
					System.exit(0);
				}
			}
		}
	}

}
