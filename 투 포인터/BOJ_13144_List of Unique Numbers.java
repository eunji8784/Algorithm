import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		long answer = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Set<Integer> set = new HashSet<>();
		int start = 0, end = 0;
		set.add(arr[0]);
		
		while (start < N) {
			while (end + 1 < N && !set.contains(arr[end + 1])) {
				set.add(arr[++end]);
			}
			
			if (start == end) {
				answer++;
				start++;
				end++;
				continue;
			}
			
			answer += (end - start + 1);
			set.remove(arr[start++]);
		}
		
		System.out.println(answer);
		br.close();
	}
}
