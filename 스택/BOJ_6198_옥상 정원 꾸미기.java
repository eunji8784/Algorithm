import java.io.*;
import java.util.*;

// 자료형에 주의해야 하는 문제
public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		Long Ans = 0L;
		
		for (int i = 0; i < N; i++) {
			
			int top = Integer.parseInt(br.readLine());
			
			while (!stack.isEmpty()) {
				
				if (stack.peek() > top) {
					Ans += stack.size();
					break;
				} else {
					stack.pop();
				}
				
			}
			
			stack.push(top);
			
		}
		
		System.out.println(Ans);
		br.close();

	}

}
