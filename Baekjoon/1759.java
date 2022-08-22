import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int L;
	static int C;
	static char[] arr;
	static char[] selected;
	static int vowel = 0;
	static int consonant = 0;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		selected = new char[L];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		
		combination(0, 0);
		
		System.out.println(sb);
		
	}

	private static void combination(int index, int count) {
		
		if (count == L) {
			
			for (int i = 0; i < L; i++) {
				if (selected[i] == 'a' || selected[i] == 'e' || selected[i] == 'i' || selected[i] == 'o' || selected[i] == 'u') {
					vowel++;
				} else {
					consonant++;
				}
			}
			
			if (vowel >= 1 && consonant >= 2) {
				for (int i = 0; i < L; i++) {
					sb.append(selected[i]);
				}
				sb.append("\n");
			}
			
			vowel = 0;
			consonant = 0;
			
			return;
		}
		
		for (int i = index; i < C; i++) {
			selected[count] = arr[i];
			combination(i + 1, count + 1);
		}
		
	}

}
