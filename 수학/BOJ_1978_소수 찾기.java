import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			if (isPrime(Integer.parseInt(st.nextToken()))) {
				answer++;
			}
		}

		System.out.println(answer);
		br.close();
	}
	
	private static boolean isPrime(int n) {	
		if (n < 2) {
			return false;
		}
		
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;	
	}

}
