import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			
			int num = Integer.parseInt(st.nextToken());
			
			while (!stack.isEmpty()) {
				
				if (stack.peek()[0] > num) {
					sb.append(stack.peek()[1] + " ");
					break;
				} else {
					stack.pop();
				}
				
			}
			
			if (stack.isEmpty()) {
				sb.append("0 ");
			}
			
			stack.push(new int[] { num, i });
			
		}

		System.out.print(sb.toString());
		br.close();

	}

}
