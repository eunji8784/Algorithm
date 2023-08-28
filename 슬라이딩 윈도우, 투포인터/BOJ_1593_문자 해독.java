import java.io.*;
import java.util.*;

// 슬라이딩 윈도우 
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int g = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] pattern = new int[52]; 
		int[] current = new int[52]; 
		
		String W = br.readLine();
		String S = br.readLine();
		
		for (int i = 0; i < g; i++) {
			if (W.charAt(i) <= 'Z') { // 대문자 
				pattern[W.charAt(i) - 'A']++;
			} else { // 소문자 
				pattern[W.charAt(i) - 'a' + 26]++;
			}
			
			if (S.charAt(i) <= 'Z') { // 대문자 
				current[S.charAt(i) - 'A']++;
			} else { // 소문자 
				current[S.charAt(i) - 'a' + 26]++;
			}
		}
		
		int answer = 0;
		int startIdx = 0;
		int endIdx = g - 1;
		
		while (endIdx < s) {
			boolean flag = true;
			
			for (int i = 0; i < 52; i++) {
				if (pattern[i] != current[i]) {
					flag = false;
					break;
				}
			}
			
			if (flag) answer++;	
			if (endIdx == s - 1) break;
			
			if (S.charAt(startIdx) <= 'Z') {
				current[S.charAt(startIdx) - 'A']--;
			} else {
				current[S.charAt(startIdx) - 'a' + 26]--;
			}
			
			startIdx++;
			endIdx++;
			
			if (S.charAt(endIdx) <= 'Z') {
				current[S.charAt(endIdx) - 'A']++;
			} else {
				current[S.charAt(endIdx) - 'a' + 26]++;
			}
			
		}

		System.out.println(answer);
		br.close();
	}
}
