import java.util.*;

class Solution {
    private static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private static int n;
    private static boolean[][] vst;
    private static List<List<int[]>> puzzles = new ArrayList<>();
    
    private static class Location {
        int x, y;
        
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;
        vst = new boolean[n][n];
        int answer = 0;
        
        // 퍼즐들 구하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vst[i][j] && table[i][j] == 1) {
                    getPuzzle(i, j, table);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(vst[i], false);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vst[i][j] && game_board[i][j] == 0) {
                    answer += matchPuzzle(i, j, game_board);
                }
            }
        }
        
        return answer;
    }
    
    private static int matchPuzzle(int x, int y, int[][] game_board) {
        List<int[]> board = new ArrayList<>();
        board.add(new int[]{x, y});
        Queue<Location> que = new LinkedList<>();
        que.offer(new Location(x, y));
        vst[x][y] = true;
        
        while (!que.isEmpty()) {
            Location cur = que.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + DIR[i][0];
                int ny = cur.y + DIR[i][1];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || vst[nx][ny]) {
                    continue;
                }
                
                if (game_board[nx][ny] == 0) {
                    que.offer(new Location(nx, ny));
                    vst[nx][ny] = true;
                    board.add(new int[] {nx, ny});
                }
            }
        }
        
        Collections.sort(board, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        
        for (int num = 0; num < puzzles.size(); num++) {
            List<int[]> puzzle = puzzles.get(num);
            int size = puzzle.size();
            if (size != board.size()) {
                continue;
            }
            
            boolean flag = true;
            
            for (int rotateCnt = 0; rotateCnt < 4; rotateCnt++) {
                Collections.sort(puzzle, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if (o1[0] == o2[0]) {
                            return o1[1] - o2[1];
                        }
                        return o1[0] - o2[0];
                    }
                });
                flag = true;
                int[] one = puzzle.get(0);
                int[] two = board.get(0);
                for (int idx = 1; idx < puzzle.size(); idx++) {
                    if (one[0] - puzzle.get(idx)[0] != two[0] - board.get(idx)[0] || one[1] - puzzle.get(idx)[1] != two[1] - board.get(idx)[1]) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    if (rotateCnt < 4) {
                        rotatePuzzle(puzzle);
                    }
                } else {
                    puzzles.remove(num);
                    return size;
                }
            }
        }
        
        return 0;
    }
    
    private static void rotatePuzzle(List<int[]> puzzle) {
        for (int[] loc : puzzle) {
            int x = loc[0];
            int y = loc[1];
            loc[0] = -y;
            loc[1] = x;
        }
    }
    
    private static void getPuzzle(int x, int y, int[][] table) {
        List<int[]> lst = new ArrayList<>();
        lst.add(new int[]{0, 0});
        Queue<Location> que = new LinkedList<>();
        que.offer(new Location(x, y));
        vst[x][y] = true;
        
        while (!que.isEmpty()) {
            Location cur = que.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + DIR[i][0];
                int ny = cur.y + DIR[i][1];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || vst[nx][ny]) {
                    continue;
                }
                
                if (table[nx][ny] == 1) {
                    que.offer(new Location(nx, ny));
                    vst[nx][ny] = true;
                    lst.add(new int[] {nx - x, ny - y});
                }
            }
        }
        
        puzzles.add(lst);
    }
}

// 테스트 1 〉	통과 (1.42ms, 78.1MB)
// 테스트 2 〉	통과 (1.15ms, 71.1MB)
// 테스트 3 〉	통과 (1.25ms, 75.3MB)
// 테스트 4 〉	통과 (1.05ms, 72.3MB)
// 테스트 5 〉	통과 (1.26ms, 73.6MB)
// 테스트 6 〉	통과 (3.60ms, 74.2MB)
// 테스트 7 〉	통과 (4.28ms, 72.9MB)
// 테스트 8 〉	통과 (6.12ms, 72.9MB)
// 테스트 9 〉	통과 (3.86ms, 73.1MB)
// 테스트 10 〉	통과 (15.49ms, 72.1MB)
// 테스트 11 〉	통과 (13.31ms, 81MB)
// 테스트 12 〉	통과 (9.95ms, 77MB)
// 테스트 13 〉	통과 (7.77ms, 74.8MB)
// 테스트 14 〉	통과 (1.18ms, 80.3MB)
// 테스트 15 〉	통과 (2.73ms, 83.9MB)
// 테스트 16 〉	통과 (1.11ms, 76MB)
// 테스트 17 〉	통과 (1.38ms, 79.3MB)
// 테스트 18 〉	통과 (0.95ms, 76MB)
// 테스트 19 〉	통과 (0.97ms, 75.9MB)
// 테스트 20 〉	통과 (1.00ms, 82.9MB)
// 테스트 21 〉	통과 (0.95ms, 76.1MB)
// 테스트 22 〉	통과 (0.89ms, 79.2MB)
