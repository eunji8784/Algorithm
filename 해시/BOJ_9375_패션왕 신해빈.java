import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 조합 + 해시맵
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();
			
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				
				st = new StringTokenizer(br.readLine(), " ");
				String name = st.nextToken();
				String type = st.nextToken();
				
				if (!map.containsKey(type)) {
					map.put(type, 1);
				} else {
					int count = map.get(type) + 1;
					map.put(type, count);
				}
				
			}
			
			int ans = 1;
			for (String key : map.keySet()) {
				ans *= map.get(key) + 1;
			}
			
			System.out.println(ans - 1);
			
		}
		
		br.close();

	}

}
