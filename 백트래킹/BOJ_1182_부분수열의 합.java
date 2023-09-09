import java.io.*;
import java.util.*;

public class Main {
	
	private static int N, S, answer;
	private static int[] arr, selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		selected = new int[N];
		answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0, 0);
		
		System.out.println(answer);
		br.close();
	}
	
	private static void subset(int index, int count) {
		if (index == N) {
			if (count == 0) return;
			int sum = 0;
			for (int i = 0; i < count; i++) {
				sum += selected[i];
			}
			if (sum == S) answer++;
			return;
		}
		
		subset(index + 1, count);
		selected[count] = arr[index];
		subset(index + 1, count + 1);
	}

} 
