import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[] arr = new int[B + 1];
		int idx = 1, count = 1;
		
		while (idx <= B) {
			for (int i = 0; i < count; i++) {
				arr[idx++] = count;
				if (idx > B) break;
			}
			count++;
		}
		
		int sum = 0;
		for (int i = A; i <= B; i++) {
			sum += arr[i];
		}
		
		System.out.println(sum);

		br.close();
	}

}
