import java.io.*;
import java.util.*; 

// 슬라이딩 윈도우
// 자기 자신과 앞의 N - 1개의 수 중에서 최솟값을 구하는 문제
// 일반 배열로 풀 경우 시간초과 발생
// 슬라이딩 윈도우 + Deque 활용하여 O(N)의 시간복잡도로 해결
public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Deque<Integer> dq = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			
			while (!dq.isEmpty() && dq.peekLast() > arr[i]) {
				dq.pollLast();
			}
			
			dq.offer(arr[i]);
			
			if (i >= L && dq.peekFirst() == arr[i - L]) {
				dq.pollFirst();
			}
			
			sb.append(dq.peekFirst() + " ");
			
		}
		
		System.out.print(sb.toString());
		br.close();
	}

}
