import java.util.*;
import java.io.*;

// HSAT 7회 정기 코딩 인증평가 기출
public class Main
{
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    private static int n, m, answer;
    private static int[][] map, target;

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;
        map = new int[n][n];
        target = new int[2][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            } 
        }

        int num = 2;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = num++; 
            if (i == 0) {
                target[0][0] = x;
                target[0][1] = y;
            }
            if (i == m - 1) {
                target[1][0] = x;
                target[1][1] = y;
            }
        }

        boolean[][] vst = new boolean[n][n];
        vst[target[0][0]][target[0][1]] = true;
        dfs(target[0][0], target[0][1], 2, vst);

        System.out.println(answer);
        br.close();
    }

    private static void dfs(int x, int y, int prev, boolean[][] vst) {
        if (x == target[1][0] && y == target[1][1]) {
            answer++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || vst[nx][ny] || map[nx][ny] == 1) {
                continue;
            }

            if (map[nx][ny] == 0) { // 가려는 곳이 빈칸이면 그냥 간다 
                vst[nx][ny] = true;
                dfs(nx, ny, prev, vst);
                vst[nx][ny] = false;
            } else { // 가려는 곳이 target 중의 하나일 때 순서 확인
                if (map[nx][ny] - prev == 1) {
                    dfs(nx, ny, map[nx][ny], vst);
                }
            }
        }
    }
}
