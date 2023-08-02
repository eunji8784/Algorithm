import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> que = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			que.offer(i);
		}
		
		while (que.size() > 1) {
			
			// 제일 위에 있는 카드를 바닥에 버린다.
			que.poll();
			
			// 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
			int cardNum = que.poll();
			que.offer(cardNum);
			
		}
		
		System.out.println(que.poll());
		br.close();

	}

}
