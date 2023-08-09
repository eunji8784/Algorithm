import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		System.out.println(N == 0 || K == 0 ? 1 : solve(N, K));
		br.close();
	}

	private static int solve(int n, int k) {
		return factorial(n, k) / factorial(n - k, 1);
	}
	
	private static int factorial(int n, int k) {
		if (n <= k) {
			return 1;
		}
		return n * factorial(n - 1, k);
	}

}
