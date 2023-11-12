import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		ListIterator<Integer> iterator = list.listIterator();
		bw.write("<");
		
		while (!list.isEmpty()) {
			for (int i = 0; i < K; i++) {
				if (!iterator.hasNext()) {
					iterator = list.listIterator();
				}
				if (i == K - 1) {
					bw.write(iterator.next().toString() + (list.size() > 1 ? ", " : ">"));
				} else {
					iterator.next();
				}
			}
			
			iterator.remove();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
