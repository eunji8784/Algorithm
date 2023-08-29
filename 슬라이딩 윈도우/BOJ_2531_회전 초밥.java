import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] select = new int[d + 1];
		
		int max = 0, answer = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < k; i++) {
			if (++select[arr[i]] == 1) max++;
		}
		
		answer = (select[c] == 0 ? max + 1 : max);

		for (int i = 1; i < N; i++) {	
			if (--select[arr[i - 1]] == 0) max--;			
			if (select[arr[(i + k - 1) % N]]++ == 0) max++;	
	
			answer = Math.max(answer, select[c] == 0 ? max + 1 : max);	
		}
		
		System.out.println(answer);
		br.close();
	}
	
}
