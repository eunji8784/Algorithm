import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			System.out.println(lcm(a, b));
		}
		
		br.close();
	}
	
	private static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}
	
	private static long gcd(long a, long b) {
		while (b > 0) {
			long r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

}
