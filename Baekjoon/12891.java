import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dnaChr = new int[4]; // {'A','C','G','T'}
	static int[] dnaCnt = new int[4];
	static char[] arr;
	static int check = 0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int result = 0;
		
		arr = br.readLine().toCharArray();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < dnaChr.length; i++) {
			
			dnaChr[i] = Integer.parseInt(st.nextToken());
			
			if (dnaChr[i] == 0) { 
				check++;
			}
			
		}
		
		// 첫 번째 부분문자열 처리
		for (int i = 0; i < P; i++) {
			Add(arr[i]);
		}
		
		if (check == 4) {
			result++;
		}
		
		// 슬라이딩윈도우 
		for (int i = P; i < S; i++) {
			
			int j = i - P;
			
			Add(arr[i]);
			Remove(arr[j]);
			
			if (check == 4) {
				result++;
			}
			
		}
		
		System.out.println(result);
		br.close();
		
		
	} 

	private static void Remove(char c) {
		
		switch (c) {
		case 'A':
			if (dnaCnt[0] == dnaChr[0]) {
				check--;
			}
			dnaCnt[0]--;
			break;
		case 'C':
			if (dnaCnt[1] == dnaChr[1]) {
				check--;
			}
			dnaCnt[1]--; 
			break;
		case 'G':
			if (dnaCnt[2] == dnaChr[2]) {
				check--;
			}
			dnaCnt[2]--; 
			break;
		case 'T':
			if (dnaCnt[3] == dnaChr[3]) {
				check--;
			}
			dnaCnt[3]--; 
			break;
		}
		
	}

	private static void Add(char c) {
		
		switch (c) {
		case 'A':
			dnaCnt[0]++;
			if (dnaCnt[0] == dnaChr[0]) {
				check++;
			}
			break;
		case 'C':
			dnaCnt[1]++;
			if (dnaCnt[1] == dnaChr[1]) {
				check++;
			}
			break;
		case 'G':
			dnaCnt[2]++;
			if (dnaCnt[2] == dnaChr[2]) {
				check++;
			}
			break;
		case 'T':
			dnaCnt[3]++;
			if (dnaCnt[3] == dnaChr[3]) {
				check++;
			}
			break;
		}
		
	}

}
