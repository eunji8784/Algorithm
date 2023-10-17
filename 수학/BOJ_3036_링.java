import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		
		StringBuilder answer = new StringBuilder();
		
		for (int i = 0; i < N - 1; i++) {
			int other = Integer.parseInt(st.nextToken());
			int gcd = gcd(first, other);
			answer.append(first / gcd).append("/").append(other / gcd).append("\n");
		}
		
		System.out.println(answer.toString());
		br.close();
	}
	
	private static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
