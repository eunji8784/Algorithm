import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Integer arr[] = new Integer[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr, (o1, o2) -> o2 - o1);
		
		int max = arr[0];
		
		for (int i = 1; i < N; i++) {
			max = Math.max(max, arr[i] * (i + 1));
		}
		
		System.out.println(max);
		br.close();
	}

}
