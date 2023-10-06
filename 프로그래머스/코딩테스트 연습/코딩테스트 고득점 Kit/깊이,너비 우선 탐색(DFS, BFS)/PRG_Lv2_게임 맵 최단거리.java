import java.util.*;

class Solution {
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};
    
    private static class Location {
        int x, y, count;
        
        public Location(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    private static int bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<Location> que = new LinkedList<>();
        boolean[][] vst = new boolean[n][m];
        
        que.offer(new Location(0, 0, 1));
        vst[0][0] = true;
        
        while (!que.isEmpty()) {
            Location cur = que.poll();
            
            if (cur.x == n - 1 && cur.y == m - 1) return cur.count;
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + DX[i];
                int ny = cur.y + DY[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || vst[nx][ny] || maps[nx][ny] == 0) continue;
                
                que.offer(new Location(nx, ny, cur.count + 1));
                vst[nx][ny] = true;
            }
        }
        
        return -1;
    }
}

// 테스트 1 〉	통과 (0.31ms, 71.9MB)
// 테스트 2 〉	통과 (0.28ms, 73.3MB)
// 테스트 3 〉	통과 (0.31ms, 70.1MB)
// 테스트 4 〉	통과 (0.30ms, 81.8MB)
// 테스트 5 〉	통과 (0.31ms, 75MB)
// 테스트 6 〉	통과 (0.41ms, 78.7MB)
// 테스트 7 〉	통과 (0.44ms, 78.6MB)
// 테스트 8 〉	통과 (0.34ms, 73.2MB)
// 테스트 9 〉	통과 (0.44ms, 69.7MB)
// 테스트 10 〉	통과 (0.46ms, 74.1MB)
// 테스트 11 〉	통과 (0.29ms, 70.4MB)
// 테스트 12 〉	통과 (0.44ms, 78.9MB)
// 테스트 13 〉	통과 (0.42ms, 74.7MB)
// 테스트 14 〉	통과 (0.46ms, 72.9MB)
// 테스트 15 〉	통과 (0.32ms, 72.1MB)
// 테스트 16 〉	통과 (0.36ms, 78MB)
// 테스트 17 〉	통과 (0.33ms, 78.8MB)
// 테스트 18 〉	통과 (0.31ms, 76.3MB)
// 테스트 19 〉	통과 (0.37ms, 74.9MB)
// 테스트 20 〉	통과 (0.28ms, 71.2MB)
// 테스트 21 〉	통과 (0.30ms, 72.6MB)
// 효율성  테스트
// 테스트 1 〉	통과 (8.34ms, 54.4MB)
// 테스트 2 〉	통과 (4.21ms, 56.3MB)
// 테스트 3 〉	통과 (6.33ms, 56.3MB)
// 테스트 4 〉	통과 (6.40ms, 52.8MB)
