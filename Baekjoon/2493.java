import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static Stack<int[]> stack = new Stack<>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= N; i++) {
			
			int top = Integer.parseInt(st.nextToken());
			
			while (!stack.isEmpty()) {
				
				if (stack.peek()[1] < top) {
					stack.pop();
				} else {
					sb.append(stack.peek()[0]).append(" ");
					break;
				}
				
			}
			
			if (stack.isEmpty()) {
				sb.append(0).append(" ");
			}
			
			stack.push(new int[] {i, top});
			
		}
		
		System.out.println(sb.toString());
	}

}
