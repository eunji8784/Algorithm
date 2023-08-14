import java.io.*;
import java.util.*;

public class Main {

	private static int N, M;
	private static int[] arr, selected;

	public static void main(String[] args) throws IOException {
		getInput();
		combination(0, 0);
	}

	private static void combination(int count, int index) {
		if (count == M) {
			printAnswer(selected);
			return;
		}

		int prev = -1;

		for (int i = index; i < N; i++) {
			if (prev != arr[i]) {
				selected[count] = arr[i];
				prev = arr[i];
				combination(count + 1, i);
			}
		}
	}

	private static void printAnswer(int[] selected) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			sb.append(selected[i] + " ");
		}
		System.out.println(sb.toString());
	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		selected = new int[M];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		br.close();
	}
}
