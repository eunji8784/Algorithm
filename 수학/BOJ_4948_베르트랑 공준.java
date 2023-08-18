import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			
			System.out.println(solve(n));
		}
		
		br.close();
	}
	
	private static int solve(int n) {
		int count = 0;
		for (int i = n + 1; i <= 2 * n; i++) {
			if (isPrime(i)) count++;
		}
		return count;
	}
	
	private static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
