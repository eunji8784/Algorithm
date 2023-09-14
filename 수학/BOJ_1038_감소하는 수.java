import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<String> que = new LinkedList<>();
		for (int i = 0; i <= 9; i++) {
			que.offer(String.valueOf(i));
		}
		
		int count = 0;
		
		while (!que.isEmpty()) {
			String num = que.poll();
			if (count++ == N) {
				System.out.println(num);
				System.exit(0);
			}
			int last = num.charAt(num.length() - 1) - '0';
			int start = 0;
			while (last-- >= 1) {
				que.offer(num + start++);
			}
		}
		
		System.out.println(-1);
		br.close();
	}

}
