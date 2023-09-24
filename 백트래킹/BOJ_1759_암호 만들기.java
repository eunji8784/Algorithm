import java.io.*;
import java.util.*;

public class Main {
	
	private static int L, C;
	private static char[] arr, selected;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		selected = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		
		solution(0, 0, 0, 0);
		
		System.out.print(sb.toString());
		br.close();
	}
	
	private static void solution(int count, int index, int num1, int num2) {
		if (count == L) {
			if (num1 >= 1 && num2 >= 2) {
				for (char chr : selected) {
					sb.append(chr);
				}
				sb.append("\n");
			}
			return;
		}
		
		for (int i = index; i < C; i++) {
			selected[count] = arr[i];
			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
				solution(count + 1, i + 1, num1 + 1, num2);
			} else {
				solution(count + 1, i + 1, num1, num2 + 1);
			}
		}
	}
	
}
