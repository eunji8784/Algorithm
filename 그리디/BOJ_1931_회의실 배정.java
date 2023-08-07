import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[][] arr = new Integer[N][2];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				if (o1[1] == o2[1]) { // 끝나는 시간이 같다면 시작하는 시간 기준으로 오름차순 정렬
					return Integer.compare(o1[0], o2[0]);
				}
				return Integer.compare(o1[1], o2[1]); // 회의가 끝나는 시간 기준으로 오름차순 정렬
			}
		});

		int answer = 0;
		int end = 0;

		for (int i = 0; i < N; i++) {
			if (arr[i][0] >= end) { // 회의의 시작 시간이 이전 회의가 끝나는 시간 이후인지 확인
				answer++;
				end = arr[i][1];
			}
		}

		System.out.println(answer);
		br.close();

	}

}
