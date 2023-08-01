import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num != 0) {
				stack.push(num);
			} else {
				stack.pop();
			}
		}
		int ans = 0;
		while (!stack.empty()) {
			ans += stack.pop();
		}
		System.out.println(ans);
		br.close();
	}

}
