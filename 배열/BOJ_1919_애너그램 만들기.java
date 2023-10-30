import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word1 = br.readLine();
		String word2 = br.readLine();

		int[] count1 = new int[26];
		int[] count2 = new int[26];

		for (int i = 0; i < word1.length(); i++) {
			char ch = word1.charAt(i);
			count1[ch - 'a']++;
		}
		
		for (int i = 0; i < word2.length(); i++) {
			char ch = word2.charAt(i);
			count2[ch - 'a']++;
		}
		
		int answer = 0;

		for (int i = 0; i < 26; i++) {
			if (count1[i] != count2[i]) {
				answer += Math.abs(count1[i] - count2[i]);
			}
		}

		System.out.println(answer);
		br.close();
	}
}
