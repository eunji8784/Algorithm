import java.util.*;
import java.io.*;

class Solution {
    private static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private static int n, m;
    private static int[] result;
    private static boolean[][] vst;

    private static class Location {
        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        vst = new boolean[n][m];
        result = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vst[i][j] && land[i][j] == 1) {
                    bfs(i, j, land);
                }
            }
        }

        int answer = -1;
        for (int val : result) {
            answer = Math.max(answer, val);
        }
        
        return answer;
    }
    
    private static void bfs(int x, int y, int[][] land) {
        int count = 0;
        Queue<Location> que = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        que.offer(new Location(x, y));
        vst[x][y] = true;
        set.add(y);

        while (!que.isEmpty()) {
            Location loc = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = loc.x + DIR[i][0];
                int ny = loc.y + DIR[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || vst[nx][ny] || land[nx][ny] == 0) {
                    continue;
                }

                set.add(ny);
                que.offer(new Location(nx, ny));
                vst[nx][ny] = true;
            }

            count++;
        }

        for (int row : set) {
            result[row] += count;
        }
    }
}

// 테스트 1 〉	통과 (0.66ms, 79MB)
// 테스트 2 〉	통과 (0.78ms, 76.1MB)
// 테스트 3 〉	통과 (0.38ms, 72.6MB)
// 테스트 4 〉	통과 (0.45ms, 75.5MB)
// 테스트 5 〉	통과 (0.46ms, 66.4MB)
// 테스트 6 〉	통과 (1.12ms, 78.2MB)
// 테스트 7 〉	통과 (2.03ms, 73.1MB)
// 테스트 8 〉	통과 (0.69ms, 64.2MB)
// 테스트 9 〉	통과 (3.46ms, 79.1MB)
// 효율성  테스트
// 테스트 1 〉	통과 (37.77ms, 64.8MB)
// 테스트 2 〉	통과 (63.41ms, 73.3MB)
// 테스트 3 〉	통과 (65.76ms, 74.3MB)
// 테스트 4 〉	통과 (25.12ms, 63MB)
// 테스트 5 〉	통과 (96.40ms, 72.9MB)
// 테스트 6 〉	통과 (26.03ms, 64.8MB)
