import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>(N);
		for (int i = 0 ; i < N; i++) {
			set.add(br.readLine());
		}
		List<String> lst = new ArrayList<>(set);
		Collections.sort(lst);
		Collections.sort(lst, (s1, s2) -> s1.length() - s2.length());
		StringBuilder sb = new StringBuilder();
		for (String str : lst) {
			sb.append(str + "\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

}
