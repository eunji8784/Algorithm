import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = 1;
		for (int i = 0; i < 3; i++) {
			num *= Integer.parseInt(br.readLine());
		}
		
		String str = String.valueOf(num);
		int[] result = new int[10];
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			result[ch - '0']++;
		}
		
		StringBuilder answer = new StringBuilder();
		for (int n : result) {
			answer.append(n + "\n");
		}
		
		System.out.print(answer.toString());
		br.close();
	}
}
