import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static int n, max;
	private static String expression;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		max = Integer.MIN_VALUE;
		expression = br.readLine();

		solve(1, expression.charAt(0) - '0');

		bw.write(max + "\n");
		bw.close();
		br.close();
	}

	private static void solve(int idx, int result) {
		if (idx == n) {
			max = Math.max(result, max);
			return;
		}
	
		int a, b, sum;
		char operation;

		if (idx + 3 < n) {
			a = expression.charAt(idx + 1) - '0';
			operation = expression.charAt(idx + 2);
			b = expression.charAt(idx + 3) - '0';	
			sum = cal(a, operation, b);
			operation = expression.charAt(idx);
			solve(idx + 4, cal(result, operation, sum));
		}
		
		operation = expression.charAt(idx);
		b = expression.charAt(idx + 1) - '0';
		
		solve(idx + 2, cal(result, operation, b));
	}

	private static int cal(int a, char operation, int b) {
		switch (operation) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		}
		return 0;
	}

}
