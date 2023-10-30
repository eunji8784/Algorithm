import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] arr = br.readLine().toCharArray();
		int[] result = new int[26];
		
		for (char c : arr) {
			result[c - 'a']++;
		}
		
		StringBuilder answer = new StringBuilder();
		for (int n : result) {
			answer.append(n + " ");
		}
		
		System.out.println(answer.toString());
		br.close();
	}
}
