import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		int maxLength = 0, lastIndex = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
			if (dp[i] > maxLength) {
				maxLength = dp[i];
				lastIndex = i;
			}
		}

		List<Integer> lis = new ArrayList<>();
		for (int i = lastIndex; i >= 0; i--) {
			if (dp[i] == maxLength) {
				lis.add(arr[i]);
				maxLength--;
			}
		}

		Collections.reverse(lis);
		bw.write(lis.size() + "\n");
		for (int num : lis) {
			bw.write(num + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
