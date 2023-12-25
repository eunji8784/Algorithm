import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str1 = br.readLine();
		String str2 = br.readLine();

		int length1 = str1.length();
		int length2 = str2.length();

		int[][] dp = new int[length1 + 1][length2 + 1];

		for (int i = 1; i <= length1; i++) {
			for (int j = 1; j <= length2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		StringBuilder lcs = new StringBuilder();
		int i = length1, j = length2;
		
		while (i > 0 && j > 0) {
			if (dp[i][j] == dp[i - 1][j]) {
				i--;
			} else if (dp[i][j] == dp[i][j - 1]) {
				j--;
			} else {
				lcs.insert(0, str1.charAt(i - 1));
				i--;
				j--;
			}
		}

		int length = dp[length1][length2];

		bw.write(length + (length == 0 ? "" : "\n" + lcs.toString()));
		bw.flush();
		bw.close();
		br.close();
	}
}
