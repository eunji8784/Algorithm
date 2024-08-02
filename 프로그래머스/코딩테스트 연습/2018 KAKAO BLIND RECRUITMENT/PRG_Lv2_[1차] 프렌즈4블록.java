import java.util.*;

class Solution {
    private static char[][] map, copy;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new char[m][n];
        
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();    
        }

        while (true) {
            int removeCnt = removeBlock(m, n);
            if (removeCnt == 0) break;
            answer += removeCnt;
            dropBlock(m, n, map);
        }

        return answer;
    }

    private static int removeBlock(int m, int n) {
        copy = new char[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(map[i], 0, copy[i], 0 , n);
        }

        int removeCnt = 0;

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char chr = map[i][j];
                
                if (chr == '.') continue;
                
                if (map[i + 1][j] == chr && map[i][j + 1] == chr && map[i + 1][j + 1] == chr) {
                    if (copy[i][j] != '.') {
                        copy[i][j] = '.';
                        removeCnt++;
                    }
                    if (copy[i + 1][j] != '.') {
                        copy[i + 1][j] = '.';
                        removeCnt++;
                    }
                    if (copy[i][j + 1] != '.') {
                        copy[i][j + 1] = '.';
                        removeCnt++;
                    }
                    if (copy[i + 1][j + 1] != '.') {
                        copy[i + 1][j + 1] = '.';
                        removeCnt++;
                    }
                }
            }
        }

        map = copy;

        return removeCnt;
    }

    private static void dropBlock(int m, int n, char[][] map) {
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '.') continue;
                
                int nx = i;
                boolean flag = false;
                
                while (++nx < m && map[nx][j] == '.') {
                    flag = true;
                }

                if (flag) {
                    map[--nx][j] = map[i][j];
                    map[i][j] = '.';
                }
            }
        }
    }
}

// 테스트 1 〉	통과 (0.05ms, 76.2MB)
// 테스트 2 〉	통과 (0.04ms, 74.1MB)
// 테스트 3 〉	통과 (0.05ms, 70.1MB)
// 테스트 4 〉	통과 (0.19ms, 78.4MB)
// 테스트 5 〉	통과 (10.12ms, 77.8MB)
// 테스트 6 〉	통과 (1.86ms, 70.8MB)
// 테스트 7 〉	통과 (0.12ms, 77.2MB)
// 테스트 8 〉	통과 (0.24ms, 73.3MB)
// 테스트 9 〉	통과 (0.03ms, 77.7MB)
// 테스트 10 〉	통과 (0.17ms, 77.9MB)
// 테스트 11 〉	통과 (0.28ms, 78.4MB)
