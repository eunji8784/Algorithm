import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int p1 = 0;
		int p2 = n - 1;
		int answer = 0;
		
		while (p1 < p2) {
			int sum = arr[p1] + arr[p2];
			if (sum == x) {
				answer++;
				p1++;
				p2--;
			} else if (sum < x) {
				p1++;
			} else {
				p2--;
			}
		}
		
		System.out.println(answer);
		br.close();
	}
}
