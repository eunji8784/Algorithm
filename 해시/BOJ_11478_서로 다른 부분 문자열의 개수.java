import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// substring() 활용 가능
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		Set<String> set = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			
			int idx = i;
			String str = "";
			
			for (int l = 1; l <= arr.length; l++) {
				
				if (idx == arr.length) {
					break;
				}
				
				str += arr[idx++];
				set.add(str);
			}
			
		}

		System.out.println(set.size());
		br.close();

	}

}
