import java.io.*;
import java.util.*;

// 브루트포스 알고리즘 
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int maxYear = lcm(M, N); // M과 N의 최소공배수 
			
			boolean found = false;

			// x년을 기준으로 y 탐색 
			for (int i = x; i <= maxYear; i += M) {
				if ((i % N == 0 ? N : i % N) == y) {
					System.out.println(i);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println(-1);
			}
		}
		br.close();
	}

	// 최소공배수
	private static int lcm(int a, int b) { 
		return a * b / gcd(a, b); // 최소공배수 = (m x n) / 최대공약수 
	}

	// 최대공약수 
	private static int gcd(int a, int b) { 
		while (b != 0) {
			int r = a % b; 
			a = b;
			b = r; 
		}
		return a;
	}

}
