import java.io.*;
import java.util.*;

// gcd: 최대공약수
// lcm: 최소공배수
public class Main {
	
	private static int[] arr, selected;
	private static long answer; // 자료형 주의

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			arr = new int[n];
			selected = new int[2];
			answer = 0;
			
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			System.out.println(answer);
		}
		
		br.close();
	}

	private static void combination(int index, int count) {
		if (count == 2) {
			answer += gcd(selected[0], selected[1]);
			return;
		}
		
		for (int i = index; i < arr.length; i++) {
			selected[count] = arr[i];
			combination(i + 1, count + 1);
		}
	}

	private static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

}
