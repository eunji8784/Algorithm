import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int min = Integer.MAX_VALUE;
	private static int[][] ability;
	private static boolean[] vst;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		ability = new int[n][n];
		vst = new boolean[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combination(0, 0);

		bw.write(min + "\n");
		bw.close();
		br.close();
	}

	private static void combination(int index, int depth) {
		if (depth == n / 2) {
			diff();
			return;
		}

		for (int i = index; i < n; i++) {
			if (!vst[i]) {
				vst[i] = true;
				combination(i + 1, depth + 1);
				vst[i] = false;
			}
		}
	}

	private static void diff() {
		int start = 0, link = 0;

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (vst[i] && vst[j]) {
					start += ability[i][j] + ability[j][i];
				} else if (!vst[i] && !vst[j]) {
					link += ability[i][j] + ability[j][i];
				}
			}
		}

		min = Math.min(min, Math.abs(start - link));

		if (min == 0) {
			System.out.println(min);
			System.exit(0);
		}
	}

}
