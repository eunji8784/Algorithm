import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String roomNumber = Integer.toString(N);
		int[] count = new int[10];
		
		for (int i = 0; i < roomNumber.length(); i++) {
			count[roomNumber.charAt(i) - '0']++;
		}
		
		int sum = count[6] + count[9];
		count[6] = (sum / 2) + (sum % 2);
		
		int answer = -1;
		for (int i = 0; i < 9; i++) {
			answer = Math.max(answer, count[i]);
		}
		
		System.out.print(answer);
		br.close();
	}
}
