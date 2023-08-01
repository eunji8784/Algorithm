import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Long> lst = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		st.nextToken();
		
		while (st.hasMoreTokens()) {
			lst.add(reverse(st.nextToken()));
		}
		
		String str = "";
		while ((str = br.readLine()) != null) {
			st = new StringTokenizer(str, " ");
			while (st.hasMoreTokens()) {
				lst.add(reverse(st.nextToken()));
			}
		}
		
		Collections.sort(lst);
		
		StringBuilder ans = new StringBuilder();
		for (Long num : lst) {
			ans.append(num).append("\n");
		}
		
		System.out.print(ans.toString());
		br.close();
	}
	
	private static long reverse(String str) {
		
		StringBuffer sb = new StringBuffer(str);
		return Long.parseLong(sb.reverse().toString());
		
	}

}
