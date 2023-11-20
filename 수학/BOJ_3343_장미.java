import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long N = Long.parseLong(st.nextToken());
		long roseA = Long.parseLong(st.nextToken());
		long priceA = Long.parseLong(st.nextToken());
		long roseB = Long.parseLong(st.nextToken());
		long priceB = Long.parseLong(st.nextToken());
		long gcd = lcm(roseA, roseB);
		
		if (gcd / roseA * priceA > gcd / roseB * priceB) {
			long tmp = roseA;
			roseA = roseB;
			roseB = tmp;
			tmp = priceA;
			priceA = priceB;
			priceB = tmp;
		}
		
		long minCost = Long.MAX_VALUE;
		
		for (int b = 0; b < gcd / roseB; b++) {
			long a = (long) Math.ceil((double)(N - (b * roseB)) / roseA);
			if (a < 0) break;
			minCost = Math.min(minCost, a * priceA + b * priceB);
		}
		
		bw.write(String.valueOf(minCost));
		bw.flush();
		bw.close();
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
