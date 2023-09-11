import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			long x = Integer.parseInt(st.nextToken());
			long y = Integer.parseInt(st.nextToken());

			long distance = y - x;
			long max = (long) Math.sqrt(distance);

			if (max == Math.sqrt(distance)) {
				sb.append(2 * max - 1).append("\n");
			} else if (distance > max * max + max) {
				sb.append(2 * max + 1).append("\n");
			} else {
				sb.append(2 * max).append("\n");
			}
		}

		System.out.print(sb.toString());
		br.close();
	}

}
