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

		if (roseA * priceB > priceA * roseB) {
			long tmp = roseA;
			roseA = roseB;
			roseB = tmp;
			tmp = priceA;
			priceA = priceB;
			priceB = tmp;
		}
		
		long minCost = Long.MAX_VALUE;
		
		for (int a = 0; a < roseB; a++) {
			long b = (long) Math.ceil((double)(N - a * roseA) / roseB);
			boolean isOver = false;
			if (b < 0) {
				b = 0;
				isOver = true;
			}
			minCost = Math.min(minCost, a * priceA + b * priceB);
			if (isOver) break;
		}
		
		bw.write(String.valueOf(minCost));
		bw.flush();
		bw.close();
		br.close();
	}
}
