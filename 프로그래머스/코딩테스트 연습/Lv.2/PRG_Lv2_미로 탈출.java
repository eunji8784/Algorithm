import java.util.*;

class Solution {
    private static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private static char[][] map;
    private static int n, m;

    public class Location {
        int x, y, depth, leverCheck;

        public Location(int x, int y, int depth, int leverCheck) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.leverCheck = leverCheck;
        }
    }
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        int startX = 0, startY = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = maps[i].charAt(j);
                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
            }
        }
        
        return bfs(startX, startY);
    }

    private int bfs(int startX, int startY) {
        Queue<Location> que = new LinkedList<>();
        boolean[][][] vst = new boolean[n][m][2];

        que.offer(new Location(startX, startY, 0, 0));
        vst[startX][startY][0] = true;

        while (!que.isEmpty()) {
            Location cur = que.poll();
            int x = cur.x;
            int y = cur.y;
            int depth = cur.depth;
            int leverCheck = cur.leverCheck;

            if (map[x][y] == 'E' && leverCheck == 1) {
                return depth;
            }

            if (map[x][y] == 'L' && leverCheck == 0) {
                leverCheck = 1;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + DIR[i][0];
                int ny = y + DIR[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 'X' || vst[nx][ny][leverCheck]) {
                    continue;
                }

                que.offer(new Location(nx, ny, depth + 1, leverCheck));
                vst[nx][ny][leverCheck] = true;
            }
        }

        return -1;
    }
}

// 테스트 1 〉	통과 (0.38ms, 78.8MB)
// 테스트 2 〉	통과 (0.43ms, 80.1MB)
// 테스트 3 〉	통과 (0.67ms, 65.6MB)
// 테스트 4 〉	통과 (0.73ms, 76.5MB)
// 테스트 5 〉	통과 (0.62ms, 73.4MB)
// 테스트 6 〉	통과 (0.50ms, 74.3MB)
// 테스트 7 〉	통과 (1.56ms, 64.6MB)
// 테스트 8 〉	통과 (2.39ms, 77.8MB)
// 테스트 9 〉	통과 (0.50ms, 78.5MB)
// 테스트 10 〉	통과 (0.40ms, 75.4MB)
// 테스트 11 〉	통과 (1.26ms, 76.6MB)
// 테스트 12 〉	통과 (6.13ms, 80.1MB)
// 테스트 13 〉	통과 (12.18ms, 73.9MB)
// 테스트 14 〉	통과 (5.19ms, 77MB)
// 테스트 15 〉	통과 (2.10ms, 72.8MB)
// 테스트 16 〉	통과 (7.90ms, 84.2MB)
// 테스트 17 〉	통과 (15.87ms, 79.8MB)
// 테스트 18 〉	통과 (0.83ms, 77.7MB)
// 테스트 19 〉	통과 (0.64ms, 77.7MB)
// 테스트 20 〉	통과 (5.17ms, 68.9MB)
// 테스트 21 〉	통과 (4.95ms, 86.7MB)
// 테스트 22 〉	통과 (0.61ms, 71.9MB)
// 테스트 23 〉	통과 (0.30ms, 74.4MB)
