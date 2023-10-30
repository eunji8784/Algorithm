import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			String newStr = st.nextToken();
			
			if (str.length() != newStr.length()) {
				answer.append("Impossible\n");
				continue;
			}
			
			int[] count1 = new int[26];
			int[] count2 = new int[26];
			boolean isSame = true;
			
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				count1[ch - 'a']++;
				ch = newStr.charAt(i);
				count2[ch - 'a']++;
			}
			
			for (int i = 0; i < 26; i++) {
				if (count1[i] != count2[i]) {
					isSame = false;
					break;
				}
			}
			
			if (isSame) {
				answer.append("Possible\n");
			} else {
				answer.append("Impossible\n");
			}
		}
		
		System.out.print(answer.toString());
		br.close();
	}
}
