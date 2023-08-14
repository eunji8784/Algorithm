import java.io.*;
import java.util.*;

public class Main {

	private static int k;
	private static int[] S, selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			k = Integer.parseInt(st.nextToken());
			if (k == 0) break;

			S = new int[k];
			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}

			selected = new int[6];
			combination(0, 0);
			System.out.println();
		}

		br.close();
	}

	private static void combination(int count, int index) {
		if (count == 6) {
			printSelected(selected);
			return;
		}

		for (int i = index; i < k; i++) {
			selected[count] = S[i];
			combination(count + 1, i + 1);
		}
	}

	private static void printSelected(int[] selected) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			sb.append(selected[i] + " ");
		}
		System.out.println(sb.toString());
	}

}
