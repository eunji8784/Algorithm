import java.util.*;

class Solution {
    private static final int N = 102;
    private static final int[] DX = {-1, 1, 0, 0}; 
    private static final int[] DY = {0, 0, -1, 1};
    
    private static class Location {
        int x, y, dist;
        
        public Location(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        char[][] map = new char[N][N];
        
        for (int[] coordinate : rectangle) {
            int x1 = coordinate[0] * 2;
            int y1 = coordinate[1] * 2;
            int x2 = coordinate[2] * 2;
            int y2 = coordinate[3] * 2;
            
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (x1 < i && i < x2 && y1 < j && j < y2) {
                        map[i][j] = '0';
                        continue;
                    }
                    if (map[i][j] != '0') {
                        map[i][j] = '1';
                    }
                }
            }
        }
        
        return bfs(map, characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }
    
    private static int bfs(char[][] map, int characterX, int characterY, int itemX, int itemY) {
        Queue<Location> que = new LinkedList<>();
        que.offer(new Location(characterX, characterY, 0));
        map[characterX][characterY] = 0;
        
        while (!que.isEmpty()) {
            Location cur = que.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + DX[i];
                int ny = cur.y + DY[i];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                
                if (map[nx][ny] == '1') {
                    if (nx == itemX && ny == itemY) {
                        return cur.dist + 1;
                    }
                    que.offer(new Location(nx, ny, cur.dist + 1));
                    map[nx][ny] = 0;
                }
            }
        }
        
        return -1;
    }
}

// 테스트 1 〉	통과 (0.32ms, 73.3MB)
// 테스트 2 〉	통과 (0.32ms, 74.2MB)
// 테스트 3 〉	통과 (0.33ms, 72.9MB)
// 테스트 4 〉	통과 (0.43ms, 75.8MB)
// 테스트 5 〉	통과 (0.36ms, 84.9MB)
// 테스트 6 〉	통과 (0.39ms, 75MB)
// 테스트 7 〉	통과 (0.46ms, 78.1MB)
// 테스트 8 〉	통과 (0.70ms, 74.3MB)
// 테스트 9 〉	통과 (1.08ms, 78.7MB)
// 테스트 10 〉	통과 (0.77ms, 71.2MB)
// 테스트 11 〉	통과 (1.05ms, 73.5MB)
// 테스트 12 〉	통과 (1.03ms, 74.9MB)
// 테스트 13 〉	통과 (1.15ms, 77.6MB)
// 테스트 14 〉	통과 (0.49ms, 77.2MB)
// 테스트 15 〉	통과 (0.49ms, 80.6MB)
// 테스트 16 〉	통과 (0.79ms, 71.4MB)
// 테스트 17 〉	통과 (0.82ms, 78.5MB)
// 테스트 18 〉	통과 (1.19ms, 75.1MB)
// 테스트 19 〉	통과 (1.07ms, 73.9MB)
// 테스트 20 〉	통과 (1.12ms, 76.8MB)
// 테스트 21 〉	통과 (0.80ms, 77.8MB)
// 테스트 22 〉	통과 (1.71ms, 75.6MB)
// 테스트 23 〉	통과 (0.77ms, 76.3MB)
// 테스트 24 〉	통과 (0.66ms, 70MB)
// 테스트 25 〉	통과 (0.41ms, 76.8MB)
// 테스트 26 〉	통과 (0.41ms, 72.2MB)
// 테스트 27 〉	통과 (0.61ms, 69.2MB)
// 테스트 28 〉	통과 (0.45ms, 75.5MB)
// 테스트 29 〉	통과 (0.55ms, 75MB)
// 테스트 30 〉	통과 (0.52ms, 79.9MB)
