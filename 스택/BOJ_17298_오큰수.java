import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<>();
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			
			int top = Integer.parseInt(st.nextToken());
			
			while (!stack.isEmpty()) {
				
				if (stack.peek()[0] < top) {
					arr[stack.pop()[1]] = top;
				} else {
					break;
				}
				
			}
			
			stack.push(new int[] {top, i});
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			if (arr[i] != 0) {
				sb.append(arr[i] + " ");
			} else {
				sb.append("-1 ");
			}
		}
		
		System.out.print(sb.toString());
		br.close();
	}

}
