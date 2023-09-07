import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] prime = new boolean[10001];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		
		for (int i = 2; i * i <= 10000; i++) {
			if (!prime[i]) continue;
			for (int j = i * i; j <= 10000; j += i) {
				prime[j] = false;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			for (int i = n / 2; i >= 2; i--) {
				if (prime[i] && prime[n - i]) {
					sb.append(i + " ").append(n - i).append("\n");
					break;
				}
			}
		}
		
		System.out.print(sb.toString());
		br.close();
	}

}
