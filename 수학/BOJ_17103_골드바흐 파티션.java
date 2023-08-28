import java.io.*;
import java.util.*;

public class Main {
	
	private static final int MAX = 1000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		boolean[] isNotPrime = new boolean[MAX + 1];
		
		for (int i = 2; i < Math.sqrt(MAX); i++) {
			if (isNotPrime[i]) continue;
			for (int j = i * i; j <= MAX; j += i) {
				isNotPrime[j] = true;
			}
		}
		
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());			
			int answer = 0;
			
			for (int i = 2; i <= N / 2; i++) {
				if (!isNotPrime[i] && !isNotPrime[N - i]) answer++;
			}
			
			System.out.println(answer);		
		}
		
		br.close();
	}
}
