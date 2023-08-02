import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int idx = 0;
		int num = 1;
		StringBuilder sb = new StringBuilder();

		while (num <= n) {

			stack.push(num++);
			sb.append("+\n");

			while (!stack.isEmpty()) {

				if (arr[idx] == stack.peek()) {
					stack.pop();
					sb.append("-\n");
					idx++;
				} else {
					if (arr[idx] < stack.peek()) {
						System.out.println("NO");
						System.exit(0);
						br.close();
					}
					break;
				}

			}

		}
		
		System.out.print(sb.toString());
		br.close();

	}

}
