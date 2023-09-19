import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());

		System.out.println(Math.min(getCount(n, 5) - getCount(n - m, 5) - getCount(m, 5),
				getCount(n, 2) - getCount(n - m, 2) - getCount(m, 2)));

		br.close();
	}

	private static long getCount(long n, int div) {
		long count = 0;
		for (long i = div; n / i >= 1; i *= div) {
			count += n / i;
		}
		return count;
	}
}
