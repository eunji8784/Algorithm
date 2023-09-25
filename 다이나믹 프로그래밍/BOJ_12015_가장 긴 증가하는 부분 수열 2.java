import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
    
		List<Integer> lst = new ArrayList<>();
		lst.add(0);

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (lst.get(lst.size() - 1) < num) {
				lst.add(num);
			} else {
				int lo = 1;
				int hi = lst.size() - 1;

				while (lo < hi) {
					int mid = (lo + hi) / 2;
          
					if (lst.get(mid) >= num) {
						hi = mid;
					} else {
						lo = mid + 1;
					}
				}
				
				lst.set(hi, num);
			}
		}

		System.out.println(lst.size() - 1);
		br.close();
	}

}
