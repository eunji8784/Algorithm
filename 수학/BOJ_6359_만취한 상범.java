import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			boolean[] open = new boolean[n + 1];
			Arrays.fill(open, true);

			for (int i = 2; i <= n; i++) {
				for (int idx = i; idx <= n; idx += i) {
					if (i > 2) {
						open[idx] = open[idx] ? false : true;
					} else {
						open[idx] = false;
					}
				}
			}

			int count = 0;
			for (int i = 1; i <= n; i++) {
				if (open[i]) count++;
			}

			System.out.println(count);

		}

		br.close();
	}

}
