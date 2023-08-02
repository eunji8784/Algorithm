import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> que = new LinkedList<>();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			String cmd = st.nextToken();

			switch (cmd) {
			case "push":
				que.offer(Integer.parseInt(st.nextToken()));
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
				sb.append(que.isEmpty() ? "-1" : ((LinkedList<Integer>) que).peekLast()).append("\n");
			}

		}
		System.out.print(sb.toString());
		br.close();
	}

}
