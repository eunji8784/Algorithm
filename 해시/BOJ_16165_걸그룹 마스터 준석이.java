import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, String> member = new HashMap<>();
		Map<String, String[]> group = new HashMap<>();

		for (int i = 0; i < N; i++) {

			String groupName = br.readLine();
			int numOfMember = Integer.parseInt(br.readLine());
			String[] arr = new String[numOfMember];

			for (int j = 0; j < numOfMember; j++) {
				String memberName = br.readLine();
				member.put(memberName, groupName);
				arr[j] = memberName;
			}

			Arrays.sort(arr);
			group.put(groupName, arr);

		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {

			String quiz = br.readLine();

			if (Integer.parseInt(br.readLine()) == 1) { // 멤버 이름을 받았을 경우 -> 그룹명 맞추
				sb.append(member.get(quiz)).append("\n");
			} else { // 그룹명을 받았을 경우 -> 멤버들 이름 맞추기
				String[] memberNames = group.get(quiz);
				for (String memberName : memberNames) {
					sb.append(memberName).append("\n");
				}
			}

		}

		System.out.println(sb.toString());

		br.close();

	}

}
