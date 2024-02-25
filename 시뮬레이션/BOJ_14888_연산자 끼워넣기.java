import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int[] numbers;
	private static int max = Integer.MIN_VALUE;
	private static int min = Integer.MAX_VALUE;
	private static int[] operators = new int[4];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		numbers = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}

		solve(numbers[0], 1);

		bw.write(max + "\n" + min);
		bw.close();
		br.close();
	}

	private static void solve(int value, int index) {
		if (index == n) {
			max = Math.max(max, value);
			min = Math.min(min, value);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operators[i] > 0) {
				operators[i]--;
				switch (i) {
				case 0:
					solve(value + numbers[index], index + 1);
					break;
				case 1:
					solve(value - numbers[index], index + 1);
					break;
				case 2:
					solve(value * numbers[index], index + 1);
					break;
				case 3:
					if (value < 0) {
						solve(((value * -1) / numbers[index]) * -1, index + 1);
					} else {
						solve(value / numbers[index], index + 1);
					}
				}
				operators[i]++;
			}
		}
	}

}
