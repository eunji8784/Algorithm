import java.util.*;
import java.io.*;

// HSAT 7회 정기 코딩 인증평가 기출
public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        List<Integer> lst = new ArrayList<>(n);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lst.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(lst);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int key = Integer.parseInt(br.readLine());

            int lo = 0;
            int hi = lst.size() - 1;

            while (lo < hi) {
                int mid = lo + ((hi - lo) / 2);

                if (lst.get(mid) == key) {
                    lo = mid;
                    break;
                }

                if (lst.get(mid) > key) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }

            answer.append(lst.get(lo) == key ? lo * (n - lo - 1) : 0).append("\n");
        }

        System.out.println(answer.toString());
        br.close();
    }
}
