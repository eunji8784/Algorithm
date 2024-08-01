import java.util.*;

class Solution {
    private static int answer;
    
    public int solution(int n) {
        answer = 0;
        backtracking(0, new int[n], n);
        return answer;
    }

    private static void backtracking(int col, int[] board, int n) {
        if (col == n) {
            answer++;
            return;
        }

        for (int row = 0; row < n; row++) {
            board[col] = row;
            if (check(col, board)) {
                backtracking(col + 1, board, n);
            }
        }
    }

    private static boolean check(int col, int[] board) {
        for (int i = 0; i < col; i++) {
            if (board[i] == board[col] || Math.abs(i - col) == Math.abs(board[i] - board[col])) {
                return false;
            }
        }
        return true;
    }
}

// 테스트 1 〉	통과 (0.02ms, 71.3MB)
// 테스트 2 〉	통과 (0.04ms, 71.2MB)
// 테스트 3 〉	통과 (0.04ms, 79.9MB)
// 테스트 4 〉	통과 (0.14ms, 74.3MB)
// 테스트 5 〉	통과 (0.35ms, 73.4MB)
// 테스트 6 〉	통과 (0.61ms, 76.8MB)
// 테스트 7 〉	통과 (1.70ms, 78MB)
// 테스트 8 〉	통과 (4.45ms, 67.4MB)
// 테스트 9 〉	통과 (13.79ms, 72.6MB)
// 테스트 10 〉	통과 (40.29ms, 76.2MB)
// 테스트 11 〉	통과 (175.57ms, 83.7MB)
