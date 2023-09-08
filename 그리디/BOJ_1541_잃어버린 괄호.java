import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = br.readLine().split("\\-");
		int answer = 0;
		
		for (int i = 0; i < arr.length; i++) {
			String[] add = arr[i].split("\\+");
			
			int sum = 0;
			for (String s : add) {
				sum += Integer.parseInt(s);
			}
			
			if (i == 0) {
				answer += sum;
			} else {
				answer -= sum;
			}
		}
		
		System.out.println(answer);
		br.close();
	}

}
