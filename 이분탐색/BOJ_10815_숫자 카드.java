import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		int[] cards = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cards);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (m-- > 0) {
			int key = Integer.parseInt(st.nextToken());
			int lo = 0, hi = n - 1;
			boolean flag = false;

			while (lo <= hi) {
				int mid = lo + (hi - lo) / 2;
				if (cards[mid] == key) {
					flag = true;
					break;
				} else if (cards[mid] > key) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}

			if (flag) {
				bw.write(1 + " ");
			} else {
				bw.write(0 + " ");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
