import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mainㅠ {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<Long, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			Long num = Long.parseLong(br.readLine());
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}

		List<Map.Entry<Long, Integer>> lst = new ArrayList<>(map.entrySet());
		Collections.sort(lst, new Comparator<Map.Entry<Long, Integer>>() {
			@Override
			public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
				if (o1.getValue() < o2.getValue()) {
					return 1;
				}
				if (o1.getValue() > o2.getValue()) {
					return -1;
				}
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		
		System.out.println(lst.get(0).getKey());
		br.close();

	}

}
