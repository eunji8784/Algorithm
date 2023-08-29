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
		int[] count = new int[d + 1];
		
		int max = 0, answer = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (i > k - 1) continue;
			if (count[arr[i]]++ == 0) max++;			
		}
		
		answer = (count[c] == 0 ? max + 1 : max);
		
		for (int i = 1; i < N; i++) {
			if (--count[arr[i - 1]] == 0) max--;
			if (++count[arr[(i + k - 1) % N]] == 1) max++;		
			answer = Math.max(answer, (count[c] == 0 ? max + 1 : max));
		}
		
		System.out.println(answer);		
		br.close();
	}
	
}
