import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] lst = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			lst[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(lst);
		
		int sum = 0, answer = 0;
	
		for (int time : lst) {
			sum += time;
			answer += sum;
		}
		
		System.out.println(answer);
		br.close();

	}

}
