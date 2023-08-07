import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] lst = new int[N];
		for (int i = 0; i < N; i++) {
			lst[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(lst);

		int answer = 0;

		// 음수
		for (int i = 0; i < N; i++) {

			if (lst[i] > 0)
				continue;

			if (i != N - 1 && lst[i + 1] <= 0) {
				answer += lst[i] * lst[++i];
			} else {
				answer += lst[i];
			}

		}
		// 양수
		for (int i = N - 1; i >= 0; i--) {

			if (lst[i] <= 0)
				continue;

			if (lst[i] == 1 || i == 0 || lst[i - 1] <= 1) {
				answer += lst[i];
				continue;
			}

			answer += lst[i] * lst[--i];

		}

		System.out.println(answer);
		br.close();

	}

}
