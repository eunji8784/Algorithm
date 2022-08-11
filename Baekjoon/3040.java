import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백설공주와 일곱 난쟁이
조합
*/

public class Main {

	static int n = 9;
	static int r = 7;
	static int[] arr = new int[n];
	static int[] selected = new int[r];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		combination(0, 0);

	}

	private static void combination(int idx, int count) {

		if (count == r) {

			int sum = 0;

			for (int num : selected) {
				sum += num;
			}

			if (sum == 100) {

				for (int num : selected) {
					sb.append(num).append("\n");
				}

				System.out.println(sb);

			}

			return;

		}

		for (int i = idx; i < n; i++) {
			selected[count] = arr[i];
			combination(i + 1, count + 1);
		}

	}

}
