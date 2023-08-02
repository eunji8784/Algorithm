import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> que = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int last = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch (command) {
			case "push":
				last = Integer.parseInt(st.nextToken());
				que.offer(last);
				break;
			case "pop":
				sb.append(que.isEmpty() ? "-1" : que.poll()).append("\n");
				break;
			case "size":
				sb.append(que.size()).append("\n");
				break;
			case "empty":
				sb.append(que.isEmpty() ? "1" : "0").append("\n");
				break;
			case "front":
				sb.append(que.isEmpty() ? "-1" : que.peek()).append("\n");
				break;
			case "back":
				sb.append(que.isEmpty() ? "-1" : last).append("\n");
			}
		}
		
		System.out.print(sb.toString());
		br.close();
	}

}
