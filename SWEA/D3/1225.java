import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	public static int T = 10;
	public static int N = 8;
	public static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= T; tc++) {
			
			br.readLine();
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < N; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			int num;
			boolean bool = true;
			
			while (bool) {
				
				for (int i = 1; i <= 5; i++) {
					
					if (queue.peek() - i <= 0) {
						queue.poll();
						num = 0;
						bool = false;
					} else {
						num = queue.poll() - i;
					}
					
					queue.add(num);
					
					if (!bool) break;
					
				}
				
			}
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < N; i++) {
				sb.append(queue.poll()).append(" ");
			}
			
			System.out.println("#" + tc + " " + sb.toString());
			
		}
		
	}

}
