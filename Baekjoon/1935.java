import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String postfix = br.readLine();
		double[] arr = new double[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}
		
		Stack<Double> stack = new Stack<>();
		
		double first, second;
		
		for (int i = 0; i < postfix.length(); i++) {
			if ('A' <= postfix.charAt(i) && postfix.charAt(i) <= 'Z') {
				stack.push(arr[postfix.charAt(i) - 'A']);
			} else {
				if (!stack.isEmpty()) {
					first = stack.pop();
					second = stack.pop();
					
					switch(postfix.charAt(i)) {
					case '*':
						stack.push(second * first);
						break;
					case '/':
						stack.push(second / first);
						break;
					case '+':
						stack.push(second + first);
						break;
					case '-':
						stack.push(second - first);
						break;
					}
				}
			}
		}
		
		System.out.printf("%.2f", stack.pop());
		
	}

}
