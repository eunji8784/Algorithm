import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] length = new int[N];
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			length[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, length[i]);
		}
		
		int lo = 1;
		int hi = max;
		
		while (lo <= hi) {
			int mid = lo + ((hi - lo) / 2);
			int sum = 0;
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				sum += length[i] / mid;
				if (sum >= M) {
					flag = true;
					break;
				}
			}
			if (flag) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		
		System.out.println(hi);
		br.close();
	}
	
}
