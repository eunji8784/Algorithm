import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	static char[] oprArr = { '+', '-', '*', '/' };
	static int N;
	static int[] oprNum;
	static int[] numArr;
	static char[] selected;
	static ArrayList<Integer> lst;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			oprNum = new int[4];
			numArr = new int[N];
			selected = new char[N - 1];
			lst = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				oprNum[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				numArr[i] = Integer.parseInt(st.nextToken());
			}

			doublePer(0);

			int max = Collections.max(lst);
			int min = Collections.min(lst);

			System.out.printf("#%d %d\n", tc, max - min);
		}
	}

	private static void doublePer(int depth) {

		if (depth == N - 1) {
			cal(selected);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (oprNum[i] > 0) {
				selected[depth] = oprArr[i];
				oprNum[i]--;
				doublePer(depth + 1);
				oprNum[i]++;
			}
		}

	}

	private static void cal(char[] selected) {

		int res = numArr[0];

		for (int i = 0; i < N - 1; i++) {
			switch (selected[i]) {
			case '+':
				res += numArr[i + 1];
				break;
			case '-':
				res -= numArr[i + 1];
				break;
			case '*':
				res *= numArr[i + 1];
				break;
			case '/':
				res /= numArr[i + 1];
				break;
			}
		}

		lst.add(res);

	}

}
