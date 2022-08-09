import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	static int T = 10;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<Integer>(N);
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < M; i++) {
				
				st.nextToken();
				
				int idx = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				
				for (int j = 0; j < cnt; j++) {
					arr.add(idx, Integer.parseInt(st.nextToken()));
					idx++;
				}
				
			}
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < 10; i++) {
				sb.append(arr.get(i)).append(" ");
			}
			
			System.out.println("#" + tc + " " + sb.toString());
			
		}

	}

}
